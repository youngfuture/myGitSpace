package com.enjoylearning.mybatis.mapper;

import com.enjoylearning.mybatis.entity.THealthReportMale;
import java.util.List;

public interface THealthReportMaleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbggenerated
     */
    int insert(THealthReportMale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbggenerated
     */
    THealthReportMale selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbggenerated
     */
    List<THealthReportMale> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_male
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(THealthReportMale record);
}