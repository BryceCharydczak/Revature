public class UserObj implements Comparable {
    static boolean isLoggedIn = false;
    static String username;
    static String password;
    static String firstName;
    static String lastName;
    static int SSN;

    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        UserObj.balance = balance;
    }

    static int balance;

    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        UserObj.isLoggedIn = isLoggedIn;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserObj.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserObj.password = password;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        UserObj.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        UserObj.lastName = lastName;
    }

    public static int getSSN() {
        return SSN;
    }

    public static void setSSN(int SSN) {
        UserObj.SSN = SSN;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
