package pipefilter;

import domain.Student;
import java.util.ArrayList;
import java.util.List;

public class Pipe {
    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public boolean process(Student student) {
        for (Filter filter : filters) {
            if (!filter.process(student)) {
                return false;
            }
        }
        return true;
    }
}
