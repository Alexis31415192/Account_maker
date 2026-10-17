import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random randomize = new Random();

    static Scanner module = new Scanner(System.in);

    public static void main(String[] args) {

        //Choose [WIP]
        System.out.println(" _______________________________");
        System.out.println("⌈*******************************⌉");
        System.out.println("|        ACCOUNT CREATOR        |");
        System.out.println("|*******************************|");
        System.out.println("|*What would you like to do?    |");
        System.out.println("|1. Sign on                     |");
        System.out.println("|2. Sign up                     |");
        System.out.println("|-To exit, press any other key  |");
        System.out.println("⌊*******************************⌋");
        System.out.println(" ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
        System.out.print("Enter choice (1-2): ");
        int signIn = module.nextInt();

        switch (signIn){
            case 1 -> {
                module.nextLine();

                System.out.println("(PRESS ENTER TWICE) Place file directory here (use \\ instead to separate files, ex: X:\\Users...) at the end of the directory, put \\[FILE].txt: ");
                String dir = module.nextLine();

                try(BufferedReader reader = new BufferedReader(new FileReader(dir))){

                    String username = reader.readLine();

                    String password = reader.readLine();

                    String passkeyString = reader.readLine();

                    String ageString = reader.readLine();

                    String balanceString = reader.readLine();
                    module.nextLine();

                    System.out.print("Please verify yourself with your password (add space before and after the password): ");
                    String verify = module.nextLine();

                    if(verify.equals(password)){

                        boolean programRunning = true;

                        while(programRunning) {

                            System.out.println("*******************************************************");
                            System.out.println("1. Enter Virtual Bank*********************************");
                            System.out.println("2. Enter DICE ROLLER**********************************");
                            System.out.println("4. Enter TABLE DRAWER*********************************");
                            System.out.println("5. Enter fake numpad**********************************");
                            System.out.println("6. View your info (useless)***************************");
                            System.out.println("7. Save account***************************************");
                            System.out.println("*******************************************************");

                            System.out.print("Enter a choice (1-7): ");
                            int Choice = module.nextInt();
                            boolean isRunning = true;

                            double balance = Double.parseDouble(balanceString);

                            switch (Choice) {

                                case 1 -> {

                                    System.out.println("Entering virtual bank...\n");

                                    while (isRunning) {

                                        //Bank program

                                        System.out.println(" ___________________________________________");
                                        System.out.println("⌈*******************************************⌉");
                                        System.out.println("|              VIRTUAL BANK                 |");
                                        System.out.println("|*******************************************|");
                                        System.out.println("|1. View balance                            |");
                                        System.out.println("|2. Deposit                                 |");
                                        System.out.println("|3. Withdraw                                |");
                                        System.out.println("|4. Slot machine                            |");
                                        System.out.println("|5. Compound interest (ADMINS ONLY!)        |");
                                        System.out.println("|-To exit the program, enter any other key  |");
                                        System.out.println("⌊*******************************************⌋");
                                        System.out.println(" ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
                                        System.out.print("Enter choice (1-5): ");
                                        int Choice1 = module.nextInt();

                                        switch (Choice1) {
                                            case 1 -> ShowBalance(balance);

                                            case 2 -> balance += deposit();

                                            case 3 -> balance -= Withdraw(balance);

                                            case 4 -> {
                                                String[] row;

                                                System.out.println("  ******************************");
                                                System.out.println("   WELCOME TO THE SLOT MACHINE!");
                                                System.out.println("  ******************************");
                                                System.out.println("%%%%%%%%%🍒 🍉 🍋 🔔 ⭐ %%%%%%%%%");
                                                while (balance > 0) {
                                                    System.out.println("Current balance: §" + balance);
                                                    System.out.print("Place your desired bet: ");
                                                    int bet = module.nextInt();
                                                    module.nextLine();

                                                    if (bet > balance) {
                                                        System.out.println("INSUFFICIENT FUNDS!");
                                                    } else if (bet <= 0) {
                                                        System.out.println("NEGATIVE BETTING IS ILLEGAL!");
                                                    } else {
                                                        balance -= bet;
                                                    }
                                                    System.out.println("Spinning...");
                                                    row = Spinrow();
                                                    printRow(row);
                                                    getPayout(row, bet);
                                                    int payOut = getPayout(row, bet);

                                                    if (payOut > 0) {

                                                        System.out.println("You won: §" + payOut);

                                                    } else {
                                                        System.out.println("Touché");
                                                    }
                                                    System.out.println("Would you like to play again? (true/false)");
                                                    String gamble = module.nextLine();

                                                    if (gamble.equals("false")) {
                                                        break;
                                                    } else if (gamble.equals("true")) {

                                                    }
                                                }
                                            }

                                            case 5 -> Interest(balance);

                                            default -> isRunning = false;
                                        }

                                    }

                                }

                                case 2 -> {

                                    //Dice roller by: @BroCodez

                                    while (isRunning) {

                                        int numOfDice;
                                        int total = 0;

                                        System.out.print("Enter the # of dice to roll: ");
                                        numOfDice = module.nextInt();

                                        if (numOfDice > 0) {

                                            for (int i = 0; i < numOfDice; i++) {
                                                int roll = randomize.nextInt(1, 7);
                                                printDie(roll);
                                                System.out.println("You rolled: " + roll);
                                                total += roll;
                                            }
                                            System.out.println("Total: " + total);
                                        } else {
                                            System.out.println("# of dice must be greater than 0");
                                        }
                                    }

                                }
                                case 4 -> {

                                    System.out.print("Enter # of columns: ");
                                    int columns = module.nextInt();

                                    System.out.print("Enter the # of rows: ");
                                    int rows = module.nextInt();

                                    System.out.print("Enter symbol: ");
                                    char symbol = module.next().charAt(0);

                                    for (int i = 0; i < rows; i++) {
                                        for (int j = 0; j < columns; j++) {
                                            System.out.print(symbol + " ");
                                        }
                                        System.out.println();
                                    }
                                }

                                case 5 -> {
                                    char[][] numPad = {{'1', '2', '3'},
                                            {'4', '5', '6'},
                                            {'7', '8', '9'},
                                            {'*', '0', '#'}};

                                    for (char[] pin : numPad) {
                                        for (char number : pin) {
                                            System.out.print(number + " ");
                                        }
                                        System.out.println();
                                    }
                                    System.out.println("What did you expect???");
                                }

                                case 6 -> {

                                    String[] account = {username, password, passkeyString, ageString,};

                                    boolean isFound = false;

                                    module.nextLine();
                                    System.out.print("Enter property to search (add String at the end of passkey and age): ");
                                    String target = module.nextLine();

                                    for (int i = 0; i < account.length; i++) {

                                        if (account[i].equals(target)) {
                                            System.out.print("Element found at index: " + i);

                                            isFound = true;
                                            break;
                                        }
                                    }
                                    if (!isFound) {

                                        System.out.println("Couldn't find property :(");
                                    }
                                }

                                case 7 -> {

                                    module.nextLine();
                                    System.out.print("Enter your password: ");
                                    String verify2 = module.nextLine();

                                    if (verify2.equals(password)) {

                                        String usernameNew = username + "\n";
                                        String passwordNew = password.replaceAll("\\s+", "") + "\n";
                                        String passkeyNew = passkeyString + "\n";
                                        String ageNew = ageString + "\n";
                                        String balanceNew = balance + "\n";

                                        New_User newUser = new New_User(usernameNew, passwordNew, passkeyNew, ageNew, balanceNew);

                                        System.out.println("Enter a custom directory to save your account");
                                        String newDir = module.nextLine();


                                        try (FileWriter writer = new FileWriter(newDir)) {

                                            String saveFile = String.valueOf(newUser);

                                            writer.write(saveFile);
                                            System.out.println("File successfully written");
                                        } catch (IOException e) {

                                            System.out.println("ERROR ENCOUNTERED WHILST TRYING TO WRITE FILE. this is either an incorrect path or this is a bug");
                                        }
                                    } else {
                                        System.out.println("PASSWORD MISMATCH");
                                    }
                                }
                            }
                        }
                    }
                    else{

                        System.out.println("Fuck off");
                    }

                }
                catch(IOException e){

                    System.out.println("SCRAP DOODLE or smth like that...");
                }
            }

            case 2 -> {

                String newLine = "\n";

                module.nextLine();

                System.out.print("Create a unique username: ");
                String username= module.nextLine() + newLine;


                while (username.isEmpty()){
                    System.out.print("Create a username: ");
                    username = module.nextLine() + newLine;
                }
                while(username.length() < 4 || username.length() > 12 && username.contains(" ")){
                    System.out.print("Username needs to be shorter or larger\n");
                    username = module.nextLine() + newLine;
                }
                if (username.length() >= 4 || username.length() <= 12){

                    System.out.print("Create a strong password: ");
                    String password = module.nextLine();

                    while(password.length() < 8) {
                        System.out.println("Your password is too weak!(Like your self esteem)");
                        System.out.println("Try another one");
                        password = module.nextLine();

                    }
                    if (password.length() >= 8) {

                        //Passkey prompt

                        System.out.println("Do you want to make a passkey lock? (true/false): ");
                        boolean passkeyYes = module.nextBoolean();

                        //Welcome

                        System.out.println("Welcome " + username);
                        System.out.println("Password set: " + password);

                        if (passkeyYes) {
                            System.out.println("Passkey made");
                        } else {
                            System.out.println("Passkey canceled");
                        }

                        //Age verification

                        System.out.println("Enter your real age: ");
                        int age = module.nextInt();

                        if (age >= 18) {

                            System.out.println("Alright you can come in :)");
                            System.out.println("Account fully created!");

                            double balance = 0.0;

                            boolean programRunning = true;

                            while(programRunning){

                                System.out.println("*********************************************");
                                System.out.println("1. Enter Virtual Bank***********************");
                                System.out.println("2. Enter DICE ROLLER************************");
                                System.out.println("4. Enter TABLE DRAWER***********************");
                                System.out.println("5. Enter fake numpad************************");
                                System.out.println("6. Fully register your account (RECOMMENDED)");
                                System.out.println("*********************************************");

                                System.out.print("Enter a choice (1-6): \n");
                                int Choice = module.nextInt();
                                module.nextLine();

                                boolean isRunning = true;

                                switch (Choice) {

                                    case 1 -> {

                                        System.out.println("Entering virtual bank...\n");

                                        while (isRunning) {

                                            //Bank program

                                            System.out.println(" ___________________________________________");
                                            System.out.println("⌈*******************************************⌉");
                                            System.out.println("|              VIRTUAL BANK                 |");
                                            System.out.println("|*******************************************|");
                                            System.out.println("|1. View balance                            |");
                                            System.out.println("|2. Deposit                                 |");
                                            System.out.println("|3. Withdraw                                |");
                                            System.out.println("|4. Slot machine                            |");
                                            System.out.println("|5. Compound interest (ADMINS ONLY!)        |");
                                            System.out.println("|-To exit the program, enter any other key  |");
                                            System.out.println("⌊*******************************************⌋");
                                            System.out.println(" ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
                                            System.out.print("Enter choice (1-5): ");
                                            int Choice1 = module.nextInt();

                                            switch (Choice1) {
                                                case 1 -> ShowBalance(balance);

                                                case 2 -> balance += deposit();


                                                case 3 -> balance -= Withdraw(balance);

                                                case 4 -> {
                                                    String[] row;

                                                    System.out.println("  ******************************");
                                                    System.out.println("   WELCOME TO THE SLOT MACHINE!");
                                                    System.out.println("  ******************************");
                                                    System.out.println("%%%%%%%%%🍒 🍉 🍋 🔔 ⭐ %%%%%%%%%");
                                                    while (balance > 0) {
                                                        System.out.println("Current balance: §" + balance);
                                                        System.out.print("Place your desired bet: ");
                                                        int bet = module.nextInt();
                                                        module.nextLine();

                                                        if (bet > balance) {
                                                            System.out.println("INSUFFICIENT FUNDS!");
                                                        } else if (bet <= 0) {
                                                            System.out.println("NEGATIVE BETTING IS ILLEGAL!");
                                                        } else {
                                                            balance -= bet;
                                                        }
                                                        System.out.println("Spinning...");
                                                        row = Spinrow();
                                                        printRow(row);
                                                        getPayout(row, bet);
                                                        int payOut = getPayout(row, bet);

                                                        if (payOut > 0) {

                                                            System.out.println("You won: §" + payOut);

                                                        } else {
                                                            System.out.println("Touché");
                                                        }
                                                        System.out.println("Would you like to play again? (true/false)");
                                                        String gamble = module.nextLine();

                                                        if (gamble.equals("false")) {
                                                            break;
                                                        } else if (gamble.equals("true")) {

                                                        }
                                                    }
                                                }

                                                case 5 -> Interest(balance);

                                                case 6 -> {

                                                }

                                                default -> isRunning = false;
                                            }

                                        }

                                    }

                                    case 2 -> {

                                        //Dice roller by: @BroCodez

                                        while(isRunning) {

                                            int numOfDice;
                                            int total = 0;

                                            System.out.print("Enter the # of dice to roll: ");
                                            numOfDice = module.nextInt();

                                            if (numOfDice > 0) {

                                                for (int i = 0; i < numOfDice; i++) {
                                                    int roll = randomize.nextInt(1, 7);
                                                    printDie(roll);
                                                    System.out.println("You rolled: " + roll);
                                                    total += roll;
                                                }
                                                System.out.println("Total: " + total);
                                            } else {
                                                System.out.println("# of dice must be greater than 0");
                                            }
                                        }

                                    }
                                    case 4 -> {

                                        System.out.print("Enter # of columns: ");
                                        int columns = module.nextInt();

                                        System.out.print("Enter the # of rows: ");
                                        int rows = module.nextInt();

                                        System.out.print("Enter symbol: ");
                                        char symbol = module.next().charAt(0);

                                        for (int i = 0; i < rows; i++) {
                                            for (int j = 0; j < columns; j++) {
                                                System.out.print(symbol + " ");
                                            }
                                            System.out.println();
                                        }
                                    }

                                    case 5 -> {
                                        char[][] numPad = {{'1', '2', '3'},
                                                {'4', '5', '6'},
                                                {'7', '8', '9'},
                                                {'*', '0', '#'}};

                                        for (char[] pin : numPad) {
                                            for (char number : pin) {
                                                System.out.print(number + " ");
                                            }
                                            System.out.println();
                                        }
                                        System.out.println("What did you expect???");
                                    }

                                    case 6 -> {

                                        module.nextLine();

                                        String ageString = String.valueOf(age) + "\n";
                                        String balanceString = String.valueOf(balance) + "\n";
                                        String passwordString = String.valueOf(password) + "\n";
                                        String passkeyString = String.valueOf(passkeyYes) + "\n";

                                        User user = new User(username, passwordString, passkeyString, ageString, balanceString);

                                        System.out.print("Enter your password: ");
                                        String verify = module.nextLine();

                                        if (verify.equals(password)){

                                            try (FileWriter writer = new FileWriter("C:\\Users\\user\\IdeaProjects\\Account maker\\LocalUsers\\Session.txt");) {

                                                String saveFile = String.valueOf(user);

                                                writer.write(saveFile);
                                                System.out.println("File successfully written");
                                            } catch (IOException e) {

                                                System.out.println("ERROR ENCOUNTERED WHILST TRYING TO WRITE FILE. this is either an incorrect path or this is a bug");
                                            }
                                        } else {
                                            System.out.println("PASSWORD MISMATCH");
                                        }
                                    }

                                    default -> System.out.println("INVALID ENTRY!");
                                }

                            }

                        }
                        else if (age == 0) {
                            System.out.println("How are you typing this shit??");
                        } else if (age < 0) {
                            System.out.println("What the fuck?!");
                        } else {
                            System.out.println("Get the fuck out of here before I smash you're little dick-face!!!");
                        }

                    }

                }
            }

            default -> System.out.println("Exiting program...");

        }
        module.close();

    }
    static void ShowBalance(double balance){
        System.out.printf("§%.2f\n", balance);
    }
    static double deposit(){
        System.out.print("Enter a amount to deposit: ");
        double amount1 = module.nextDouble();

        if(amount1< 0){
            System.out.println("The fuck is wrong with you?");
            return 0;
        }
        else{
            return amount1;
        }
    }
    static double Withdraw(double balance){

        System.out.print("Enter amount to withdraw: ");
        double withdraw = module.nextDouble();

        if(withdraw < 0) {
            System.out.println("Are you trying to withdraw your collage savings??");
            return 0;
        }
        else{
            return withdraw;
        }
    }
    static double Interest(double balance){

        //Compound interest

        System.out.print("Enter Administrator password: ");

        module.nextLine();

        String adminPassword = module.nextLine();

        if("PASSWORD".equals(adminPassword)) {
            System.out.println("Enter interest rate (in %): ");
            double rate = module.nextDouble() / 100;

            System.out.println("Enter # of times compounded per year: ");
            int timesCompounded = module.nextInt();

            System.out.println("Enter the # of years: ");
            int years = module.nextInt();

            double amount = balance * Math.pow(1 + rate / timesCompounded, timesCompounded * years);

            System.out.println("The amount after " + years + " is: § " + amount);

            return amount;
        }
        else{
            System.out.println("INVALID PASSWORD");
            System.out.println("SELF DESTRUCTING");

            return 0;

        }


    }
    static void printDie(int roll){

        String dice1 = """
                 -------
                |       |
                |   ●   |
                |       |
                 -------
                """;

        String dice2 = """
                 -------
                | ●     |
                |       |
                |     ● |
                 -------
                """;

        String dice3 = """
                 -------
                | ●     |
                |   ●   |
                |     ● |
                 -------
                """;

        String dice4 = """
                 -------
                | ●   ● |
                |       |
                | ●   ● |
                 -------
                """;

        String dice5 = """
                 -------
                | ●   ● |
                |   ●   |
                | ●   ● |
                 -------
                """;

        String dice6 = """
                 -------
                | ●   ● |
                | ●   ● |
                | ●   ● |
                 -------
                """;

        switch(roll){
            case 1 -> System.out.print(dice1);
            case 2 -> System.out.print(dice2);
            case 3 -> System.out.print(dice3);
            case 4 -> System.out.print(dice4);
            case 5 -> System.out.print(dice5);
            case 6 -> System.out.print(dice6);
            default -> System.out.print("Invalid roll");
        }
    }
    static String[] Spinrow(){
        String[] slots = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        String[] row = new String[3];
        Random random = new Random();

        for(int i = 0; i < 3; i++){
            row[i] = slots[random.nextInt(slots.length)];
        }

        return row;

    }
    static void printRow(String[] row){
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }
    static int getPayout(String[] row, double bet){

        if(row[0].equals(row[1])){

            return (int) switch(row[0]){

                case "🍒" -> bet * 3;

                case "🍉" -> bet * 4;

                case "🍋" -> bet * 5;

                case "🔔" -> bet * 10;

                case "⭐" -> bet * 20;

                default -> bet * 0;
            };

        }
        else if(row[1].equals(row[2])){

            return (int) switch(row[1]){

                case "🍒" -> bet * 2;

                case "🍉" -> bet * 3;

                case "🍋" -> bet * 4;

                case "🔔" -> bet * 5;

                case "⭐" -> bet * 10;

                default -> bet * 0;
            };

        }

        return 0;
    }
}
