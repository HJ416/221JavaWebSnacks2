package cn.com.demo.javaweb.snacks.dao;

import java.sql.Timestamp;
import java.util.List;

import cn.com.demo.javaweb.snacks.po.PromotionPO;

/**
 * @author hj
 * @time 2019年7月28日下午4:35:54 state：
 */
public interface IPromotionDAO {
	// 正在进行中的活动
	public List<PromotionPO> findPromotions(int fdId);

	// 查询除同begin-end重叠的所有活动
	public List<PromotionPO> findPromotions(int fdId, Timestamp begin, Timestamp end);
}
