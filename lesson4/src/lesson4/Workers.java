package lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Workers {
    private HashMap<Integer, Worker> workers = new HashMap<>();

    private static Workers instance;
    private Workers(){}
    public static Workers getInstance(){
        if(instance == null) {
            instance = new Workers();
        }
        return instance;
    }

    public void addWorker(Worker worker) {
        ArrayList<Integer> arr = new ArrayList<>();
        int id;
        this.workers.forEach((key, value) -> {
            arr.add(key);
        });
        if (arr.size() > 0) {
            Collections.sort(arr);
            id = arr.get(arr.size() - 1) + 1;
        }
        else {
            id = 1;
        }
        worker.setId(id);
        this.workers.put(id, worker);
    }

    public ArrayList<Worker> getAllWorkers(){
        ArrayList<Worker> arr = new ArrayList<>();
        this.workers.forEach((key,value)-> {
            arr.add(value);
        });
        return arr;
    }

    public Worker getSinglWorkerById(int id) {
        return this.workers.get(id);
    }

    public ArrayList<Worker> getListWorkerByAgeMo(int age) {
        ArrayList<Worker> arr = new ArrayList<>();
        this.workers.forEach((key, value) -> {
            if (value.getAge() > age) {
                arr.add(value);
            }
        });
        return arr;
    }
}
