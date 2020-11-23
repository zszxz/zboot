package com.zboot.common.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author lsc
 * <p> </p>
 */
public class QueryWraperUtils<T> {

    private static final String BEGIN = "begin_";
    private static final String END = "end_";
    private static final String STAR = "*";
    private static final String ORDERBY = "order_by";

    public static<T> QueryWrapper<T> getQueryWrapper(Object object){
        Map<String, Object> map = BeanUtil.beanToMap(object,true,true);
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        map.keySet().stream().forEach(key -> {
            Object value = map.get(key);
            if (value instanceof List){
                // 排序  例如  orderBy=[name*asc,createTime*desc]
                List<String> val = (List<String>) value;
               if(key.equals(ORDERBY)){
                   val.stream().forEach(oderKeyVal->{
                       installOrderBy(queryWrapper,oderKeyVal);
                   });
                }else {
                   // in 操作
                   queryWrapper.in(key,val);
               }
            }else if (key.startsWith(BEGIN)){
                // 大于等于
                String col = key.replace(BEGIN,"");
                queryWrapper.ge(col,value);
            }else if (key.startsWith(END)){
                // 小于等于
                String col  = key.replace(END,"");
                queryWrapper.le(col,value);
            }else if (value instanceof String){
                String val = (String) value;
                if (StringUtils.isNotBlank(val)){
                    // 模糊查询
                    if (val.startsWith(STAR) && val.endsWith(STAR)){
                        queryWrapper.like(key,val.substring(1,val.lastIndexOf(STAR)).trim());
                    }else if (val.startsWith(STAR)){
                        queryWrapper.likeLeft(key,val.substring(1).trim());
                    }else if (val.endsWith(STAR)){
                        queryWrapper.likeRight(key,val.substring(0,val.lastIndexOf(STAR)).trim());
                    }else {
                        queryWrapper.eq(key,val);
                    }
                }
            }else {
                // 其它操作默认为 and 操作
                queryWrapper.eq(key,value);
            }
        });
        return queryWrapper;
    }

    /* *
     * @Author lsc
     * <p> 排序条件封装 </p>
     * @Param [queryWrapper, oderKeyVal]
     * @Return
     */
    private static<T> void installOrderBy(QueryWrapper<T> queryWrapper,String oderKeyVal){
        int index = oderKeyVal.indexOf(STAR);
        String orderColumn = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, oderKeyVal.substring(0, index));
        String oderVal = oderKeyVal.substring(index+1);
        if (oderVal.equals("asc")){
            queryWrapper.orderByAsc(orderColumn);
        }else {
            queryWrapper.orderByDesc(orderColumn);
        }
    }
}
