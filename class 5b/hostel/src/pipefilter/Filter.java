package pipefilter;

import domain.Student;

public interface Filter {
    boolean process(Student student);
}
