package com.gy;

public class BridgeMode {
    public static void main(String[] args) {
        RemoteCrontrolImpl remoteCrontrol = new RemoteCrontrolImpl(new XiaoMi());
        remoteCrontrol.setChannel(5);
        remoteCrontrol.preChannel();
        remoteCrontrol.preChannel();
        remoteCrontrol.nextChannel();
    }
}

// 先来考虑不适用桥接模式的代码实现
// 遥控器接口,有一个调频道的方法
// 此种方法，实现的代码可以随便修改没问题，但是如果遥控器要增加一个上一个频道，下一个频道的方法，有上百个实现类，脑大，没法弄了
//interface RemoteControl {
//    void setChannel(int i);
//}
//
//class TclRemoteControl implements RemoteControl {
//    @Override
//    public void setChannel(int i) {
//        System.out.println("TCL 电视 频道改变为:" + i);
//    }
//}
//
//class XiaoMiRemoteControl implements RemoteControl {
//    @Override
//    public void setChannel(int i) {
//        System.out.println("我是小米小米，频道调整为:" + i);
//    }
//}

// 在来看看桥接模式的代码,抽象只有两个雷可以随便改，实现和原来一样也可以随便修改
// 此为抽象
abstract class RemoteCrontrol {
    protected Bridge bridge;

    abstract void setChannel(int i);
}

// 此为实现
class RemoteCrontrolImpl extends RemoteCrontrol {

    public RemoteCrontrolImpl(Bridge bridge) {
        this.bridge = bridge;
    }

    private int i;

    @Override
    void setChannel(int i) {
        this.i = i;
        bridge.setChannel(i);
    }

    void nextChannel() {
        setChannel(i + 1);
    }

    void preChannel() {
        setChannel(i - 1);
    }
}

interface Bridge {
    void setChannel(int i);
}

class Tcl implements Bridge {
    @Override
    public void setChannel(int i) {
        System.out.println("TCL 电视 频道改变为:" + i);
    }
}

class XiaoMi implements Bridge {
    @Override
    public void setChannel(int i) {
        System.out.println("我是小米小米，频道调整为:" + i);
    }
}


