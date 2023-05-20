package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class EncodingFilter implements Filter {
    protected String encoding = null;
    protected FilterConfig config;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        //得到过滤器的初始化参数
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (request.getCharacterEncoding() == null) {
            //得到指定的编码
            String encode = getEncoding();
            if (encode != null) {
                //设置request的编码
                request.setCharacterEncoding(encode);
                response.setCharacterEncoding(encode);
            }
        }
        chain.doFilter(request,response);
    }

    protected String getEncoding(){
        return encoding;
    }

   public void destroy(){

   }

}
