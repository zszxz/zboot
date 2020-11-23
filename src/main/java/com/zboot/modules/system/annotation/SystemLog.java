package com.zboot.modules.system.annotation;



import com.zboot.modules.system.eu.LogEnum;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {

    /* *
     * @Author lsc
     * <p>日志内容 </p>
     * @Param []
     * @Return java.lang.String
     */
    String value() default "";

    /* *
     * @Author lsc
     * <p>日志操作类型 </p>
     * @Param []
     * @Return int
     */
    LogEnum operateType() default LogEnum.UNOPERATE;


}
