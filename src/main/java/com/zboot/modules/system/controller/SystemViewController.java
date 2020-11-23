package com.zboot.modules.system.controller;

import com.zboot.common.result.CodeMsg;
import com.zboot.common.result.ResultPage;
import com.zboot.common.utils.SystemInfoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@RequestMapping("system")
@Api(value = "系统监控",tags = "系统监控")
public class SystemViewController {

    @ApiOperation(value = "内存信息")
    @GetMapping("/memory/info")
    public ResultPage getMemInfo(){

        return ResultPage.sucess(CodeMsg.SUCESS,SystemInfoUtils.getMemInfo());
    }

    @ApiOperation(value = "cpu信息")
    @GetMapping("/cpu/info")
    public ResultPage getCpuInfo(){

        return ResultPage.sucess(CodeMsg.SUCESS,SystemInfoUtils.getCpuInfo());
    }

    @ApiOperation(value = "磁盘信息")
    @GetMapping("/disk/info")
    public ResultPage getSysFileInfo(){

        return ResultPage.sucess(CodeMsg.SUCESS,SystemInfoUtils.getSysFileInfo());
    }

    @ApiOperation(value = "jvm信息")
    @GetMapping("/jvm/info")
    public ResultPage getJvmInfo(){

        return ResultPage.sucess(CodeMsg.SUCESS,SystemInfoUtils.getJvmInfo());
    }

    @ApiOperation(value = "系统信息")
    @GetMapping("/sys/info")
    public ResultPage getSysInfo(){

        return ResultPage.sucess(CodeMsg.SUCESS,SystemInfoUtils.getSysInfo());
    }
}