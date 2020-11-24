package com.zboot.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.modules.system.domain.SysDataDict;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysDataDictVo;
import com.zboot.modules.system.domain.vo.SysUserVo;

/**
 * @Author lsc
 * <p> </p>
 */
public interface SysDataDictService {

    /* *
     * @Author lsc
     * <p>数据字典分页查询 </p>
     * @Param [sysDataDictVo, pageNum, pageSize]
     * @Return
     */
    IPage<SysDataDict> getSysDataDict (SysDataDictVo sysDataDictVo, Integer pageNum, Integer pageSize);

    /* *
     * @Author lsc
     * <p> 通过编号查询数据字典</p>
     * @Param [id]
     * @Return
     */
    SysDataDict getSysDataDictById(Long id);


    /* *
     * @Author lsc
     * <p>添加数据字典 </p>
     * @Param [sysDataDict]
     * @Return
     */
    int addSysDataDict(SysDataDict sysDataDict);

    /* *
     * @Author lsc
     * <p>  更新数据字典</p>
     * @Param [sysDataDict]
     * @Return
     */
    int updateSysDataDict(SysDataDict sysDataDict);

    /* *
     * @Author lsc
     * <p>删除数据字典 </p>
     * @Param [id]
     * @Return
     */
    int deleteSysDataDict(Long id);


}
