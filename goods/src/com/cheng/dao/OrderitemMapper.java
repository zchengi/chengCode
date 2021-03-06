package com.cheng.dao;

import com.cheng.domain.Orderitem;
import com.cheng.domain.OrderitemExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderitemMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int countByExample(OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int deleteByExample(OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int deleteByPrimaryKey(String orderitemid);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int insert(Orderitem record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int insertSelective(Orderitem record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    List<Orderitem> selectByExample(OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    Orderitem selectByPrimaryKey(String orderitemid);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int updateByExampleSelective(@Param("record") Orderitem record,
            @Param("example") OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int updateByExample(@Param("record") Orderitem record,
            @Param("example") OrderitemExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int updateByPrimaryKeySelective(Orderitem record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds
     * to the database table orderitem
     *
     * @mbggenerated Mon Jun 19 08:49:52 CST 2017
     */
    int updateByPrimaryKey(Orderitem record);

}