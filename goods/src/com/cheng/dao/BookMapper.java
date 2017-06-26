package com.cheng.dao;

import com.cheng.domain.Book;
import com.cheng.domain.BookExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BookMapper {
	List<Book> selectByCidForAllBook(String cid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int countByExample(BookExample example);

	List<Book> selectForBooks(Book book);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int deleteByExample(BookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int deleteByPrimaryKey(String bid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int insert(Book record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int insertSelective(Book record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	List<Book> selectByExample(BookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	Book selectByPrimaryKey(String bid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Book record,
			@Param("example") BookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int updateByExample(@Param("record") Book record,
			@Param("example") BookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int updateByPrimaryKeySelective(Book record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table book
	 *
	 * @mbggenerated Thu Jun 22 08:35:00 CST 2017
	 */
	int updateByPrimaryKey(Book record);

}