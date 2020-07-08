package com.gy;


// 建造者模式：封装一个产品的构造过程，并允许按照步骤构建。
// 设计到Builder的类基本都是，比如HttpClientBuilder
public class BuilerMode {
    public static void main(String[] args) {
        StringBulider stringBulider = StringBulider.getBulider();
        String str = stringBulider.append("132").append("234").append("456").append("789").build();
        System.out.println(str);
    }
}

class StringBulider {
    String str = "";

    static StringBulider getBulider() {
        return new StringBulider();
    }

    StringBulider append(String str) {
        this.str += "```" + str;
        return this;
    }

    String build() {
        System.out.println("正在构建");
        System.out.println("构建完成");
        return str;
    }
}
