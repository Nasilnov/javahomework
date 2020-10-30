package lesson4;

public class Worker {
    private int id;
    private String name;
    private String position;
    private long phone;
    private int salary;
    private short age;

    public Worker(String name, String position, long phone, int salary, short age ) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        setId();
    }

    private void setId(){


    }


    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public long getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public short getAge() {
        return age;
    }

    public void addSarary(int add) {
        this.salary = this.salary + add;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void printAllDate() {
        System.out.println(this.id + " " + this.getName() + " " + this.position + " " +
                this.age + " " + this.salary);
    }

}
