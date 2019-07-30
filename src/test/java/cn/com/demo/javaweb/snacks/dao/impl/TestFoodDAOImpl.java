package cn.com.demo.javaweb.snacks.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.demo.javaweb.snacks.dao.DAOFactory;
import cn.com.demo.javaweb.snacks.dao.IFoodDAO;
import cn.com.demo.javaweb.snacks.po.FoodPO;

/**
 * @author hj
 * @time 2019年7月26日上午2:55:38
 * state：
 */
public class TestFoodDAOImpl {
	private IFoodDAO foodDAO;
	@Before
	public void before() {
		this.foodDAO = DAOFactory.buildDAOFactory().createFoodDAO();
	}
	@Test
    public void testFoodCount() {
    	int count= this.foodDAO.foodCount(null);
    	Assert.assertEquals(11, count);
    	count = this.foodDAO.foodCount("坚果1");
    	Assert.assertEquals(2, count);
    }
	@Test
	public void testSearchCurrPageFoods() {
		List<FoodPO> foodList = this.foodDAO.searchCurrPageFoods(1, 4, null);
		Assert.assertTrue(foodList.size()==4 && foodList.get(3).getFdId()==4);
	}
}
