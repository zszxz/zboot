package com.zboot.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zboot.modules.system.domain.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author lsc
 * <p> </p>
 */
@Repository
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

}
