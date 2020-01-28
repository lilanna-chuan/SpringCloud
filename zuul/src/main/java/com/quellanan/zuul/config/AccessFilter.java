package com.quellanan.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AccessFilter
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/26 15:48
 * @Version 1.0
 */
@Slf4j
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        String token=request.getParameter("token");

        if(token == null || !token.equals("123456")){
           log.info("token is error!");
           ctx.setSendZuulResponse(false);
           ctx.setResponseStatusCode(500);
           return "error";
        }
        log.info("token is ok");
        return null;
    }
}
