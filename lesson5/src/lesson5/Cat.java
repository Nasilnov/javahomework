package lesson5;

public class Cat extends Animal {


    public Cat () {
      super.maxRunDistance = 200;
      super.maxJumpDistance = 2;
    }

    public Cat(String name, int maxRunDistance, float maxJumpDistance) {
        super(name, maxRunDistance, maxJumpDistance);
    }


    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Кот "+ (name != null ? name : "") + " пробежал - " + distance + " метров");
        }
        else {
            System.out.println("Кот "+ (name != null ? name : "") + " пробежал - " + maxRunDistance + " метров. Больше не может");
        }
    }


    public void jump(float height) {
        if (height <= maxJumpDistance) {
            System.out.println("Кот "+ (name != null ? name : "") + " прыгнул - " + height + " метров");
        }
        else {
            System.out.println("Кот "+ (name != null ? name : "") + " прыгнул - " + maxJumpDistance + " метров. Больше не может");
        }
    }

    public void swim(int distance) {
        System.out.println("Кот "+ (name != null ? name : "") + " не поплывет - не умеет");
    }
}
