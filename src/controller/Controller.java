package controller;

import model.Toy;
import service.DataService;
import view.View;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Controller {
    Scanner in = new Scanner(System.in);
    DataService dataService;
    View view;

    public Controller() {
        dataService = new DataService();
        view = new View();
    }


    public void run() {
        while (true) {
            view.menu();
            int menuItem = 0;
            if(in.hasNextInt()) {
                menuItem = in.nextInt();
            } else {
                System.out.println("Ошибка! нужно ввести число!");
            }

            if (menuItem == 1) {
                Toy toy = new Toy(view.menuAddName(),
                        view.menuAddQuantity(),
                        view.menuAddFrequency());
                dataService.addToysToQueue(toy);
            } else if (menuItem == 2){
                dataService.startLottery();
            } else if (menuItem == 3){
                //PriorityQueue pq = dataService.getQueueList();
                System.out.println("заглушка");
                break;
            } else {
                System.out.println("Программа завершена");
                break;
            }
        }

    }
}
