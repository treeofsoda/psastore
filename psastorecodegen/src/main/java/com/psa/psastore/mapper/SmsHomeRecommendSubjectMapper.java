package com.psa.psastore.mapper;

import com.psa.psastore.model.SmsHomeRecommendSubject;
import com.psa.psastore.model.SmsHomeRecommendSubjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsHomeRecommendSubjectMapper {
    long countByExample(SmsHomeRecommendSubjectExample example);

    int deleteByExample(SmsHomeRecommendSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeRecommendSubject row);

    int insertSelective(SmsHomeRecommendSubject row);

    List<SmsHomeRecommendSubject> selectByExample(SmsHomeRecommendSubjectExample example);

    SmsHomeRecommendSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SmsHomeRecommendSubject row, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByExample(@Param("row") SmsHomeRecommendSubject row, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByPrimaryKeySelective(SmsHomeRecommendSubject row);

    int updateByPrimaryKey(SmsHomeRecommendSubject row);
}