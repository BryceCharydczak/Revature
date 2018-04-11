package com.revature.DAOs;

import com.revature.pojos.Account;
import com.revature.pojos.User;

import java.util.ArrayList;

public interface AccountDAO {
    public void addAccount(User user);
    public void removeAccount(Account oldAccount);
    public ArrayList<Account> getAllUserAccounts(User user);
    public Account updateAccount(Account newInfo);
    public Account getAccountByID(int id);

}
