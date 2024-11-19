package pipefilter;

import domain.Student;

public class DistanceFilter implements Filter {
    private int threshold;

    public DistanceFilter(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean process(Student student) {
        return student.getDistanceFromHome() > threshold;  // Uses the new method from Student
    }
}
