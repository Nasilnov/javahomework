package lesson4;

public class Main {

    public static void main(String[] args) {
        Workers workers = Workers.getInstance();

        workers.addWorker(new Worker("Василий Теркин","директор", 9219924556l, 50000, (short) 45));
        workers.addWorker(new Worker("Николай Капустин","механик", 9212854456l, 40000, (short) 40));
        workers.addWorker(new Worker("Маргарита Кукушкина","кадровик", 9115554456l, 45000, (short) 55));
        workers.addWorker(new Worker("Степанида Крышесносова","токарь высшего разряда", 9182224456l, 48000, (short) 30));
        workers.addWorker(new Worker("Саитдин Мухаммадов","разнорабочий", 9182224416l, 38000, (short) 48));

        workers.getAllWorkers().forEach((worker) ->
                worker.printAllDate()
        );

        System.out.println();

        workers.getSinglWorkerById(2).printAllDate();

        System.out.println();

        workers.getListWorkerByAgeMo(40).forEach((worker) ->
                worker.printAllDate()
        );

        workers.getListWorkerByAgeMo(45).forEach((worker) ->
                worker.addSarary(5000)
        );
        System.out.println();
        System.out.println("Замена зарплаты");
        System.out.println();

        workers.getListWorkerByAgeMo(45).forEach((worker) ->
                worker.printAllDate()
        );
    }

}



