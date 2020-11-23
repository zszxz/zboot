package com.zboot.modules.system.service;

import com.zboot.modules.system.domain.SysDep;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysDepUserVo;

import java.util.List;
import java.util.Set;

/**
 * @Author lsc
 * <p> </p>
 */
public interface SysDepService {

    /* *
     * @Author lsc
     * <p>获取部门树 </p>
     * @Param []
     * @Return
     */
    Set<SysDep> getDepTree();

    /* *
     * @Author lsc
     * <p> 通过部门编号获取部门 </p>
     * @Param [depId]
     * @Return
     */
    SysDep getSysDepById(Long depId);

    /* *
     * @Author lsc
     * <p> 通过部门编号获取所有用户 </p>
     * @Param [depId]
     * @Return
     */
    List<SysUser> getUserByDepId(Long depId);

    /* *
     * @Author lsc
     * <p>添加部门 </p>
     * @Param [sysDep]
     * @Return
     */
    int addDep(SysDep sysDep);

    /* *
     * @Author lsc
     * <p> 修改部门</p>
     * @Param [sysDep]
     * @Return
     */
    int updateDep(SysDep sysDep);

    /* *
     * @Author lsc
     * <p>删除部门 </p>
     * @Param [id]
     * @Return
     */
    int deleteDep(Long id);

    /* *
     * @Author lsc
     * <p>删除部门用户关联 </p>
     * @Param [depId, userId]
     * @Return
     */
    int deleteDepUser(Long depId, Long userId);

    /* *
     * @Author lsc
     * <p> 添加用户部门关联</p>
     * @Param [sysDepUserVo]
     * @Return
     */
    Integer addDepUser(SysDepUserVo sysDepUserVo);
}
