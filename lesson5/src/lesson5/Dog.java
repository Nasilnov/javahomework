package lesson5;

public class Dog extends Animal {


    public Dog() {
      super.maxRunDistance = 500;
      super.maxJumpDistance = 0.5f;
      super.maxSwimDistance = 10;
    }

    public Dog(String name, int maxRunDistance, float maxJumpDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxJumpDistance, maxSwimDistance);
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Пес "+ (name != null ? name : "") + " пробежал - " + distance + " метров");
        }
        else {
            System.out.println("Пес "+ (name != null ? name : "") + " пробежал - " + maxRunDistance + " метров. Больше не может");
        }
    }


    public void jump(float height) {
        if (height <= maxJumpDistance) {
            System.out.println("Пес "+ (name != null ? name : "") + " прыгнул - " + height + " метров");
        }
        else {
            System.out.println("Пес "+ (name != null ? name : "") + " прыгнул - " + maxJumpDistance + " метров. Больше не может");
        }
    }


    public void swim(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Пес "+ (name != null ? name : "") + " проплыл - " + distance + " метров");
        }
        else {
            System.out.println("Пес "+ (name != null ? name : "") + " проплыл - " + maxRunDistance + " метров. Больше не может");
        }
    }

}
