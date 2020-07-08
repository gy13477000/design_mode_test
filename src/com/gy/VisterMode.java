package com.gy;

public class VisterMode {
    public static void main(String[] args) {
        House house = new House("名字", "红色", "地址");
        Vister vister = new Vister();
        System.out.println(vister.getColor(house));
        System.out.println(vister.getAddress(house));
        System.out.println(vister.getName(house));
        System.out.println(vister.getNameLength(house));
    }
}

// 数据结构
class House {
    String name;
    String color;
    String address;

    public House(String name, String color, String address) {
        this.name = name;
        this.color = color;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


class Vister {
    public String getName(House food) {
        return food.getName();
    }

    public String getColor(House food) {
        return food.getColor();
    }

    public String getAddress(House food) {
        return food.getAddress();
    }

    public int getNameLength(House food) {
        return food.getName().length();
    }


}


