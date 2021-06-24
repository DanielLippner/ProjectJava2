import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to currency converter");

        Scanner scanner = new Scanner(System.in);
        String answer= null;
        ArrayList<Double> savedResults= new ArrayList<Double>();
        do {
            System.out.println("Please choose an option(1/2/3)");
            int option = scanner.nextInt();
            Coin coin = null;
            boolean userChoice = true;
            Coins coins = null;
            while (userChoice) {
                switch (option) {
                    case 1:
                        userChoice = false;
                        System.out.println("Dollars to Shekels");
                        coins = Coins.ILS;
                        break;
                    case 2:
                        userChoice = false;
                        System.out.println("Shekels to Dollars");
                        coins = Coins.USD;
                        break;
                    case 3:
                        userChoice = false;
                        System.out.println("Shekels to Euro");
                        coins = Coins.EUR;
                        break;
                    default:
                        System.out.println("Invalid Choice, please try again.");
                        option = scanner.nextInt();
                        break;
                }
            }
            System.out.println("Please enter an amount to convert");
            double amount = scanner.nextDouble();
            coin = CoinFactory.getCoinInstance(coins);
            double sum = coin.calculate(amount);    
            savedResults.add(sum);
            System.out.println(sum);

            System.out.println("do you want to start over Y / N.");
            Scanner scanner2 = new Scanner(System.in);
            answer = scanner2.nextLine();
        }while (answer.equals("Y"));
        System.out.println("Thanks for using our currency converter.");
        try {
            FileWriter file = new FileWriter("results.txt");

        for (int i = 0; i < savedResults.size(); i++) {
            System.out.println(savedResults.get(i));
            file.write(String.valueOf(savedResults.get(i)+"\n"));


        }
        file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }


    }

