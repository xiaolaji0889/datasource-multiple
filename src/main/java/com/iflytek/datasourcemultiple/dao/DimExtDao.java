package com.iflytek.datasourcemultiple.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iflytek.datasourcemultiple.entity.DimExtDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DimExtDao extends BaseMapper<DimExtDTO> {

    /**
     * 样例查询
     * @return List<DimExtDao>
     */
    List<DimExtDTO> demoSelect();

}
