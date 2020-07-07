package com.gy;

//在一个父类方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法的某些步骤。
// DispatcherServlet,AbstractApplicationContext最重要的refresh方法使用模板方法模式实现,jdbc数据库操作
public class TemplateMode {
    public static void main(String[] args) {
        Drinnk tea = new Tea();
        tea.make();
        Drinnk coffoo = new Coffee();
        coffoo.make();
    }
}

// 泡茶或煮咖啡
abstract class Drinnk {
    void make() {
        // 烧水
        boilwater();
        // 冲泡
        brew();
        // 将水倒入杯子
        pourInCup();
        // 添加调理
        addTiaoLiao();
    }

    void boilwater() {
        System.out.println("将水烧开");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("将水倒入杯子");
    }

    abstract void addTiaoLiao();
}

class Tea extends Drinnk {
    @Override
    void brew() {
        System.out.println("需要先把茶叶泡开");
    }

    @Override
    void addTiaoLiao() {
        System.out.println("泡茶不需要添加任何调料");
    }
}

class Coffee extends Drinnk {
    @Override
    void brew() {
        System.out.println("咖啡直接泡");
    }

    @Override
    void addTiaoLiao() {
        System.out.println("向咖啡中加入糖");
    }
}
