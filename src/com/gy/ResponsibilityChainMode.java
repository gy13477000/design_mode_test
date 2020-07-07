package com.gy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//一个对象可以被N个对象处理，类似生产线。
// springmvc 的过滤器链，springsecrity中的过滤器链
public class ResponsibilityChainMode {
    public static void main(String[] args) {
        VirtualFilterChain filterChain = new VirtualFilterChain();
        filterChain.addFilter(new Filter1());
        filterChain.addFilter(new Filter2());
        filterChain.addFilter(new Filter3());
        filterChain.doFilter(new HashSet<String>());
    }
}

interface Filter {
    void doFilter(HashSet<String> obj, FilterChain chin);
}

class Filter1 implements Filter {
    @Override
    public void doFilter(HashSet<String> obj, FilterChain chin) {
        obj.add("经过filter1");
        chin.doFilter(obj);
    }
}

class Filter2 implements Filter {
    @Override
    public void doFilter(HashSet<String> obj, FilterChain chin) {
        obj.add("经过filter2");
        chin.doFilter(obj);
    }
}

class Filter3 implements Filter {
    @Override
    public void doFilter(HashSet<String> obj, FilterChain chin) {
        obj.add("经过filter3");
        chin.doFilter(obj);
    }
}

interface FilterChain {
    void doFilter(HashSet<String> obj);
}

class VirtualFilterChain implements FilterChain {
    private List<Filter> list = new ArrayList<>();
    private int i = 0;
    private int size = 0;

    public void addFilter(Filter filter) {
        list.add(filter);
        size = list.size();
    }

    @Override
    public void doFilter(HashSet<String> obj) {
        if (i == size) {
            System.out.println("filters 执行完毕" + obj);
            return;
        } else {
            i++;
            list.get(i - 1).doFilter(obj, this);
        }
    }
}