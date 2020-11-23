package com.zboot.modules.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lsc
 * <p> </p>
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

   /* *
    * @Author lsc
    * <p> 是否允许访问</p>
    * @Param [request, response, mappedValue]
    * @Return boolean
    */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        //log.info("---------------拦截请求------------");
        //判断请求的请求头是否带上 "token"
        String token = ((HttpServletRequest) request).getHeader("token");
        if (StringUtils.isNotBlank(token)) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
                return executeLogin(request, response);
            } catch (Exception e) {
                //token 错误
                log.error("---------无效的token--------错误信息：{}",e.getMessage());
                errorException(request,response);
                return false;
            }
        }else {
            String requestURI = ((HttpServletRequest) request).getRequestURI();
            log.error("---------token为空，认证失败；非法URI:{}--------",requestURI);
            errorException(request,response);
            return false;
        }
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws UnauthorizedException{
        //log.info("--------------进行认证中------------------");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("token");
        JWTToken jwtToken = new JWTToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(jwtToken);
        // 如果没有抛出异常则代表登入成功，返回true;
        return true;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    private void errorException(ServletRequest req, ServletResponse resp) {
        try {
            log.info("-----------未认证的请求-----------");
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            // 注意此url别写错否则会报跨域
            httpServletResponse.sendRedirect("/api/zboot/system/error");
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
