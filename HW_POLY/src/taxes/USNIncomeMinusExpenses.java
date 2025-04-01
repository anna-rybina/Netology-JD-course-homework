package taxes;

public class USNIncomeMinusExpenses extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        int incomeMinusExpenses = debit - credit;
        if (incomeMinusExpenses > 0) {
            return (int) Math.round(incomeMinusExpenses * 0.15);
        }
        return 0;
    }
}
