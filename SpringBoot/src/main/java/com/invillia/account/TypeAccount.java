package com.invillia.account;

public enum TypeAccount {

    SAVINGSACCOUNT("SAVINGSACCOUNT", 0.0),
    CHECKINGACCOUNT("CHECKINGACCOUNT", 500.0);

    public final String type;
    public final Double loanLimit;

     TypeAccount(String type, Double loanLimit) {
        this.type = type;
        this.loanLimit = loanLimit;
    }
}
