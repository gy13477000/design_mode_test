package com.gy;
// 适配器模式：将一个类的接口，转换成客户期望的另一个接口。适配器让原本不兼容的类可以合作无间。
public class AdapterMode {
    public static void main(String[] args) {
        HavingObj havingObj = new HavingObj();
        NeedInterface needInterface = new NeedInterfaceAdapter(havingObj);
        needInterface.needmethod();
    }
}

interface HavingInterface {
    void havingInterface();
}

class HavingObj implements HavingInterface {

    @Override
    public void havingInterface() {
        System.out.println("HavingObj");
    }
}

interface NeedInterface {
    void needmethod();
}


class NeedInterfaceAdapter implements NeedInterface {
    HavingObj havingObj;

    public NeedInterfaceAdapter(HavingObj havingObj) {
        this.havingObj = havingObj;
    }

    @Override
    public void needmethod() {
        havingObj.havingInterface();
    }
}



