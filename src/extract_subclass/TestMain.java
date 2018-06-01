package extract_subclass;

public class TestMain {

    public static void main(String[] args) {
//        JobItem job1 = new JobItem(0, 5, true, new Employee("kent"));
        JobItem job1 = new LaborItem(0, 5, true, new Employee("kent"));
        JobItem job2 = new JobItem(10, 15);
    }
}
