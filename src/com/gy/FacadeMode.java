package com.gy;
// 外观模式:提供一个统一的接口，来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。
public class FacadeMode {
    public static void main(String[] args) throws InterruptedException {
        DeviceInterface 饮水机 = new 饮水机();
        DeviceInterface 空调 = new 空调();
        DeviceInterface 灯 = new 灯();
        OfficeFacade office = new OfficeFacade(饮水机, 空调, 灯);
        office.上班();
        Thread.sleep(5000);
        office.下班();
    }
}

class OfficeFacade {
    DeviceInterface 饮水机;
    DeviceInterface 空调;
    DeviceInterface 灯;

    public OfficeFacade(DeviceInterface 饮水机, DeviceInterface 空调, DeviceInterface 灯) {
        this.饮水机 = 饮水机;
        this.空调 = 空调;
        this.灯 = 灯;
    }

    public void 上班() {
        饮水机.start();
        空调.start();
        灯.start();
    }

    public void 下班() {
        饮水机.close();
        空调.close();
        灯.close();
    }


}


interface DeviceInterface {
    void start();

    void close();
}

class 饮水机 implements DeviceInterface {

    @Override
    public void start() {
        System.out.println("start 饮水机");
    }

    @Override
    public void close() {
        System.out.println("close 饮水机");
    }
}

class 空调 implements DeviceInterface {

    @Override
    public void start() {
        System.out.println("start 空调");
    }

    @Override
    public void close() {
        System.out.println("colse 空调");
    }
}

class 灯 implements DeviceInterface {

    @Override
    public void start() {
        System.out.println("start 灯");
    }

    @Override
    public void close() {
        System.out.println("close 灯");
    }
}