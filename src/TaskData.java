import java.util.HashSet;
import java.util.Set;

class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;

    public TaskData() {
        annsTasks = new HashSet<>();
        bobsTasks = new HashSet<>();
        carolsTasks = new HashSet<>();

        annsTasks.add(new Task("Project1", "Task1", "Ann", Priority.HIGH, Status.IN_PROGRESS));
        bobsTasks.add(new Task("Project2", "Task2", "Bob", Priority.MEDIUM, Status.ASSIGNED));
        carolsTasks.add(new Task("Project3", "Task3", "Carol", Priority.LOW, Status.IN_QUEUE));
    }


    public Set<Task> getTasks(String employee) {
        switch (employee.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                return allTasks;
            default:
                throw new IllegalArgumentException("Invalid employee name");
        }
    }


    public Set<Task> getAllEmployeesTasks() {
        return getUnion(annsTasks, bobsTasks, carolsTasks);
    }


    public Set<Task> getIndividualEmployeeTasks(String employee) {
        return getTasks(employee);
    }


    public Set<Task> getUnassignedTasks() {
        Set<Task> allTasks = getAllEmployeesTasks();
        Set<Task> assignedTasks = getUnion(annsTasks, bobsTasks, carolsTasks);
        return getDifference(allTasks, assignedTasks);
    }


    public Set<Task> getTasksAssignedToMultipleEmployees() {
        Set<Task> intersectionAB = getIntersect(annsTasks, bobsTasks);
        Set<Task> intersectionAC = getIntersect(annsTasks, carolsTasks);
        Set<Task> intersectionBC = getIntersect(bobsTasks, carolsTasks);
        return getUnion(intersectionAB, intersectionAC, intersectionBC);
    }


    private Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> result = new HashSet<>();
        for (Set<Task> set : sets) {
            result.addAll(set);
        }
        return result;
    }

    private Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    private Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    @Override
    public String toString() {
        return "TaskData{" +
                "annsTasks=" + annsTasks +
                ", bobsTasks=" + bobsTasks +
                ", carolsTasks=" + carolsTasks +
                '}';
    }
}