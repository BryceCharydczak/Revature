package com.revature.pojos;

import java.util.Objects;

public class Account {
    private int ID;
    private int userID;
    private float balance;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return ID == account.ID &&
                userID == account.userID &&
                balance == account.balance;
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, userID, balance);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", userID=" + userID +
                ", balance=" + balance +
                '}';
    }
}
