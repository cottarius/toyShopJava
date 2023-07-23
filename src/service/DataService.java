package service;

import model.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;


public class DataService {
    String path = "prizeList.txt";
    private PriorityQueue<Toy> pq = new PriorityQueue<>();
    Random random = new Random();
    public PriorityQueue<Toy> addToysToQueue(Toy toy) {
        for (int i = 0; i < toy.getQuantity(); i++) {
            pq.add(new Toy(toy.getName(), toy.getQuantity(), toy.getFrequency() + random.nextInt(10)));
        }
        return pq;
    }
    public PriorityQueue<Toy> changeFrequency(String name, int frequency){
        for (Toy toy : pq){
            if (toy.getName().equals(name)){
                toy.setFrequency(frequency);
            }
        }
        return pq;
    }
    public void startLottery() {
        ArrayList<Toy> winnersList = new ArrayList<>();
        if (pq.size() > 0) {
            for (int i = 0; i < 3; i++) {
                if(pq.size() > 0) {
                    Toy winToy = pq.poll();
                    winnersList.add(winToy);
                } else {
                    winnersList.add(null);
                }
            }
            System.out.printf("Список призов: %s\n", winnersList);
        } else {
            System.out.println("Список игрушек пуст");
        }
        try(FileWriter fw = new FileWriter(path, StandardCharsets.UTF_8, false)){
            for(Toy toy : winnersList){
                if (toy != null) {
                    fw.write(toy + "\n");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
