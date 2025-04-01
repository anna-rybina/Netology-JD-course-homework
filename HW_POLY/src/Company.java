import taxes.TaxSystem;

public class Company {
    private String title; // название
    private int debit; // доходы
    private int credit; // расходы
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit = debit + amount;
        } else if (amount < 0) {
            credit = credit + Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.printf("Компания %s уплатила налог в размере: %d руб.%n", title, tax);
        debit = 0;
        credit = 0;
    }

}
