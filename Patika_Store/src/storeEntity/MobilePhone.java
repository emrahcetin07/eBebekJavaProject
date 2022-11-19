package storeEntity;

import java.util.ArrayList;

import storeDao.Product;


public class MobilePhone extends Product{ //inhertance
    private static int pId=1;
    private int battery;
    private String color;
    private int camResolution;
    private static ArrayList<MobilePhone> phones=new ArrayList<>();

    public MobilePhone(){// null const.

    }

    public MobilePhone(String name, double price, int discountRate, int amount,
                       Brand brand, double screenSize, int ram, int memory,
                       int battery, String color, int camResolution) {
        super(pId,name, price, discountRate, amount, brand, screenSize, ram, memory);//inherite product constructer
        pId++;
        this.battery=battery;
        this.color=color;
        this.camResolution=camResolution;
    }

    @Override
    public void menu() {
        System.out.println("1- Add New Mobile Phone\n" +
                "2- Mobile Phone list display\n" +
                "3- Delete Mobile Phone\n" +
                "4- Mobile Phone Sorting\n" +
                "5- Mobile Phone Filtering(by Brand)");
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
        System.out.print(" Name : ");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.print("Discount Rate : ");
        int discountRate= scanner.nextInt();
        System.out.print("Stock : ");
        int amount= scanner.nextInt();
        System.out.print("RAM: ");
        int ram= scanner.nextInt();
        System.out.print("Screen Size : ");
        double screenSize= scanner.nextDouble();
        System.out.print("Memory:");
        int memory= scanner.nextInt();
        System.out.print("Battery Capacity: ");
        int battery= scanner.nextInt();
        scanner.nextLine();
        System.out.print("Color: ");
        String color= scanner.nextLine();
        System.out.print("Camera Resolution : ");
        int camResolution= scanner.nextInt();
        Brand.printBrands();
        System.out.print("Select Brand: ");
        Brand brand=Brand.getBrand(scanner.nextInt());
        MobilePhone phone=new MobilePhone(name,price,discountRate,amount,brand,screenSize,ram,memory,battery,color,camResolution);
        phones.add(phone);
        System.out.println("Added Mobile Phone's ID :"+phone.getId());
    }

    public void getProducts() {
        print(null);
    }

    public void print(ArrayList<MobilePhone> phoneList){
        if(phoneList==null) phoneList=this.phones;
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Name      | Price | Brand  | Stock  | Discount Rate | RAM  |Screen Size  | Memory   | Battery Capacity | Color  | Camera  |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n:phoneList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory(),n.getBattery(),n.getColor(),n.getCamResolution());
        }
    }

    @Override
    public void deleteItem(){
        getProducts();
        System.out.print("Enter the ID of the mobile phone you want deleted : ");
        int id=scanner.nextInt();
        phones.remove(id-1);
        System.out.println("Current Mobile Phone List ");
        getProducts();
    }

    public void brandFilter(){
        scanner.nextLine();
        System.out.print("Enter the product brand to be filtered:");
        String filter= scanner.nextLine();
        ArrayList<MobilePhone> filterPhones=new ArrayList<>();
        for (MobilePhone n:phones){
            if(filter.equals(n.getBrand().getName())){
                filterPhones.add(n);
            }
        }
        print(filterPhones);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(int camResolution) {
        this.camResolution = camResolution;
    }

    public static int getpId() {
        return pId;
    }
}