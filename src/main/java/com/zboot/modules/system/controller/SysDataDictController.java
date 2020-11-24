package com.zboot.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.common.result.CodeMsg;
import com.zboot.common.result.ResultPage;
import com.zboot.modules.system.annotation.SystemLog;
import com.zboot.modules.system.domain.SysDataDict;
import com.zboot.modules.system.domain.vo.SysDataDictVo;
import com.zboot.modules.system.eu.LogEnum;
import com.zboot.modules.system.service.SysDataDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@RequestMapping("system")
@Api(value = "数据字典",tags = "数据字典")
public class SysDataDictController {

    @Autowired
    SysDataDictService sysDataDictService;

    @ApiOperation(value = "数据字典分页查询")
    @GetMapping("/data/dict/page")
    public ResultPage getSysDataDict(SysDataDictVo sysDataDictVo,
                                     @RequestParam(defaultValue = "1") int pageNum,
                                     @RequestParam(defaultValue = "10") int pageSize) {
        IPage<SysDataDict> result = sysDataDictService.getSysDataDict(sysDataDictVo,pageNum,pageSize);
        return ResultPage.sucess(CodeMsg.SUCESS,result);
    }

    @ApiOperation(value = "通过编号查询数据字典")
    @GetMapping("/data/dict/{id}")
    public ResultPage getSysDataDictById(@PathVariable("id") Long id) {
        SysDataDict result = sysDataDictService.getSysDataDictById(id);
        return ResultPage.sucess(CodeMsg.SUCESS,result);
    }

    @ApiOperation(value = "添加数据字典")
    @PostMapping("data/dict")
    @RequiresPermissions("dict:add")
    @SystemLog(operateType= LogEnum.INSERT,value = "添加数据字典")
    public ResultPage addSysDataDict(@RequestBody SysDataDict sysDataDict){
        Integer integer = sysDataDictService.addSysDataDict(sysDataDict);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "修改数据字典")
    @PutMapping("data/dict/{id}")
    @RequiresPermissions("dict:edit")
    @SystemLog(operateType= LogEnum.UPDATE,value = "修改数据字典")
    public ResultPage updateSysDataDict(@RequestBody SysDataDict sysDataDict, @PathVariable("id") Long id){
        sysDataDict.setId(id);
        Integer integer = sysDataDictService.updateSysDataDict(sysDataDict);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }


    @ApiOperation(value = "删除数据字典")
    @DeleteMapping("data/dict/{id}")
    @RequiresPermissions("dict:delete")
    @SystemLog(operateType= LogEnum.DELETE,value = "删除数据字典")
    public ResultPage deleteSysDataDict( @PathVariable("id") Long id){
        Integer integer = sysDataDictService.deleteSysDataDict(id);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }
}
