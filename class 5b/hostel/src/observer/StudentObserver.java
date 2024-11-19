package observer;

public class StudentObserver implements Observer {
    private String studentName;

    public StudentObserver(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + studentName + ": " + message);
    }
}
