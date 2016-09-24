package pl.ania;

/**
 * Created by lukasz on 2016-09-24.
 */
public class Account {

    private int moneyOnAccount;

    public Account(int moneyOnAccount){
        this.moneyOnAccount = moneyOnAccount;
    }

    public int getMoneyOnAccount() {
        return moneyOnAccount;
    }

    private boolean withdrawMoney(int moneyOut) {
        if (moneyOut <= moneyOnAccount) {
            moneyOnAccount -= moneyOut;
            return true;
        }
        return false;
    }
}
