public class Main {
    public static void main(String[] args) {

        Company company1 = new Company("МТС", new taxes.USNIncome());
        Company company2 = new Company("Ростелеком", new taxes.USNIncomeMinusExpenses());

        company1.shiftMoney(100000000);
        company1.shiftMoney(-50000000);
        company1.payTaxes();

        company2.shiftMoney(100000000);
        company2.shiftMoney(-50000000);
        company2.payTaxes();

        company1.setTaxSystem(new taxes.USNIncomeMinusExpenses());
        company1.shiftMoney(100000000);
        company1.shiftMoney(-50000000);
        company1.payTaxes();

        company2.setTaxSystem(new taxes.USNIncome());
        company2.shiftMoney(100000000);
        company2.shiftMoney(-50000000);
        company2.payTaxes();

    }
}