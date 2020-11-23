package com.zboot.modules.system.domain.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
public class SysRoleVo {

    private String roleName;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginCreateTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endCreateTime;

    private List<String> orderBy;
}
