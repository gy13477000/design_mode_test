package com.gy;

import java.util.ArrayList;
import java.util.List;

//中介者模式：来集中相关对象之间复杂的沟通和控制方式
public class MediatorMode {
    public static void main(String[] args) {
        People wangsan = new Man("王三");
        People lisi = new Man("李四");
        Mediator mediator = new ConcreteMediator();
        mediator.register(wangsan);
        mediator.register(lisi);

        wangsan.send("李四", "李四你好");
        lisi.send("王三", "李王三你好");

    }
}

interface Mediator {
    public void register(People p);

    public void send(String from, String to, String msg);
}

class ConcreteMediator implements Mediator {
    private List<People> list = new ArrayList<>();

    @Override
    public void register(People p) {
        if (!list.contains(p)) {
            list.add(p);
            p.setMediator(this);
        }
    }

    @Override
    public void send(String from, String to, String msg) {
        list.forEach(people -> {
            if (people.getName().equals(to)) {
                people.rev(from, msg);
            }
        });
    }
}

abstract class People {
    protected String name;

    protected Mediator mediator;

    public abstract void send(String to, String msg);

    public abstract void rev(String from, String msg);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}

class Man extends People {
    public Man(String name) {
        this.name = name;
    }

    @Override
    public void send(String to, String msg) {
        mediator.send(name, to, msg);
    }

    @Override
    public void rev(String from, String msg) {
        System.out.println(name + "接收到消息,来自" + from + "，内容为：" + msg);
    }
}