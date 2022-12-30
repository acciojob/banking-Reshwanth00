package com.driver;
class Insufficient extends Exception{
    Insufficient(){
        super("Insufficient Balance");
    }
}
class Invalid extends Exception{
    Invalid(){
        super("Account Number can not be generated");
    }
}
public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.minBalance=minBalance;
        deposit(balance);
        this.name=name;
    }

    private String AccountNumber;
    public void getNumber(int n, int sum, char out[],
                                   int index)
    {
        // Base case
        if (index > n || sum < 0)
            return;

        // If number becomes N-digit
        if (index == n)
        {
            // if sum of its digits is equal to given sum,
            // print it
            if(sum == 0)
            {
                String p = new String(out);
                this.AccountNumber = p;
                return;
            }
            return;
        }
        for (int i = 0; i <= 9; i++){
            out[index] = (char)(i + '0');
            getNumber(n, sum - i, out, index + 1);
        }
    }
    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if(sum<0 || 9*digits<sum){
            throw new Invalid();
        }
        else{
            char [] out = new char[digits+1];
            for(int i=1;i<=9;i++){
                out [0] = (char)(i+'0');
                getNumber(digits,sum-i,out,1);
            }
            return this.AccountNumber;

        }
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        this.balance-=amount;
        if(this.balance<this.minBalance){
            throw new Insufficient();
        }
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }
}
