package cn.com.demo.javaweb.snacks.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.snacks.dao.DAOFactory;
import cn.com.demo.javaweb.snacks.dao.IFoodDAO;
import cn.com.demo.javaweb.snacks.dao.IPictureDAO;
import cn.com.demo.javaweb.snacks.po.FoodPO;
import cn.com.demo.javaweb.snacks.po.PicturePO;
import cn.com.demo.javaweb.snacks.service.IFoodService;
import cn.com.demo.javaweb.snacks.util.Constant;
import cn.com.demo.javaweb.snacks.vo.FoodVO;

/**
 * @author hj
 * @time 2019年7月28日上午1:07:43 state：
 */
public class FoodServiceImpl implements IFoodService {
	private IPictureDAO picDAO = DAOFactory.buildDAOFactory().createPictureDAO();
	private IFoodDAO foodDAO = DAOFactory.buildDAOFactory().createFoodDAO();

	@Override
	public List<FoodVO> searchFoods(int currPageNo, String keyword) {
		List<FoodVO> foodList = null;
		// * 从数据库中，根据条件，查询出当前页面要显示的食品List
		// * 1 校验页码的有效性
		// * 1）基于DAO查询出符号条件的所有食品数量
		// * 2）根据每页显示的食品数，可以计算出总页码
		// * 3）根据总页码，调整有效的当前页码
		int sumCount = this.foodDAO.foodCount(keyword);
		// 计算总页码数
		int pageNumber = sumCount / Constant.PAGE_RECORD_COUNT;
		if (sumCount % Constant.PAGE_RECORD_COUNT != 0) {
			pageNumber++;
		}
		// 调整当前有效页码
		if (currPageNo <= 0) {
			currPageNo = 1;
		} else if (currPageNo >= pageNumber) {
			currPageNo = pageNumber;
		}
		// * 2 获取有效页码对应的食品List（PO）
		// * 1）调用DAO条件查询方法，获取PO List（当前页码）
		List<FoodPO> fdPOList = this.foodDAO.searchCurrPageFoods(currPageNo, Constant.PAGE_RECORD_COUNT, keyword);
		// * 3 将POList转变成VOList
		foodList = new ArrayList<FoodVO>();
		FoodVO vo=null;
        for (FoodPO po : fdPOList) {
			vo=new FoodVO(po);
			foodList.add(vo);
			//添加vo得picUrl和销售量
			List<PicturePO> picList=this.picDAO.findPictures(vo.getFdId(), Constant.PIC_TYPE_LISTIMG);//1表示列表图片
			if (picList!=null&&picList.size()==1) {
				vo.setListPicUrl(picList.get(0).getPicUrl());
			}
			//销售量
			int saleCount=this.foodDAO.findFoodSaleCount(vo.getFdId());
			vo.setSalesCount(saleCount);
			
		}
		return foodList;
	}

	public void setPicDAO(IPictureDAO picDAO) {
		this.picDAO = picDAO;
	}

	public void setFoodDAO(IFoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}

	@Override
	public FoodVO searchFoodById(int fdId) {
		return null;
	}

}
