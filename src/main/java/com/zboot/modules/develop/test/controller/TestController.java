package com.zboot.modules.develop.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zboot.common.result.CodeMsg;
import com.zboot.common.result.ResultPage;
import com.zboot.common.utils.QueryWraperUtils;
import com.zboot.modules.develop.test.domain.vo.TestVo;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.mapper.SysUserMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@RequestMapping("test")
@Api(value = "测试",tags = "测试")
public class TestController {

    @Autowired
    SysUserMapper sysUserMapper;

    @GetMapping("param")
    public ResultPage<Object> test(TestVo testVo){
        QueryWrapper<SysUser> queryWrapper = QueryWraperUtils.getQueryWrapper(testVo);
        sysUserMapper.selectList(queryWrapper);
        return ResultPage.sucess(CodeMsg.SUCESS,queryWrapper);
    }
}
