package constructor;

public class Employee {
    protected String _name;
    protected String _id;

    protected Employee(String name, String id) {
        _name = name;
        _id = id;
    }

    boolean isPrivillaged () {
        return true;
    }

    void assignCar () {
        System.out.println("Employee assignCar");
    }
}
