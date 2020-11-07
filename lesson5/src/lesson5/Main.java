package lesson5;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.run(250);

        Horse horse1 = new Horse();

        horse1.run(2000);
        horse1.jump(10);

        Cat cat2 = new Cat("Васька", 300, 3f );
        cat2.run(250);
        cat2.swim(100);

        Dog dog1 = new Dog();
        dog1.run(600);

        Shepherd dog2 = new Shepherd();

        dog2.run(700);

        Shepherd bobik = new Shepherd("Бобик", 1000, 5f, 2);
        bobik.jump(4.2f);

        Dog sharik = new Dog();

        sharik.maxSwimDistance = 10;

        Dog[] dogs = {dog1, dog2, bobik, sharik };

        for (int i = 0; i < dogs.length; i ++ ) {
            if (dogs[i] instanceof Shepherd ) {
                System.out.println(Shepherd.breed + " - " +(dogs[i].getName() != null ? dogs[i].getName() : "Без имени"));
            }
        }
    }
}
