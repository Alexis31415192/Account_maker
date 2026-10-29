import java.io.*;
import java.util.*;


public class Main {

    static Random random = new Random();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Account_maker 1.0.0dev (Dev build)
        //Choose
        try {

            for (int i = 0; i < 10; i++) {
                int numDots = i % 4;

                StringBuilder sb = new StringBuilder("\rLoading \"Account maker 0.1.0\"");

                for (int j = 0; j < numDots; j++) {
                    sb.append(".");
                }
                for (int j = numDots; j < 3; j++) {
                    sb.append(" ");
                }
                System.out.print(sb.toString());
                Thread.sleep(400);
            }
            
            System.out.print("\rLoading complete!   \n");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("\nLoading interrupted.");
        }

        System.out.println("WELCOME COMRADE!\n");

        System.out.println("""
                            -------------------------------------------------
                           |*Select                                          |
                           |1. Continue with CLI (fast, but unfamiliar)      |
                           |2. switch to GUI (Not as fast, but more familiar)|
                            -------------------------------------------------
                           """);
        System.out.print("Choose (1/2): ");
        int interFace = scanner.nextInt();

        if(interFace == 1) {

            cli();

            scanner.close();
        }
        else if(interFace == 2){

            ProgramFrame frame = new ProgramFrame();

            System.out.println(frame);
        }

    }
    static void ShowBalance(double balance){
        System.out.printf("§%.2f\n", balance);
    }
    static double deposit(){
        System.out.print("Enter a amount to deposit: ");
        double amount1 = scanner.nextDouble();

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
        double withdraw = scanner.nextDouble();

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
        scanner.nextLine();
        String adminPassword = scanner.nextLine();

        if("JavaIsTheBestILOVEJAVA".equals(adminPassword)) {
            System.out.print("Enter interest rate (in %): ");
            double rate = scanner.nextDouble() / 100;

            System.out.print("Enter # of times compounded per year: ");
            int timesCompounded = scanner.nextInt();

            System.out.print("Enter the # of years: ");
            int years = scanner.nextInt();

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
                |   .   |
                |       |
                 -------
                """;

        String dice2 = """
                 -------
                | .     |
                |       |
                |     . |
                 -------
                """;

        String dice3 = """
                 -------
                | .     |
                |   .   |
                |     . |
                 -------
                """;

        String dice4 = """
                 -------
                | .   . |
                |       |
                | .   . |
                 -------
                """;

        String dice5 = """
                 -------
                | .   . |
                |   .   |
                | .   . |
                 -------
                """;

        String dice6 = """
                 -------
                | .   . |
                | .   . |
                | .   . |
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
    static void credits(){



            boolean credits = true;

            while(credits){

                System.out.println("""
                                                ---------------------------------------------------------
                                                |********************************************************|
                                                |                CREDITS AND CONTRIBUTION                |
                                                |********************************************************|
                                                ---------------------------------------------------------
                                                      This was created by The Socialist Dragon
                                                THIS PROGRAM WAS CREATED TO APPLY ALL MY JAVA KNOWLEDGE
                                                
                                                   Developers
                                                   ~~~~~~~~~~
                                                   The Socialist Dragon:
                                                       - Created this
                                                       - Optimises this program
                                                       - Tryhard
                                                       - Possible femboy
                                                       - Adds cool features :3
                                                       
                                                       
                                                   Code used within Account maker
                                                   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                                %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
                                                Name: Account_maker
                                                Author: The Socialist Dragon
                                                GitHub URL: https://github.com/Alexis31415192/Account_maker
                                                Language: Java
                                                SDK: Java Oracle OpenJDK v26.0.2
                                                Language level: 17
                                                IDE: IntelliJ (free) IDE
                                                Currently running in: Terminal
                                                
                                                /**
                                                *No licence 2026 ReevTek (cool name isn't it?)
                                                *Most programs are intellectual property of @BroCodez !
                                                */                                                
                                                %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   
                                                """);
                System.out.print("View attribution? (true/false): ");
                boolean attribution = scanner.nextBoolean();

                if(attribution){

                    System.out.println("""
                                                                 ------------------------------------------------------------------------------
                                                                |******************************************************************************|
                                                                |                                 ATTRIBUTIONS                                 |
                                                                |******************************************************************************|
                                                                |                                                                              |
                                                                | - [@BroCodez] Developed most programs in his awesome Java tutorial on YouTube|
                                                                |   (Seriously, sub to his channel he's a chad).                               |
                                                                 ------------------------------------------------------------------------------""");
                }
                else if(!attribution){

                    credits = false;
                }
            }
    }
    static void cli(){

        System.out.println(" _______________________________");
        System.out.println("|*******************************|");
        System.out.println("|        ACCOUNT CREATOR        |");
        System.out.println("|*******************************|");
        System.out.println("|*What would you like to do?    |");
        System.out.println("|1. Sign on                     |");
        System.out.println("|2. Sign up                     |");
        System.out.println("|-To exit, press any other key  |");
        System.out.println("|*******************************|");
        System.out.println(" -------------------------------");
        System.out.print("Enter choice (1-2): ");
        int signIn = scanner.nextInt();

        switch (signIn) {
            case 1 -> {
                scanner.nextLine();

                System.out.println("Place file directory here, at the end of the directory, put \\[FILE].txt: ");
                String dir = scanner.nextLine();

                try (BufferedReader reader = new BufferedReader(new FileReader(dir))) {

                    String username = reader.readLine();
                    String password = reader.readLine();
                    String passwordListString = reader.readLine();
                    String ageString = reader.readLine();
                    String balanceString = reader.readLine();
                    scanner.nextLine();

                    System.out.print("Please verify yourself with your password (add space before the password): ");
                    String verify = scanner.nextLine();

                    if (verify.equals(password)) {

                        List<String> passwordList = new ArrayList<String>(Arrays.asList(passwordListString.split(" - ")));

                        boolean programRunning = true;

                        while (programRunning) {

                            System.out.println("*******************************************************");
                            System.out.println("1. Enter Virtual Bank*********************************");
                            System.out.println("2. Enter DICE ROLLER**********************************");
                            System.out.println("3. Enter MATRIX GENERATOR*****************************");
                            System.out.println("4. Enter FAKE NUMPAD**********************************");
                            System.out.println("5. Edit profile***************************************");
                            System.out.println("6. View/Edit password list****************************");
                            System.out.println("7. View credits and attribution***********************");
                            System.out.println("8. Save account***************************************");
                            System.out.println("*******************************************************");
                            System.out.print("Enter a choice (1-7): ");
                            int Choice = scanner.nextInt();
                            boolean isRunning = true;

                            double balance = Double.parseDouble(balanceString);

                            switch (Choice) {

                                case 1 -> {

                                    System.out.println("Entering virtual bank...\n");

                                    while (isRunning) {

                                        //Bank program

                                        System.out.println(" ___________________________________________");
                                        System.out.println("|*******************************************|");
                                        System.out.println("|              VIRTUAL BANK                 |");
                                        System.out.println("|*******************************************|");
                                        System.out.println("|1. View balance                            |");
                                        System.out.println("|2. Deposit                                 |");
                                        System.out.println("|3. Withdraw                                |");
                                        System.out.println("|4. Slot machine                            |");
                                        System.out.println("|5. Compound interest (ADMINS ONLY!)        |");
                                        System.out.println("|-To exit the program, enter any other key  |");
                                        System.out.println("|*******************************************|");
                                        System.out.println(" -------------------------------------------");
                                        System.out.print("Enter choice (1-5): ");
                                        int Choice1 = scanner.nextInt();

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
                                                    int bet = scanner.nextInt();
                                                    scanner.nextLine();

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
                                                    String gamble = scanner.nextLine();

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
                                        numOfDice = scanner.nextInt();

                                        if (numOfDice > 0) {

                                            for (int i = 0; i < numOfDice; i++) {
                                                int roll = random.nextInt(1, 7);
                                                printDie(roll);
                                                System.out.println("You rolled: " + roll);
                                                total += roll;

                                            }
                                            System.out.println("Total: " + total);
                                        } else {
                                            System.out.println("# of dice must be greater than 0");
                                        }

                                        System.out.print("Continue? (true/false): ");
                                        boolean choice = scanner.nextBoolean();

                                        if (choice) {

                                        } else if (!choice) {

                                            break;
                                        }
                                    }

                                }
                                case 3 -> {

                                    System.out.print("Enter # of columns: ");
                                    int columns = scanner.nextInt();

                                    System.out.print("Enter the # of rows: ");
                                    int rows = scanner.nextInt();

                                    System.out.print("Enter symbol: ");
                                    char symbol = scanner.next().charAt(0);

                                    for (int i = 0; i < rows; i++) {
                                        for (int j = 0; j < columns; j++) {
                                            System.out.print(symbol + " ");
                                        }
                                        System.out.println();
                                    }
                                }

                                case 4 -> {
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

                                case 5 -> {

                                    String[] account = {username, password, ageString,};

                                    boolean isFound = false;

                                    scanner.nextLine();
                                    System.out.print("Enter property to search (add String at the end of age and passkey and add a space at the beginning and end of the input): ");
                                    String target = scanner.nextLine();

                                    for (int i = 0; i < account.length; i++) {

                                        if (account[i].equals(target)) {
                                            System.out.print("Property found at index: " + i + "\n");
                                            System.out.print("Edit? (true/false): ");
                                            boolean edit = scanner.nextBoolean();
                                            scanner.nextLine();

                                            if (edit) {

                                                if (account[0].equals(target)) {

                                                    System.out.print("EDIT: ");
                                                    username = scanner.nextLine();
                                                }
                                                if (account[1].equals(target)) {

                                                    System.out.print("EDIT: ");
                                                    password = scanner.nextLine();
                                                }
                                                if (account[2].equals(target)) {

                                                    System.out.println("Placeholder");
                                                }
                                                if (account[3].equals(target)) {

                                                    System.out.print("EDIT: ");
                                                    ageString = scanner.nextLine();
                                                }
                                            }

                                            isFound = true;
                                            break;
                                        }
                                    }
                                    if (!isFound) {

                                        System.out.println("Couldn't find property :(");
                                    }
                                }

                                case 6 -> {

                                    scanner.nextLine();
                                    System.out.print("Please enter your password (Add space before password): ");
                                    String security = scanner.nextLine();

                                    if(security.equals(password)){

                                        System.out.println(passwordList);
                                        System.out.print("Edit? (true/false): ");
                                        boolean edit = scanner.nextBoolean();

                                        System.out.println();
                                    }
                                    else{

                                        System.out.println("Entry denied");
                                    }
                                }

                                case 7 -> credits();

                                case 8 -> {

                                    scanner.nextLine();
                                    System.out.print("Enter your password: ");
                                    String verify2 = scanner.nextLine();

                                    if (verify2.equals(password)) {

                                        String usernameNew = username + "\n";
                                        String passwordNew = password.replaceAll("\\s+", "") + "\n";
                                        String ageNew = ageString + "\n";
                                        String balanceNew = balance + "\n";

                                        New_User newUser = new New_User(usernameNew, passwordNew, ageNew, balanceNew);

                                        System.out.print("Enter a custom directory to save your account");
                                        String newDir = scanner.nextLine();


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
                    } else {

                        System.out.println("Fuck off");
                    }

                } catch (IOException e) {

                    System.out.println("SCRAP DOODLE or smth like that...");
                }
            }

            case 2 -> {

                String newLine = "\n";

                ArrayList<String> passwordList = new ArrayList<>();

                scanner.nextLine();

                System.out.print("Create a unique username: ");
                String username = scanner.nextLine() + newLine;


                while (username.isEmpty()) {
                    System.out.print("Create a username: ");
                    username = scanner.nextLine() + newLine;
                }
                while (username.length() < 4 || username.length() > 12 && username.contains(" ")) {
                    System.out.print("Username needs to be shorter or larger\n");
                    username = scanner.nextLine() + newLine;
                }
                if (username.length() >= 4 || username.length() <= 12) {

                    System.out.print("Create a strong password: ");
                    String password = scanner.nextLine();

                    while (password.length() < 8) {
                        System.out.println("Your password is too weak!(Like your self esteem)");
                        System.out.println("Try another one");
                        password = scanner.nextLine();

                    }
                    if (password.length() >= 8) {

                        //Passkey prompt

                        System.out.print("Do you want to make a passkey lock? (true/false): ");
                        boolean passkeyYes = scanner.nextBoolean();

                        //Welcome

                        System.out.println("Welcome " + username);
                        System.out.println("Password set: " + password);

                        if (passkeyYes) {
                            System.out.println("Passkey made");
                            System.out.print("Enter # of passwords you want to save in lock: ");
                            int numPass = scanner.nextInt();
                            scanner.nextLine();

                            for (int i = 0; i < numPass; i++) {

                                System.out.print("Enter password " + i + " : ");
                                String passwords = scanner.nextLine();

                                passwordList.add(passwords);
                            }
                            System.out.println(passwordList);
                        } else {
                            System.out.println("Passkey canceled");
                        }

                        //Age verification

                        System.out.print("Enter your real age: ");
                        int age = scanner.nextInt();

                        if (age >= 18) {

                            System.out.println("Alright you can come in :)");
                            System.out.println("Account fully created!");

                            double balance = 0.0;

                            boolean programRunning = true;

                            while (programRunning) {

                                System.out.println("*********************************************");
                                System.out.println("1. Enter Virtual Bank***********************");
                                System.out.println("2. Enter DICE ROLLER************************");
                                System.out.println("3. Enter MATRIX GENERATOR*******************");
                                System.out.println("4. Enter FAKE NUMPAD************************");
                                System.out.println("5. View credits*****************************");
                                System.out.println("6. Fully register your account (RECOMMENDED)");
                                System.out.println("*********************************************");
                                System.out.print("Enter a choice (1-6): ");
                                int Choice = scanner.nextInt();
                                scanner.nextLine();

                                boolean isRunning = true;

                                switch (Choice) {

                                    case 1 -> {

                                        System.out.println("Entering virtual bank...\n");

                                        while (isRunning) {

                                            //Bank program

                                            System.out.println(" ___________________________________________");
                                            System.out.println("|*******************************************|");
                                            System.out.println("|              VIRTUAL BANK                 |");
                                            System.out.println("|*******************************************|");
                                            System.out.println("|1. View balance                            |");
                                            System.out.println("|2. Deposit                                 |");
                                            System.out.println("|3. Withdraw                                |");
                                            System.out.println("|4. Slot machine                            |");
                                            System.out.println("|5. Compound interest (ADMINS ONLY!)        |");
                                            System.out.println("|-To exit the program, enter any other key  |");
                                            System.out.println("|*******************************************|");
                                            System.out.println(" -------------------------------------------");
                                            System.out.print("Enter choice (1-5): ");
                                            int Choice1 = scanner.nextInt();

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
                                                        int bet = scanner.nextInt();
                                                        scanner.nextLine();

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
                                                        String gamble = scanner.nextLine();

                                                        if (gamble.equals("false")) {
                                                            break;
                                                        } else if (gamble.equals("true")) {

                                                        }
                                                    }
                                                }

                                                case 5 -> {

                                                    Interest(balance);
                                                    balance = Interest(balance);
                                                }

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
                                            numOfDice = scanner.nextInt();

                                            if (numOfDice > 0) {

                                                for (int i = 0; i < numOfDice; i++) {
                                                    int roll = random.nextInt(1, 7);
                                                    printDie(roll);
                                                    System.out.println("You rolled: " + roll);
                                                    total += roll;
                                                }
                                                System.out.println("Total: " + total);
                                            } else {
                                                System.out.println("# of dice must be greater than 0");
                                            }

                                            System.out.print("Continue? (true/false): ");
                                            boolean choice = scanner.nextBoolean();

                                            if (choice) {

                                            } else if (!choice) {

                                                break;
                                            }
                                        }

                                    }
                                    case 3 -> {

                                        System.out.print("Enter # of columns: ");
                                        int columns = scanner.nextInt();

                                        System.out.print("Enter the # of rows: ");
                                        int rows = scanner.nextInt();

                                        System.out.print("Enter symbol: ");
                                        char symbol = scanner.next().charAt(0);

                                        for (int i = 0; i < rows; i++) {
                                            for (int j = 0; j < columns; j++) {
                                                System.out.print(symbol + " ");
                                            }
                                            System.out.println();
                                        }
                                    }

                                    case 4 -> {
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

                                    case 5 -> credits();

                                    case 6 -> {

                                        scanner.nextLine();

                                        String ageString = " " + String.valueOf(age) + "\n";
                                        String balanceString = String.valueOf(balance) + "\n";
                                        String passwordString = String.valueOf(password) + "\n";
                                        String passwordLister = String.join(" - ", passwordList) + "\n";

                                        User user = new User(username, passwordString, ageString, balanceString, passwordLister);

                                        System.out.print("Enter your password: ");
                                        String verify = scanner.nextLine();

                                        if (verify.equals(password)) {

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

                        } else if (age == 0) {
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
    }
}
