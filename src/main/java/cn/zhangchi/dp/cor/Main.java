package cn.zhangchi.dp.cor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)：<script>.欢迎访问 zhangchi.cn 大家都是996");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new URLFilter());

        fc.add(fc2);
        fc.doFilter(msg);


        System.out.println(msg);
    }
}

class Msg{
    String msg;
    String name;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter{
    boolean doFilter(Msg m);
}

class HTMLFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        // 处理msg
        String r = m.getMsg();
        r = r.replace('<','[');
        r = r.replace('>',']');
        m.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replaceAll("996","955");
        m.setMsg(r);
        return false;
    }
}

class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace(":)","^V^");
        m.setMsg(r);
        return true;
    }
}

class URLFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("zhangchi.cn","http://www.zhangchi.cn");
        m.setMsg(r);
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public boolean doFilter(Msg m){
        for(Filter filter:filters){
            if(!filter.doFilter(m)) return false;
        }
        return true;

    }
}