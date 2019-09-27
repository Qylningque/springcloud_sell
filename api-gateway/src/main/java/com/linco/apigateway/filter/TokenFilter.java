package com.linco.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Classname: TokenFilter
 * @description: 自定义前置(Pre)路由过滤器，用于检验token
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-27 11:29
 * @Version 1.0
 */
@Component
public class TokenFilter extends ZuulFilter {
    /**
     * 路由参数校验，在PRE前置路由
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 自定义前置路由过滤器放在此类型之前，数值越小越靠前，官方推荐写法
     * @return
     */
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 在此编写需要对过滤器进行的具体操作
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //这里从url参数里获取token，也可以从cookie，header里获取
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }

        return null;
    }
}
