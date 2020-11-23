package com.zboot.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.common.result.ResultPage;
import com.zboot.modules.system.domain.SysLog;
import com.zboot.modules.system.domain.vo.SysLogVo;
import com.zboot.modules.system.service.SysLogService;
import com.zboot.common.result.CodeMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@Slf4j
@RequestMapping("system")
@Api(value = "系统日志",tags = "系统日志")
public class SysLogController {

    @Autowired
    SysLogService sysLogService;

    @ApiOperation(value = "系统日志分页查询")
    @GetMapping(value = "log")
    public ResultPage login(SysLogVo sysLogVo,
                            @RequestParam(defaultValue = "1") int pageNum,
                            @RequestParam(defaultValue = "10") int pageSize) {
        IPage<SysLog> result = sysLogService.getSysLog(sysLogVo, pageNum, pageSize);
        return ResultPage.sucess(CodeMsg.SUCESS,result);
    }
}
