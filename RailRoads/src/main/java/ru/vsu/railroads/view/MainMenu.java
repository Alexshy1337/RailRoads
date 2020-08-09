package ru.vsu.railroads.view;

import ru.vsu.railroads.domain.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    private Scanner in = new Scanner(System.in);
    private TrainView trainView = new TrainView();

    public void run() {
        while (true) {
            System.out.println("====Menu====");
            System.out.println("1. Show");
            //System.out.println("2. Create");
            //System.out.println("3. Delete");
            //System.out.println("4. Edit");
            System.out.println("0. Exit");
            System.out.println("Awaiting input...");

            int menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    show();
                    break;
/*                case 2:
                    trainView.readItems(Route.class);
                    break;
                case 3:
                    trainView.readItems(FreightWagon.class);
                    break;
                case 4:
                    trainView.readItems(PassengerWagon.class);
                    break;
*/
                case 0:
                    System.exit(0);
                    break;
            }
            //menuItem = in.nextInt();
        }
    }

    private void create() {
        while(true) {
            System.out.println("====Create Menu====");
            System.out.println("1.Trains");
            //System.out.println("2.Route");
            System.out.println("3.Freight Wagon");
            System.out.println("4.Passenger Wagon");
            System.out.println("5.Locomotive");
            System.out.println("0.Back");
            System.out.println("Awaiting input...");
            int menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    createObj(Train.class);
                    break;
                //case 2:
                //createObj(Route.class);
                //break;
                case 3:
                    createObj(Wagon.class);
                    break;
                case 4:
                    createObj(Wagon.class);
                    break;
                case 5:
                    createObj(Locomotive.class);
                    break;
                case 0:
                    run();
                    break;
            }
        }
    }

    private <T> void createObj(Class<T> curClass){
        final Field[] declaredFields = curClass.getDeclaredFields();
        Map<String, String> params = new HashMap<>();
        for(Field f: declaredFields){
            String name = f.getName();
            if(!name.equals("id")) {
                System.out.println("Enter "+ name);
                params.put(name, in.nextLine());
            }
        }
        trainView.createItem(curClass.getSimpleName(), params);
    }

    private void show() {
        while (true) {
            System.out.println("====Show Menu====");
            System.out.println("1.Trains");
            //System.out.println("2.Routes");
            System.out.println("3.Freight Wagons");
            System.out.println("4.Passenger wagons");
            System.out.println("5.Locomotive");
            System.out.println("0.Back");
            System.out.println("Awaiting input...");
            int menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    trainView.readItems(Train.class);
                    break;
                //case 2:
                //trainView.readItems(Route.class);
                //break;
                case 3:
                    trainView.readItems(Wagon.class);
                    break;
                case 4:
                    trainView.readItems(Wagon.class);
                    break;
                case 5:
                    trainView.readItems(Locomotive.class);
                    break;
                case 0:
                    run();
                    break;
            }
        }
    }
}
