package view;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);
    public void menu(){
        System.out.print("""
                1. Добавление игрушек
                2. Розыгрыш игрушек
                3. Изменения частоты выпадания
                Выберите пункт меню:\s""");
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
    public int menuChangeFrequency(){
        System.out.println("Введите новую частоту выпадения: ");
        return in.nextInt();
    }
    public String menuInputName(){
        System.out.println("Введите название игрушки для замены частоты выпадения: ");
        return in.next();
    }
}
