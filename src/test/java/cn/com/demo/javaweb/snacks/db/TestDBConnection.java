package cn.com.demo.javaweb.snacks.db;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hj
 * @time 2019年7月25日下午4:25:38
 * state：
 */
public class TestDBConnection {
	@Test
	public void testGetInstance() {
		DBConnection1 dbConn = DBConnection1.getInstance();
		Assert.assertNotNull(dbConn);
	}
	
	@Test
	public void testGetConnection() {
		DBConnection1 dbConn = DBConnection1.getInstance();
		Connection conn = dbConn.getConnection();
		Assert.assertNotNull(conn);
	}
} 
