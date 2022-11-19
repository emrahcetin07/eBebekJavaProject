package patikaStore;


import java.util.Scanner;

import storeEntity.Brand;
import storeEntity.MobilePhone;
import storeEntity.Notebook;

public class PatikaStore {
    Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("*****Welcome to PatikaStore*****  !");
            System.out.println(" 1 -Notebook Operations\n" +
                    " 2 - Mobile Phone Operations\n" +
                    " 3 - List Brands\n" +
                    " 4 - Exit");
            System.out.print("Select the transaction number you want to make: ");

            switch (scanner.nextInt()) {
                case 1://for notebook
                    Notebook notebook=new Notebook();
                    notebook.menu();
                    break;
                case 2://for mobile phone
                    MobilePhone mobilePhone=new MobilePhone();
                    mobilePhone.menu();
                    
                    break;
                case 3:
                    Brand.printBrands();
                    break;
                case 4:
                    System.out.println("We'll Wait Again, Have a Nice Day");
                    System.exit(0);
                    break;
                default:
                    System.out.println("404 Not Found.");
                    break;
            }
        }
    }
}
