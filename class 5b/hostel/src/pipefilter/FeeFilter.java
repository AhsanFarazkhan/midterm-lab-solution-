package pipefilter;

import domain.Student;

public class FeeFilter implements Filter {

    @Override
    public boolean process(Student student) {
        return student.isFeePaid();
    }
}
