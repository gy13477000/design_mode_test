package com.gy;

import java.util.ArrayList;
import java.util.List;

// 组合模式：允许你想对象组合成树形结构来表现“整体和部分”的层次结构，组合能让客户以一致的方式来处理个别对象已经对象组合
public class CompositeMode {
    public static void main(String[] args) {
        Menu manmenu = new Menu("主菜单");
        Menu menu = new Menu("早餐");
        manmenu.addComponent(menu);
        menu.addComponent(new MenuItem("大米粥"));
        menu.addComponent(new MenuItem("鸡蛋"));
        menu.addComponent(new MenuItem("牛奶"));
        menu.addComponent(new MenuItem("豆浆"));
        menu.addComponent(new MenuItem("包子"));
        Menu wumenu = new Menu("午餐");
        manmenu.addComponent(wumenu);
        wumenu.addComponent(new MenuItem("香菇肉片"));
        wumenu.addComponent(new MenuItem("番茄炒蛋"));
        wumenu.addComponent(new MenuItem("狮子头"));
        manmenu.print();
    }
}

abstract class MenuComponent {
    String name;

    public abstract void print();

    public void addComponent(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public void removeComponent(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

}

class MenuItem extends MenuComponent {
    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("我是一个菜单项，名称为：" + name);
    }
}

class Menu extends MenuComponent {
    List<MenuComponent> list = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void addComponent(MenuComponent component) {
        list.add(component);
    }

    @Override
    public void removeComponent(MenuComponent component) {
        list.remove(component);
    }

    @Override
    public MenuComponent getChild(int i) {
        return list.get(i);
    }

    @Override
    public void print() {
        System.out.println("我是一个菜单，名称为：" + name);
        list.iterator().forEachRemaining(c -> c.print());
    }
}