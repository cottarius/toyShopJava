package view;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);
    public void menu(){
        System.out.print("1. Добавление игрушек" +
                "\n2. Розыгрыш игрушек" +
                "\nВыберите пункт меню: ");
    }
    public String menuAddName(){
        System.out.println("Введите название игрушки: ");
        return in.next();
    }
    public int menuAddQuantity(){
        System.out.println("Введите количество: ");
        return in.nextInt();
    }
    public int menuAddFrequency(){
        System.out.println("Введите частоту выпадения: ");
        return in.nextInt();
    }
}
