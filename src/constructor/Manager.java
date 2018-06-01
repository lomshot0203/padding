package constructor;

public class Manager extends Employee {

    private int _grade;

    public Manager (String name, String id, int grade) {
        super(name, id);
        _grade = grade;
        if (isPrivillaged()) {
            assignCar();
        }

    }

    void assignCar () {
        System.out.println("Manager assignCar");
    }
}
