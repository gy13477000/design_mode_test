package com.gy;

import java.util.Iterator;

// 迭代器模式：提供了一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。
public class IteratorMode {
    public static void main(String[] args) {
        MyContainer myContainer = new MyContainer();
        Iterator<String> iterator = myContainer.getIterator();
        iterator.forEachRemaining(str -> System.out.println(str));
    }
}

class MyContainer {
    String[] arrStr = {"2", "3", "44441", "13333", "133", "1gfdg", "1gfdsg"};

    Iterator<String> getIterator() {
        return new MyContainerIterator();
    }

    private class MyContainerIterator implements Iterator<String> {
        int i = 0;

        @Override
        public boolean hasNext() {
            if (i < arrStr.length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String next() {
            if (hasNext()) {
                return arrStr[i++];
            }
            return null;
        }
    }
}

