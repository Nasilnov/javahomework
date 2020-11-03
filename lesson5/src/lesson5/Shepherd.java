package lesson5;

public class Shepherd extends Dog {

    static final String breed = "Овчарка";

    public Shepherd() {
        super.maxRunDistance = 800;
        super.maxJumpDistance = 1.5f;
        super.maxSwimDistance = 50;
    }

    public Shepherd(String name, int maxRunDistance, float maxJumpDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxJumpDistance, maxSwimDistance);
    }

    @Override
    public void run(int distance) {
        System.out.print(breed + ": ");
        super.run(distance);
    }

    @Override
    public void jump(float height) {
        System.out.print(breed + ": ");
        super.jump(height);
    }

    @Override
    public void swim(int distance) {
        System.out.print(breed + ": ");
        super.swim(distance);
    }
}
