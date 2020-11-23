package com.zboot.modules.develop.test.domain.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
public class TestVo {

    //private String name;

    private Boolean enable;

    private List  name;

    private List orderBy;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginCreateTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endCreateTime;
}
