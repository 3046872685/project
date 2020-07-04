package com.accp.dao;

import com.accp.domain.Dztable;
import com.accp.domain.DztableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DztableMapper {
    int countByExample(DztableExample example);

    int deleteByExample(DztableExample example);

    int deleteByPrimaryKey(Integer dzid);

    int insert(Dztable record);

    int insertSelective(Dztable record);

    List<Dztable> selectByExample(DztableExample example);

    Dztable selectByPrimaryKey(Integer dzid);

    int updateByExampleSelective(@Param("record") Dztable record, @Param("example") DztableExample example);

    int updateByExample(@Param("record") Dztable record, @Param("example") DztableExample example);

    int updateByPrimaryKeySelective(Dztable record);

    int updateByPrimaryKey(Dztable record);
}