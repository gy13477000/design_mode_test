package com.gy;


import java.util.HashSet;
import java.util.Set;

// 出版者+订阅者=观察着模式
// springboot启动时的监听器：从spring.factiories配置文件中读取观察着，当程序到达各个状态调用观察着方法，来结构系统功能
public class ObserverMode {
    public static void main(String[] args) {
        MessageSubject messageSubject = new MessageSubject();
        messageSubject.registerObserver(new Observer1());
        messageSubject.registerObserver(new Observer2());
        messageSubject.registerObserver(new Observer2());
        messageSubject.setState("123");
    }
}

interface Observer {
    void update();
}

class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者1收到通知");
    }
}

class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者2收到通知");
    }
}

class Observer3 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者3收到通知");
    }
}

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

class MessageSubject implements Subject {

    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObserver();
    }

    Set<Observer> set = new HashSet<>();

    @Override
    public void registerObserver(Observer observer) {
        set.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        set.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : set) {
            observer.update();
        }
    }
}
