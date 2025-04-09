public class SimpleAccount extends Account {
    public SimpleAccount(long balance) {
        super(balance);
    }

    @Override
    public boolean add(long amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean pay(long amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
