package com.invillia.entities;


public enum TypeAccount {

    SAVINGSACCOUNT("SAVINGS", 0.0),
    CHECKINGACCOUNT("CHECKING", 500.0);


    public final String type;
    public final Double loanLimit;

    TypeAccount(String type, Double loanLimit) {
        this.type = type;
        this.loanLimit = loanLimit;
    }
}
