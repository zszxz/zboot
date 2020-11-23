package com.zboot.modules.system.controller;

import com.zboot.common.result.CodeMsg;
import com.zboot.common.result.ResultPage;
import com.zboot.modules.system.annotation.SystemLog;
import com.zboot.modules.system.domain.SysDep;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysDepUserVo;
import com.zboot.modules.system.eu.LogEnum;
import com.zboot.modules.system.service.SysDepService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@RequestMapping("system")
@Api(value = "系统部门",tags = "系统部门")
public class SysDepController {

    @Autowired
    SysDepService sysDepService;

    @ApiOperation(value = "获取部门树")
    @GetMapping("/dep/tree")
    public ResultPage getSysUser() {
        Set<SysDep> depTree = sysDepService.getDepTree();
        return ResultPage.sucess(CodeMsg.SUCESS,depTree);
    }

    @ApiOperation(value = "根据部门编号查询部门")
    @GetMapping("/dep/{depId}")
    public ResultPage getSysDepById(@PathVariable("depId") Long depId) {
        SysDep sysDep = sysDepService.getSysDepById(depId);
        return ResultPage.sucess(CodeMsg.SUCESS,sysDep);
    }

    @ApiOperation(value = "通过部门id获取所有用户")
    @GetMapping("/dep/user/{depId}")
    public ResultPage getUserByDepId(@PathVariable("depId") Long depId) {
        List<SysUser> userByDepId = sysDepService.getUserByDepId(depId);
        return ResultPage.sucess(CodeMsg.SUCESS,userByDepId);
    }

    @ApiOperation(value = "添加部门")
    @PostMapping("/dep")
    @RequiresPermissions("dep:add")
    @SystemLog(operateType= LogEnum.INSERT,value = "添加部门")
    public ResultPage addDep(@RequestBody SysDep sysDep){
        Integer integer = sysDepService.addDep(sysDep);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "修改部门")
    @PutMapping("/dep/{id}")
    @RequiresPermissions("dep:edit")
    @SystemLog(operateType= LogEnum.UPDATE,value = "修改部门")
    public ResultPage updateDep(@RequestBody SysDep sysDep, @PathVariable("id") Long id){
        sysDep.setId(id);
        Integer integer = sysDepService.updateDep(sysDep);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }


    @ApiOperation(value = "删除部门")
    @DeleteMapping("/dep/{id}")
    @RequiresPermissions("dep:delete")
    @SystemLog(operateType= LogEnum.DELETE,value = "删除部门")
    public ResultPage deleteDep( @PathVariable("id") Long id){
        Integer integer = sysDepService.deleteDep(id);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "删除部门用户关联")
    @DeleteMapping("/dep/{depId}/{userId}")
    @RequiresPermissions("dep:user")
    @SystemLog(operateType= LogEnum.DELETE,value = "删除部门用户关联")
    public ResultPage deleteDep( @PathVariable("depId") Long depId,  @PathVariable("userId") Long userId){
        Integer integer = sysDepService.deleteDepUser(depId, userId);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "添加部门用户关联")
    @PostMapping("/dep/user")
    @RequiresPermissions("dep:user")
    @SystemLog(operateType= LogEnum.INSERT,value = "添加部门用户关联")
    public ResultPage addDepUser(@RequestBody SysDepUserVo sysDepUserVo){
        Integer integer = sysDepService.addDepUser(sysDepUserVo);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }
}
