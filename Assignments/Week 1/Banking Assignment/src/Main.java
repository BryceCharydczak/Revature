import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        //setting of current user to distinguish whose information is needed to be assessed.
        UserObj currentUsr = null;
        AccountCollection accountCollection = new AccountCollection();
        //UserObj usr = accountCollection.get("ByrizzleHalldizzle1234badpass");
        //System.out.println(usr.getBalance());
        Scanner scan = new Scanner(System.in);


        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            screenNav();
            String input;
            switch (input = scan.next()) {

                case "1":
                    if (currentUsr != null) {
                        System.out.println("You are already logged in, please logout to proceed!");
                    } else {
                        String userPlusPass;
                        userPlusPass = Login();

                        try {
                            currentUsr = accountCollection.get(userPlusPass);
                            accountCollection.remove(userPlusPass);
                            System.out.println("Welcome back " + currentUsr.getFirstName() + " " + currentUsr.getLastName() + "!");

                        } catch (NullPointerException ex) {
                            System.out.println("This account does not exist");
                            break;
                        }

                    }
                    break;
                case "2":
                    if (currentUsr != null) {
                        System.out.println("You are already logged in!");
                        // accountCollection.put((currentUsr.getUsername() + currentUsr.getPassword()), currentUsr);
                    } else {
                        currentUsr = register();
                        accountCollection.put((currentUsr.getUsername() + currentUsr.getPassword()), currentUsr);
                        writeToFile(currentUsr);
                    }

                    break;
                case "3":
                    int depo = deposit();
                    currentUsr.setBalance(currentUsr.getBalance()+depo);
                    break;
                case "4":
                    int amount = withdraw(currentUsr);
                    currentUsr.setBalance(currentUsr.getBalance()-amount);
                    break;
                case "5":
                    viewBalance(currentUsr);
                    break;

                //Logout
                case "6":
                    writeToFile(currentUsr);
                    currentUsr = null;
                    System.out.println("You have successfully logged out!");
                    break;


            }
        }
    }

    public static void removeLine(UserObj usr){
        try(FileWriter fw = new FileWriter("Accounts.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String Login(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String userName = s.next();
        System.out.println("Please enter your password:");
        String password = s.next();
        //s.close();

        return (userName+password);
    }
    public static UserObj register(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your first name:");
        String first = s.next();
        System.out.println("Please enter your last name:");
        String last = s.next();
        System.out.println("Please enter your username:");
        String user = s.next();
        System.out.println("Please enter your password:");
        String pass = s.next();
        UserObj usr = new UserObj();
        usr.setBalance(0);
        usr.setFirstName(first);
        usr.setLastName(last);
        usr.setUsername(user);
        usr.setPassword(pass);
        //s.close();
        System.out.println("Successful account creation. Welcome to Bryce's Beastly Banking!");
        return usr;

    }

    public static void writeToFile(UserObj usr) {

        try(FileWriter fw = new FileWriter("Accounts.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {

                out.println(usr.getFirstName() + " " +
                usr.getLastName() + " " +
                usr.getUsername() + " " +
                usr.getPassword() + " " +
                usr.getBalance());
                //more code

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int deposit(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the amount in which you'd like to deposit today.");
        int amount = 0;
        try {
            amount = s.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Please enter an actual number.");

        }
        if (amount <= 0){
            System.out.println("Deposits must exceed $0");

        } else {
            System.out.println("Your funds have been added to your account!");

        }
        //s.close();
        return(amount);
    }

    public static void viewBalance(UserObj usr){
        if (usr == null){
            System.out.println("You are not logged in.");
        } else {
            System.out.println("Your current balance is $"+usr.getBalance());
        }
    }
    public static int withdraw(UserObj usr){
        System.out.println("Please specify how much money you will be withdrawing:");
        Scanner s = new Scanner(System.in);
        int x = 0;
        try{
            x = s.nextInt();
        } catch(Exception e) {
            System.out.println("Please enter a valid number.");
        }
        if (x > usr.getBalance()){
            System.out.println("The max you can withdraw is " + usr.getBalance() + ". Please try again.");

        } else {
            System.out.println("The funds have been removed from your account.");

        }
        return x;
    }
    public static void screenNav(){
        System.out.println("===============================================================================");
        System.out.println("== BRYCE'S BEASTLY BANKING, WHERE YOUR MONEY IS OUR #1 CONCERN, GIMME GIMME  ==");
        System.out.println("===============================================================================");
        System.out.println("Please type and press 'enter' for one of the following numbers:");
        System.out.println("");
        System.out.println("1 -> Login");
        System.out.println("2 -> Register");
        System.out.println("3 -> Deposit");
        System.out.println("4 -> Withdraw");
        System.out.println("5 -> View Balance");
        System.out.println("6 -> Logout");
    }
}

/*
===============================================================================
== BRYCE'S BEASTLY BANKING, WHERE YOUR MONEY IS OUR #1 CONCERN, GIMME GIMME  ==
===============================================================================
Please type and press 'enter' for one of the following numbers:

1 -> Login
2 -> Register
3 -> Deposit
4 -> Withdraw
5 -> View Balance
6 -> Logout
2
Please enter your first name:
Carolyn
Please enter your last name:
Rehm
Please enter your username:
crehm
Please enter your password:
password
Successful account creation. Welcome to Bryce's Beastly Banking!
===============================================================================
== BRYCE'S BEASTLY BANKING, WHERE YOUR MONEY IS OUR #1 CONCERN, GIMME GIMME  ==
===============================================================================
Please type and press 'enter' for one of the following numbers:

1 -> Login
2 -> Register
3 -> Deposit
4 -> Withdraw
5 -> View Balance
6 -> Logout
5
Your current balance is $0
===============================================================================
== BRYCE'S BEASTLY BANKING, WHERE YOUR MONEY IS OUR #1 CONCERN, GIMME GIMME  ==
===============================================================================
Please type and press 'enter' for one of the following numbers:

1 -> Login
2 -> Register
3 -> Deposit
4 -> Withdraw
5 -> View Balance
6 -> Logout

 */
