package pl.ania;

public class Account {

    private int moneyOnAccount;

    private Card card;

    public Account(int moneyOnAccount, Card card) {
        this.moneyOnAccount = moneyOnAccount;
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int getMoneyOnAccount() {
        return moneyOnAccount;
    }

    public boolean withdrawMoney(int moneyOut) {
        if (moneyOut <= moneyOnAccount) {
            moneyOnAccount -= moneyOut;
            return true;
        }
        System.out.println("Nie ma tyle srodkow na koncie");
        return false;
    }

}
