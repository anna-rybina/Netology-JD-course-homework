public class CreditAccount extends Account {
    private long creditLimit;

    public CreditAccount(long balance, long creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
    }

    public long getCreditLimit() {
        return  creditLimit;
    }

    @Override
    public boolean add(long amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance + amount > 0) { // если пополнение приведёт к плюсу — запрещаем
            return false;
        }
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount >= -creditLimit) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
