package com.driver;

public class StudentAccount extends BankAccount{

    private String  institutionName;
    public String getInstitutionName(){
        return this.institutionName;
    }
    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name,balance,0);

    }

}
