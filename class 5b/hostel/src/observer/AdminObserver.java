package observer;

public class AdminObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Admin notified: " + message);
    }
}
