package com.psa.psastore.mapper;

import com.psa.psastore.model.CmsTopicComment;
import com.psa.psastore.model.CmsTopicCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsTopicCommentMapper {
    long countByExample(CmsTopicCommentExample example);

    int deleteByExample(CmsTopicCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsTopicComment row);

    int insertSelective(CmsTopicComment row);

    List<CmsTopicComment> selectByExample(CmsTopicCommentExample example);

    CmsTopicComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CmsTopicComment row, @Param("example") CmsTopicCommentExample example);

    int updateByExample(@Param("row") CmsTopicComment row, @Param("example") CmsTopicCommentExample example);

    int updateByPrimaryKeySelective(CmsTopicComment row);

    int updateByPrimaryKey(CmsTopicComment row);
}