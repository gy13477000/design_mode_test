package com.gy;

// 装饰器模式:动态地将责任附加到对象上，若要扩展功能，装饰着提供了比继承更有弹性的替代方案。
// java中的io类大量使用此模式
public class DecoratorMode {
    public static void main(String[] args) {
        Drink blackCoffee = new BlackCoffee();
        Drink suggerBlackCoffee = new SuggerBlackCoffee(blackCoffee);
        Drink dubbleSuggerBlackCoffee = new SuggerBlackCoffee(suggerBlackCoffee);
        System.out.println(blackCoffee.getName() + blackCoffee.cost());
        System.out.println(suggerBlackCoffee.getName() + suggerBlackCoffee.cost());
        System.out.println(dubbleSuggerBlackCoffee.getName() + dubbleSuggerBlackCoffee.cost());

    }
}


class SuggerBlackCoffee implements Drink {
    private Drink blackCoffee;

    public SuggerBlackCoffee(Drink drink) {
        this.blackCoffee = blackCoffee;
    }

    @Override
    public String getName() {
        return blackCoffee.getName() + ",加糖";
    }

    @Override
    public double cost() {
        return blackCoffee.cost() + 0.5;
    }
}


interface Drink {
    String getName();

    double cost();
}

class BlackCoffee implements Drink {
    @Override
    public String getName() {
        return "黑咖啡";
    }

    @Override
    public double cost() {
        return 8;
    }
}

