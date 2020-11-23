package com.zboot.modules.system.asp;


import com.zboot.modules.system.annotation.SystemLog;
import com.zboot.modules.system.domain.SysLog;
import com.zboot.modules.system.eu.LogEnum;
import com.zboot.modules.system.mapper.SysLogMapper;
import com.zboot.common.utils.IPUtils;
import com.zboot.common.utils.JwtUtil;
import com.zboot.common.utils.SpringContextUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author lsc
 * <p>日志aop切面 </p>
 */

@Aspect
@Component
public class LogAsp {

    @Autowired
    SysLogMapper sysLogMapper;

    /* *
     * @Author lsc
     * <p> 设置切点</p>
     * @Param []
     * @Return void
     */
    @Pointcut("@annotation(com.zboot.modules.system.annotation.SystemLog)")
    public void logPointCut() {

    }

    // 环绕通知
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        Long endTime = System.currentTimeMillis();
        long millis = endTime - beginTime;
        saveLog(point,millis);
        return result;
    }

    private void  saveLog(ProceedingJoinPoint point, long seconds){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SystemLog monitorLog = method.getAnnotation(SystemLog.class);
        if (monitorLog!=null){
            LogEnum operateType = monitorLog.operateType();
            String value = monitorLog.value();
            String content = "";
            if (StringUtils.isNotBlank(value)){
                content = operateType.getOperate()+":"+value;
            }else {
                content = operateType.getOperate();
            }
            HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
            String ipAddr = IPUtils.getIpAddress(request);
            String token = request.getHeader("token");
            String userNameByToken = JwtUtil.getUserNameByToken(token);
            SysLog sysLog = new SysLog();
            sysLog.setOprator(content);
            sysLog.setUsername(userNameByToken);
            sysLog.setUsageTime(String.valueOf(seconds));
            sysLog.setIpaddress(ipAddr);
            sysLogMapper.insert(sysLog);
        }
    }
}
