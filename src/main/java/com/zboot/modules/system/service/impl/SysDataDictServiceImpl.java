package com.zboot.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zboot.common.utils.QueryWraperUtils;
import com.zboot.modules.system.domain.SysDataDict;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysDataDictVo;
import com.zboot.modules.system.mapper.SysDataDictMapper;
import com.zboot.modules.system.service.SysDataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lsc
 * <p> </p>
 */
@Service
public class SysDataDictServiceImpl implements SysDataDictService {

    @Autowired
    SysDataDictMapper sysDataDictMapper;

    @Override
    public IPage<SysDataDict> getSysDataDict(SysDataDictVo sysDataDictVo, Integer pageNum, Integer pageSize) {
        Page<SysDataDict> page = new Page<>(pageNum, pageSize);
        QueryWrapper<SysDataDict> queryWrapper = QueryWraperUtils.getQueryWrapper(sysDataDictVo);
        return sysDataDictMapper.selectPage(page, queryWrapper);
    }

    @Override
    public SysDataDict getSysDataDictById(Long id) {
        return sysDataDictMapper.selectById(id);
    }

    @Override
    public int addSysDataDict(SysDataDict sysDataDict) {

        return sysDataDictMapper.insert(sysDataDict);
    }

    @Override
    public int updateSysDataDict(SysDataDict sysDataDict) {

        return sysDataDictMapper.updateById(sysDataDict);
    }

    @Override
    public int deleteSysDataDict(Long id) {

        return sysDataDictMapper.deleteById(id);
    }
}
