public class New_User{

    String username;
    String password;;
    String age;
    String balance;
    String email;

    New_User(String username, String password, String ageString, String balanceString){


        this.username = username;
        this.password = password;
        this.age = ageString;
        this.balance = balanceString;
        this.email = this.username + "@someone.com";

    }

    @Override
    public String toString(){

        return this.username + " " + this.password + " " + this.age + " " + this.balance;
    }
}

