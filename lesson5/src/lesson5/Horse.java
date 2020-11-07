package lesson5;

public class Horse extends Animal {


    public Horse() {
      super.maxRunDistance = 1500;
      super.maxJumpDistance = 3;
      super.maxSwimDistance = 100;
    }

    public Horse(String name, int maxRunDistance, float maxJumpDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxJumpDistance, maxSwimDistance);
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Конь "+ (name != null ? name : "") + " пробежал - " + distance + " метров");
        }
        else {
            System.out.println("Конь "+ (name != null ? name : "") + " пробежал - " + maxRunDistance + " метров. Больше не может");
        }
    }


    public void jump(float height) {
        if (height <= maxJumpDistance) {
            System.out.println("Конь прыгнул -" + height + " метров");
        }
        else {
            System.out.println("Конь прыгнул -" + maxJumpDistance + " метров. Больше не может");
        }
    }

    public void swim(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Конь "+ (name != null ? name : "") + " проплыл - " + distance + " метров");
        }
        else {
            System.out.println("Конь "+ (name != null ? name : "") + " проплыл - " + maxRunDistance + " метров. Больше не может");
        }
    }
}
