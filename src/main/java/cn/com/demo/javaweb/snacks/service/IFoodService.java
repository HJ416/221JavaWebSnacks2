package cn.com.demo.javaweb.snacks.service;

import java.util.List;

import cn.com.demo.javaweb.snacks.vo.FoodVO;

public interface IFoodService {
	/**
	 * 从数据库中，根据条件，查询出当前页面要显示的食品List
	 * 1 校验页码的有效性
	 *   1）基于DAO查询出符号条件的所有食品数量
	 *   2）根据每页显示的食品数，可以计算出总页码
	 *   3）根据总页码，调整有效的当前页码
	 * 2 获取有效页码对应的食品List（PO）
	 *   1）调用DAO条件查询方法，获取PO List（当前页码）
	 * 3 将POList转变成VOList
	 * */
     public List<FoodVO> searchFoods(int currPageNo, String keyword);
    
     /**
      *根据id查询对应零食的详细信息--->detail.jsp
      *1.fdId找到FoodPO对象
      *2.给foodVO添加vo的picUrl和销售量
      * 
      */
     public FoodVO searchFoodById(int fdId);
}
