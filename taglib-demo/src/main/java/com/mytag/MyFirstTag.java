package com.mytag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class MyFirstTag implements SimpleTag {
    JspContext jspContext;

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("执行doTag()方法");
        jspContext.getOut().print("这是杨柯的第一个标签。");
    }

    @Override
    public void setParent(JspTag jspTag) {
        System.out.println("执行setParent方法");
    }

    @Override
    public JspTag getParent() {
        System.out.println("执行getParent方法");
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        System.out.println("执行setJspContext()方法");
        this.jspContext = jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        System.out.println("执行setJspBody()方法");
    }
}
