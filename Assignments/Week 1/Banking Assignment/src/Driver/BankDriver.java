package Driver;

import DAOImplementations.AccountImp;
import DAOImplementations.UserImp;
import DAOs.AccountDAO;
import DAOs.UserDAO;
import pojos.Account;
import pojos.User;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BankDriver {
    public static void main(String[] args) {
        UserDAO userDAO = new UserImp();
        AccountDAO accountDAO = new AccountImp();
        Scanner scan = new Scanner(System.in);
        User user = new User();
        user.setID(0);
        user.setPassword(null);
        user.setUsername(null);
        int screenLayer = 0;
        while(true){
            User temp = new User();
            String input;
            if (screenLayer == 0){
                primaryDisplay();
                switch (input = scan.next()){
                    case "1":
                        temp = Login();
                        if (temp != null){
                            user.setPassword(temp.getPassword());
                            user.setUsername(temp.getUsername());
                            User logUser = userDAO.getUserByUser(temp);
                            user.setID(logUser.getID());
                            screenLayer = 1;
                            break;
                        } else {
                            break;
                        }
                    case "2":
                        temp = Register();
                        if (temp != null){
                            user.setPassword(temp.getPassword());
                            user.setUsername(temp.getUsername());
                            userDAO.addUser(user);
                            screenLayer = 1;
                            break;
                        } else {
                            break;
                        }
                    case "3":
                        aboutUs();

                }

            } else if (screenLayer ==1){
                loggedInDisplay();
                switch (input = scan.next()){
                    case "1":
                        int accountNum = depositAccount();
                        float depositAmt = depositAmount();
                        Account tempAcc = accountDAO.getAccountByID(accountNum);
                        if ((tempAcc.getBalance() + depositAmt <= 999999.99)) {
                            tempAcc.setBalance(tempAcc.getBalance() + depositAmt);
                            accountDAO.updateAccount(tempAcc);
                        } else {
                            System.out.println("Your are trying to deposit too many funds, feel free to open a new account!");
                        }
                        break;
                    case "2":
                        int accountNum2 = depositAccount();
                        float withdrawAmt = withdrawAmount();
                        Account tempAcc2 = accountDAO.getAccountByID(accountNum2);
                        if ((tempAcc2.getBalance() - withdrawAmt) >= 0) {
                            tempAcc2.setBalance(tempAcc2.getBalance() - withdrawAmt);
                            accountDAO.updateAccount(tempAcc2);
                        } else {
                            System.out.println("You are trying to withdraw too much money!");
                        }
                        break;
                    case "3":
                        ArrayList<Account> accounts = accountDAO.getAllUserAccounts(user);
                        for (int i = 0; i < accounts.size(); i++){
                            System.out.println("Account Number: " +accounts.get(i).getID());
                            System.out.println("Total Balance: "+ accounts.get(i).getBalance());
                            System.out.println();
                        }
                        sleep(3);
                        break;
                    case "4":
                        accountDAO.addAccount(user);
                        break;
                    case "5":
                        user.setID(0);
                        user.setUsername(null);
                        user.setPassword(null);
                        System.out.println("You have successfully logged out!");
                        screenLayer = 0;
                        break;

                }
            }
        }



       // userDAO.addUser(user);
    }

    public static void primaryDisplay(){
        System.out.println("==============================================================================");
        System.out.println("== BRYCE'S BEASTLY BANKING, WHERE YOUR MONEY IS OUR #1 CONCERN, GIMME GIMME ==");
        System.out.println("==============================================================================");
        System.out.println("Please type and press 'enter' for one of the following numbers:");
        System.out.println("");
        System.out.println("1 -> Login");
        System.out.println("2 -> Register");
        System.out.println("3 -> Get to know us!");

    }

    public static void loggedInDisplay(){
        System.out.println("==============================================================================");
        System.out.println("== BRYCE'S BEASTLY BANKING, WHERE YOUR MONEY IS OUR #1 CONCERN, GIMME GIMME ==");
        System.out.println("==============================================================================");
        System.out.println("Please type and press 'enter' for one of the following numbers:");
        System.out.println("");
        System.out.println("1 -> Deposit");
        System.out.println("2 -> Withdraw");
        System.out.println("3 -> View Accounts");
        System.out.println("4 -> Create New Account");
        System.out.println("5 -> Logout");
    }


    public static boolean checkForUser(User user){
        UserDAO userDAO = new UserImp();
        ArrayList<User> users = userDAO.getAllUsers();
        if (users.contains(user)){
            return true;
        } else {
            return false;
        }
    }

    public static void clearConsole(){

        /*
        // failed attempt to clear screen
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    public static void sleep(int seconds){
        try {TimeUnit.SECONDS.sleep(seconds);}
        catch(InterruptedException ex){ ex.printStackTrace();}
    }

    public static User Login(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your Username: ");
        String username = s.nextLine();
        System.out.println("Please enter your Password: ");
        String password = s.nextLine();
        User temp = new User();
        temp.setUsername(username);
        temp.setPassword(password);
        if (checkForUser(temp)){
            System.out.println("Congratulations, " + username + ", you have logged in!");
            sleep(2);
            clearConsole();
            return temp;
        } else {
            System.out.println("The account with the given username and password does not exist.");
            sleep(2);
            clearConsole();
            return null;

        }


    }
    public static void aboutUs(){
        System.out.println("");

        System.out.println("");
        System.out.println("Yeah, we honestly just want your money, dun care about yuh.");

        sleep(3);
        System.out.println("sorry, not sorry");
        sleep(1);

        return;
    }

    public static int  depositAccount(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the Account Number that you wish to deposit to:");
        int accountid = s.nextInt();
        return accountid;

    }
    public static float depositAmount(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the amount of money you wish to deposit:");
        float deposit = s.nextFloat();
        return deposit;

    }
    public static float withdrawAmount(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the amount of money you wish to withdraw:");
        float withdraw = s.nextFloat();
        return withdraw;
    }


    public static User Register(){
        Scanner s = new Scanner(System.in);
        User user = new User();
        System.out.println("Please enter the Username that you would like to have: ");
        String username = s.nextLine();
        System.out.println("Please enter the Password that you would like to have: ");
        String password = s.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        if (checkForUser(user)){
            System.out.println("We're sorry, but it seems the Username '" + user.getUsername() + "' is already taken.");
            try {TimeUnit.SECONDS.sleep(1);}
            catch(InterruptedException ex){ ex.printStackTrace();}
            System.out.println("dummy");
            try {TimeUnit.SECONDS.sleep(1);}
            catch(InterruptedException ex){ ex.printStackTrace();}
            clearConsole();
            return null;
        } else {

            System.out.println("One moment please while we add your credentials to our money siphoning... wealth growth database.");
            try {TimeUnit.SECONDS.sleep(2);}
            catch(InterruptedException ex){ ex.printStackTrace();}
            clearConsole();
            return user;
        }
    }

}
