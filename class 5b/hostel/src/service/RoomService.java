package service;

import domain.Student;

public class RoomService {
    public void assignRoom(Student student) {
        System.out.println("Assigning room to " + student.getName() + " (" + student.getRoomType() + " room).");
    }
}
