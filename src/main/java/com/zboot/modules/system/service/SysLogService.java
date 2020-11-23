package com.zboot.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.modules.system.domain.SysLog;
import com.zboot.modules.system.domain.vo.SysLogVo;

/**
 * @Author lsc
 * <p> </p>
 */
public interface SysLogService {

    IPage<SysLog> getSysLog(SysLogVo sysLogVo, int  pageNum, int pageSize);

    int addSysLog(SysLog sysLog);
}
