package com.zboot.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zboot.common.utils.PasswordUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author lsc
 * <p> </p>
 */
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    /**
     * 添加操作的时候运行(会将createTime和updateTime加入到数据库中）
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("createBy", PasswordUtils.getUserName(), metaObject);
        this.setFieldValByName("updateBy", PasswordUtils.getUserName(), metaObject);
    }

    /**
     * 修改操作的时候运行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateBy", PasswordUtils.getUserName(), metaObject);
    }
}
