package com.gy;

// 为另一个对象提供一个替身，控制对其的访问(代理和代理着都需要实现同一个接口)
// spring aop
public class ProxyMode {
    public static void main(String[] args) {
        Persion persion = new WanghuProxy(new WangWu());
        persion.getAge();
        persion.getAge();
        persion.getAge();
        persion.getAge();
    }
}

interface Persion {
    int getAge();
}

class WangWu implements Persion {
    @Override
    public int getAge() {
        System.out.println("我10岁乐");
        return 10;
    }
}

class WanghuProxy implements Persion {
    Persion persion;

    private int age;

    public WanghuProxy(Persion persion) {
        this.persion = persion;
    }

    @Override
    public int getAge() {
        if (age == 0) {
            age = persion.getAge();
        }
        System.out.println("代理：我" + age + "岁乐");
        return age;
    }
}
