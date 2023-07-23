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
            pq.add(new Toy(toy.getName(), toy.getQuantity(), 100 - random.nextInt(toy.getFrequency())));
        }
        return pq;
    }
    public PriorityQueue<Toy> getQueueList(){
        return pq;
    }
    public void startLottery() {
        ArrayList<Toy> winnersList = new ArrayList<>();
        if (pq.size() > 0) {
            for (int i = 0; i < 3; i++) {
                Toy winToy = pq.poll();
                winnersList.add(winToy);
            }
            System.out.printf("Список призов: %s\n", winnersList);
        } else {
            System.out.println("Список игрушек пуст");
        }
        try(FileWriter fw = new FileWriter(path, StandardCharsets.UTF_8, false)){
            for(Toy toy : winnersList){
                fw.write(toy.toString() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
