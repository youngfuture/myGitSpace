package com.enjoylearning.mybatis.mapper;

import com.enjoylearning.mybatis.entity.THealthReportFemale;
import java.util.List;

public interface THealthReportFemaleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_female
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_female
     *
     * @mbggenerated
     */
    int insert(THealthReportFemale record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_female
     *
     * @mbggenerated
     */
    THealthReportFemale selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_female
     *
     * @mbggenerated
     */
    List<THealthReportFemale> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_health_report_female
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(THealthReportFemale record);
}