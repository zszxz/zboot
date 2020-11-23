package com.zboot.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zboot.modules.system.domain.SysDep;
import com.zboot.modules.system.domain.SysLog;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysDepUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lsc
 * <p> </p>
 */
@Repository
@Mapper
public interface SysDepMapper extends BaseMapper<SysDep>  {

    List<SysUser> getUserByDepId(@Param("depId") Long depId);

    /* *
     * @Author lsc
     * <p>删除部门用户管理 </p>
     * @Param []
     * @Return
     */
    int deleteDepUser(@Param("depId") Long depId,@Param("userId") Long userId);

    int addDepUser(SysDepUserVo sysDepUserVo);
}
