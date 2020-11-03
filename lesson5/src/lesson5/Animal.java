package lesson5;

public abstract class Animal {

    protected int maxRunDistance;
    protected float maxJumpDistance;
    protected int maxSwimDistance;
    protected String name;

    public Animal() {}

    public Animal(String name, int maxRunDistance, float maxJumpDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
    }

    public Animal(String name, int maxRunDistance, float maxJumpDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.maxSwimDistance = maxSwimDistance;

    }

    protected abstract void run(int distance);

    protected abstract void jump(float height);

    protected abstract void swim(int distance);

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public void setMaxJumpDistance(int maxJumpDistance) {
        this.maxJumpDistance = maxJumpDistance;
    }

    public void setMaxSwimDistance(int maxSwimDistance) {
        this.maxSwimDistance = maxSwimDistance;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public float getMaxJumpDistance() {
        return maxJumpDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
