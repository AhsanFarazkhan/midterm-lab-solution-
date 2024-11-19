package service;

import domain.Student;

public class ServiceSelection {
    public void selectServices(Student student, boolean food, boolean ironing, boolean washing) {
        // Print out the selected services
        System.out.println("Services selected: "
                + (food ? "Food " : "")
                + (ironing ? "Ironing " : "")
                + (washing ? "Washing " : ""));
        
        // Set servicesSelected to true after the user selects services
        student.setServicesSelected(true);
    }
}
