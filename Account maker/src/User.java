public class User{

    String username;
    String password;
    String age;
    String balance;
    String passwordLister;
    String email;

    User(String username, String passwordString, String ageString, String balanceString, String passwordLister){


        this.username = username;
        this.password = passwordString;
        this.age = ageString;
        this.balance = balanceString;
        this.passwordLister = passwordLister;
        this.email = this.username + "@someone.com";

    }

    @Override
    public String toString(){

        return this.username + " " + this.password + " " + this.passwordLister + this.age + " " + this.balance;
    }
}

