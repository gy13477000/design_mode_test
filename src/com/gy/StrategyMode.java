package com.gy;
// 策略模式：定义了算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。
// IOC容器大量使用
public class StrategyMode {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new StrategyAdd());
        context.doOperation(10, 8);
        context.setStrategy(new StrategySubtract());
        context.doOperation(10, 8);
    }
}

class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int doOperation(int a, int b) {
        return strategy.doOperation(a, b);
    }
}

interface Strategy {
    int doOperation(int a, int b);
}

class StrategyAdd implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        int temp = a + b;
        System.out.println("两数相加=" + temp);
        return temp;
    }
}

class StrategySubtract implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        int temp = a - b;
        System.out.println("两数相减=" + temp);
        return temp;
    }
}

