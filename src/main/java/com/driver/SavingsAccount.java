package com.driver;

public class SavingsAccount extends BankAccount {
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        if (amount > this.maxWithdrawalLimit) {
            throw new Insufficient();
        }

    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on current amount
        double simpleInterest = (double) ((getBalance() * years * this.rate) / 100);
        return simpleInterest;
    }
    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        int product = times*years;
        double sample =1+( this.rate/times);
        double compoundInterest = (double) (getBalance()*(Math.pow(sample,product)));
        return compoundInterest;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public double getRate() {
        return rate;
    }
}
