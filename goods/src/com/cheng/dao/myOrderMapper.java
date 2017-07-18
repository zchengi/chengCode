package com.cheng.dao;

import com.cheng.domain.myOrder;
import com.cheng.domain.myOrderExample;
import com.cheng.order.povo.DingdanPovo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface myOrderMapper {
	List<DingdanPovo> selectAll();

	DingdanPovo selectByOid(String oid);

	void updateDindans(Map<String, Object> map);

	List<DingdanPovo> selectdingdanbyuid(String uid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int countByExample(myOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int deleteByExample(myOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int deleteByPrimaryKey(String oid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int insert(myOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int insertSelective(myOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	List<myOrder> selectByExample(myOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	myOrder selectByPrimaryKey(String oid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int updateByExampleSelective(@Param("record") myOrder record,
			@Param("example") myOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int updateByExample(@Param("record") myOrder record,
			@Param("example") myOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int updateByPrimaryKeySelective(myOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table myorder
	 *
	 * @mbggenerated Tue Jun 27 10:48:43 CST 2017
	 */
	int updateByPrimaryKey(myOrder record);

	List<DingdanPovo> selectByStatus(int status);


}