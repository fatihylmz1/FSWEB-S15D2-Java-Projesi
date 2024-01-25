public class Main {
    public static void main(String[] args) {

        TaskData taskData = new TaskData();

        System.out.println("Tüm çalışanların üzerindeki tasklar: " + taskData.getAllEmployeesTasks());
        System.out.println("Ann'ın üzerindeki tasklar: " + taskData.getIndividualEmployeeTasks("ann"));
        System.out.println("Bob'un üzerindeki tasklar: " + taskData.getIndividualEmployeeTasks("bob"));
        System.out.println("Carol'un üzerindeki tasklar: " + taskData.getIndividualEmployeeTasks("carol"));
        System.out.println("Herhangi bir çalışana atanmamış olan tasklar: " + taskData.getUnassignedTasks());
        System.out.println("Birden fazla çalışana atanmış tasklar: " + taskData.getTasksAssignedToMultipleEmployees());


    }
}