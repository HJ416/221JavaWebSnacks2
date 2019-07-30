package cn.com.demo.javaweb.snacks.dao;

import java.util.List;

import cn.com.demo.javaweb.snacks.po.PicturePO;

/**
 * @author hj
 * @time 2019年7月26日上午9:25:39
 * state：
 */
public interface IPictureDAO {
      public List<PicturePO> findPictures(int fdId,int picType);
}
