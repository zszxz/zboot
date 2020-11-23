package com.zboot.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zboot.common.utils.QueryWraperUtils;
import com.zboot.modules.system.domain.SysLog;
import com.zboot.modules.system.domain.vo.SysLogVo;
import com.zboot.modules.system.mapper.SysLogMapper;
import com.zboot.modules.system.service.SysLogService;
import com.zboot.common.utils.IPUtils;
import com.zboot.common.utils.SpringContextUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lsc
 * <p> </p>
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogMapper sysLogMapper;

    @Override
    public IPage<SysLog> getSysLog(SysLogVo sysLogVo, int  pageNum, int pageSize) {
        Page<SysLog> page = new Page<>(pageNum, pageSize);
        QueryWrapper<SysLog> queryWrapper = QueryWraperUtils.getQueryWrapper(sysLogVo);
        return sysLogMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addSysLog(SysLog sysLog) {
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        String ipAddr = IPUtils.getIpAddress(request);
        sysLog.setIpaddress(ipAddr);
        sysLog.setUsageTime("1");
        return sysLogMapper.insert(sysLog);
    }

}
