import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private Task task;
    private LocalDate date;
    private static Integer id = 0;
    Map<Integer, Map<Task, LocalDate>> taskList = new LinkedHashMap<>();
    Scanner scanner = new Scanner(System.in);


    public Task addTaskInTaskList(Task task) {
        Map<Task, LocalDate> taskMap = taskList.getOrDefault(task, new LinkedHashMap<>());
        taskMap.put(task, setDate());
        id++;
        taskList.put(id, taskMap);
        return task;
    }

    public LocalDate setDate() {
        System.out.println("Введите дату в формате: yyyy-mm-dd");
        LocalDate date1 = LocalDate.parse(scanner.nextLine());
        return date1;
    }


    public void getTask() {
        for (Map.Entry<Integer, Map<Task, LocalDate>> entry : taskList.entrySet()) {
            System.out.println(entry);
        }
    }

    public void getTaskById(Integer id) {
        for (Map.Entry<Integer, Map<Task, LocalDate>> entry : taskList.entrySet()) {
            if (entry.getKey() == id) {
                System.out.println(entry);
            }
        }
    }
    public void getTaskByDate(LocalDate date) {
        for (Map<Task, LocalDate> value : taskList.values()) {
            if (value.containsValue(date)) {
                System.out.println(value);
            }
        }
    }

    @Override
    public String toString() {
        return  "taskList: " + taskList;
    }
}
