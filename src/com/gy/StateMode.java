package com.gy;


public class StateMode {
    public static void main(String[] args) {
        WarterMachine warterMachine = new WarterMachine(3);
        warterMachine.insertCoin();
        warterMachine.dispense();
        warterMachine.insertCoin();
        warterMachine.dispense();
        warterMachine.insertCoin();
        warterMachine.dispense();
        warterMachine.insertCoin();
        warterMachine.dispense();
    }
}

// 自动售水机,投币，就可以出货
// 三种状态 ：有币，无币，售光
class WarterMachine {
    private State haveconestate = new HaveConeState(this);
    private State noconestate = new NoConeState(this);
    private State salloutconestate = new SallOutConeState(this);
    private int count = 0; // 有多少瓶水
    private State curState;

    public WarterMachine(int count) {
        if (count > 0) {
            this.count = count;
            curState = noconestate;
        } else {
            curState = salloutconestate;
        }
    }

    void insertCoin() {
        curState.insertCoin();
    }

    // 退币
    void ejectCoin() {
        curState.ejectCoin();
    }

    // 出货
    void dispense() {
        curState.dispense();
    }

    void successSale() {
        if (count > 0) {
            count--;
        }
    }

    public State getHaveconestate() {
        return haveconestate;
    }

    public State getNoconestate() {
        return noconestate;
    }

    public State getSalloutconestate() {
        return salloutconestate;
    }

    public int getCount() {
        return count;
    }

    public void setCurState(State curState) {
        this.curState = curState;
    }
}

// 投币状态，无比状态，售罄状态，抓中状态
interface State {
    // 投币
    void insertCoin();

    // 退币
    void ejectCoin();

    // 出货
    void dispense();
}

class HaveConeState implements State {
    WarterMachine warterMachine;

    public HaveConeState(WarterMachine warterMachine) {
        this.warterMachine = warterMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("已经有币了");
    }

    @Override
    public void ejectCoin() {
        System.out.println("退币成功");
        warterMachine.setCurState(warterMachine.getNoconestate());
    }

    @Override
    public void dispense() {
        System.out.println("出货成功");
        warterMachine.successSale();
        if (warterMachine.getCount() > 0) {
            warterMachine.setCurState(warterMachine.getNoconestate());
        } else {
            warterMachine.setCurState(warterMachine.getSalloutconestate());
        }


    }
}

class NoConeState implements State {
    WarterMachine warterMachine;

    public NoConeState(WarterMachine warterMachine) {
        this.warterMachine = warterMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("投币成功");
        warterMachine.setCurState(warterMachine.getHaveconestate());
    }

    @Override
    public void ejectCoin() {
        System.out.println("无币可退");
    }


    @Override
    public void dispense() {
        System.out.println("请先投币");
    }
}

class SallOutConeState implements State {
    WarterMachine warterMachine;

    public SallOutConeState(WarterMachine warterMachine) {
        this.warterMachine = warterMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("无货了，不能投币");
    }

    @Override
    public void ejectCoin() {
        System.out.println("无币可退");
    }


    @Override
    public void dispense() {
        System.out.println("请先投币");
    }
}

