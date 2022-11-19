package storeEntity;

import java.util.ArrayList;

import storeDao.Product;

public class Notebook extends Product{
    private static int nId=1;
    private static ArrayList<Notebook> notebooks=new ArrayList<>();


    public Notebook(String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory) {

        super(nId,name, price, discountRate, amount, brand, screenSize, ram, memory);
        nId++;
    }

    public Notebook(){

    }

    @Override
    public void menu() {

        System.out.println("1- Add Notebook\n" +
                           "2- Notebook  list display\n" +
                           "3- Delete Notebook \n" +
                           "4- Notebooks Sorting\n" +
                           "5-  Notebook Filtering(by Brand");
        System.out.print("Select The Action : ");
        int value=scanner.nextInt();
        if(value==1) addItem();
        if(value==2 || value==4) getProducts();
        if(value==3) deleteItem();
        if(value==5) brandFilter();

    }

    @Override
    public void addItem() {
        System.out.print("Price : ");
        double price= scanner.nextDouble();
        System.out.print("ÜName : ");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.print("Discount Rate : ");
        int discountRate= scanner.nextInt();
        System.out.print("Stock : ");
        int amount= scanner.nextInt();
        System.out.print("RAM : ");
        int ram= scanner.nextInt();
        System.out.print("Screen Size: ");
        double screenSize= scanner.nextDouble();
        System.out.print("Memory :");
        int memory= scanner.nextInt();
        //System.out.println("Ekran Listesi");
        Brand.printBrands();
        System.out.print("Select Brand : ");
        Brand brand=Brand.getBrand(scanner.nextInt());
        Notebook notebook=new Notebook(name,price,discountRate,amount,brand,screenSize,ram,memory);
        this.notebooks.add(notebook);
        System.out.println("Added Notebook's ID :"+notebook.getId());
    }

    @Override
    public void getProducts() {
        print(null);

    }

    public void print(ArrayList<Notebook> notebookList){
        if(notebookList==null) notebookList=this.notebooks;
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | ÜName                 | Price          | Brand         | Stock        | Discount Rate      | RAM    | Screen Sie    |Memory   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook n:notebookList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory());
        }
           }

    @Override
    public void deleteItem(){
        getProducts();
        System.out.print("Enter the ID of the notebook you want deleted : ");
        int id=scanner.nextInt();
        notebooks.remove(id-1);
        System.out.println("Current notebook list ");
        getProducts();
    }

    private void brandFilter() {
        scanner.nextLine();
        System.out.print("Enter the product brand you want to filter :");
        String filter= scanner.nextLine();
        ArrayList<Notebook> filterNotebooks=new ArrayList<>();
        for (Notebook n:notebooks){
            if(filter.equals(n.getBrand().getName())){
                filterNotebooks.add(n);
            }
        }
        print(filterNotebooks);
    }

    public static int getnId() {
        return nId;
    }
}