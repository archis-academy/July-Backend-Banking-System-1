package org.example.account;

import java.time.LocalDate;

public class SavingAccount extends  Account{
    public  double interestRate;
    public int maturity;
    public LocalDate startDate;
    public LocalDate maturityDate;
    public double penaltyRate;
    public double maturityAmount;

    public SavingAccount(long accountId, long accountNumber, String accountType, float accountBalance, String accountHolder, LocalDate createdDate, double totalCredit,
                         double interestRate, int maturity, LocalDate startDate, LocalDate maturityDate, double penaltyRate, double maturityAmount) {
        super(accountId, accountNumber, accountType, accountBalance, accountHolder, createdDate, totalCredit);
        this.interestRate = interestRate;
        this.maturity = maturity;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.penaltyRate = penaltyRate;
        this.maturityAmount = maturityAmount;
    }
}
