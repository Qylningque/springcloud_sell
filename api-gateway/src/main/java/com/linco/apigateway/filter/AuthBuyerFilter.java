package com.linco.apigateway.filter;

import com.linco.apigateway.constant.RedisConstant;
import com.linco.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Classname: AuthFilter
 * @description: 权限校验（买家）
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-27 11:29
 * @Version 1.0
 */
@Component
public class AuthBuyerFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if ("/order/order/create".equals(request.getRequestURI())){
            return true;
        }
        return false;
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
        /**
         * /order/create 创建订单，只能买家访问（cookie里有openid）
         */
        //1.创建订单权限过滤
            Cookie cookie = CookieUtil.get(request,"openid");
            if (cookie == null || StringUtils.isEmpty(cookie.getValue())){
                //返回权限不足
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        return null;
    }
}
