package com.gy;

public class SingleMode {
    public static void main(String[] args) {
        Mode1 mode1 = Mode1.getSingleMode();
        Mode2 mode2 = Mode2.getSingleMode();
        Mode3 mode3 = Mode3.getSingleMode();
        Mode4 mode4 = Mode4.getSingleMode();
        Mode5 mode5 = Mode5.MODE;
    }
}

class Mode1 {
    private static final Mode1 mode1 = new Mode1();

    private Mode1() {
    }

    public static Mode1 getSingleMode() {
        return mode1;
    }
}

class Mode2 {
    private Mode2() {
    }

    private static Mode2 mode2;

    public static synchronized Mode2 getSingleMode() {
        if (mode2 == null) {
            mode2 = new Mode2();
        }
        return mode2;
    }
}

class Mode3 {
    private Mode3() {
    }

    private volatile static Mode3 mode3;

    public static Mode3 getSingleMode() {
        if (mode3 == null) {
            synchronized (Mode3.class) {
                if (mode3 == null) {
                    mode3 = new Mode3();
                }
            }
        }
        return mode3;
    }

}

class Mode4 {
    private Mode4() {
    }

    private static class Mode4Holder {
        private static Mode4 mode4 = new Mode4();
    }

    public static Mode4 getSingleMode() {
        return Mode4Holder.mode4;
    }
}

enum Mode5 {
    MODE;
}

