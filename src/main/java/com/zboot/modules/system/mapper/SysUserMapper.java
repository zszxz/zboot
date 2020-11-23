package com.zboot.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zboot.modules.system.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
*
* @author lsc
* <p>
*    持久层
* </p>
*/
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {




    /* *
     * @Author lsc
     * <p> 根据用户名获取用户</p>
     * @Param [userName]
     */
    SysUser getUserByUserName(@Param("username") String username);




}