package com.zboot.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*
* @author lsc
* <p>
*    持久层
* </p>
*/
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {



    /* *
     * @Author lsc
     * <p> 添加用户拥有的角色</p>
     * @Param [userRoles]
     */
    Integer addUserRole(@Param("userRoles") List<SysUserRole> userRoles);

    /* *
     * @Author lsc
     * <p>通过用户id获取所有角色 </p>
     * @Param [user_id]
     */
    List<SysRole> getUserRoles(Long userId);

    /* *
     * @Author lsc
     * <p> 删除用户角色关联</p>
     * @Param [user_id]
     */
    Integer deleteUserRole(Long userId);




}