package com.zboot.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zboot.common.exception.ZBootException;
import com.zboot.modules.system.domain.SysDep;
import com.zboot.modules.system.domain.SysMenu;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysDepUserVo;
import com.zboot.modules.system.mapper.SysDepMapper;
import com.zboot.modules.system.service.SysDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.zboot.common.result.CodeMsg.parent_ERROR;

/**
 * @Author lsc
 * <p>部门管理 </p>
 */
@Service
public class SysDepServiceImpl implements SysDepService {

    @Autowired
    SysDepMapper sysDepMapper;

    @Override
    public Set<SysDep> getDepTree() {
        QueryWrapper<SysDep> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<SysDep> sysDepList = sysDepMapper.selectList(queryWrapper);
        return buildTree(sysDepList,-1L);
    }

    @Override
    public SysDep getSysDepById(Long depId) {
        return sysDepMapper.selectById(depId);
    }

    @Override
    public List<SysUser> getUserByDepId(Long depId) {
        return sysDepMapper.getUserByDepId(depId);
    }

    @Override
    public int addDep(SysDep sysDep) {

        return sysDepMapper.insert(sysDep);
    }

    @Override
    public int updateDep(SysDep sysDep) {

        return sysDepMapper.updateById(sysDep);
    }

    @Transactional
    @Override
    public int deleteDep(Long id) {
        QueryWrapper<SysDep> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        int count = sysDepMapper.selectCount(wrapper);
        if (count>0){
            throw new ZBootException(parent_ERROR);
        }
        // 删除部门用户关联
        sysDepMapper.deleteDepUser(id,null);
        return sysDepMapper.deleteById(id);
    }

    @Override
    public int deleteDepUser(Long depId, Long userId) {
        return sysDepMapper.deleteDepUser(depId,userId);
    }

    @Override
    public Integer addDepUser(SysDepUserVo sysDepUserVo) {
        return sysDepMapper.addDepUser(sysDepUserVo);
    }


    private Set<SysDep> buildTree(List<SysDep> depList, Long pid) {
        Set<SysDep> treeList = new LinkedHashSet<>();
        depList.forEach(dep -> {
            if (Objects.equals(pid, dep.getParentId())) {
                dep.setChildren(buildTree(depList, dep.getId()));
                treeList.add(dep);
            }
        });
        return treeList;
    }
}
