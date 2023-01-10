import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

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


        for (Map<Task, LocalDate> item : taskList.values()) {
            for (Task key : item.keySet()) {
                switch (key.getRepeatable()) {
                    case "Ежедневная" -> System.out.println(key.getNameTask() + item.values().toString()+item.values().getClass());
                    case "Ежемесячная" -> {
                        if (item.get(key).getDayOfMonth()==date.getDayOfMonth()) {
                            System.out.println(key.getNameTask());
                        }
                    }
                    case "Ежегодная" -> {
                        if (item.get(key).getDayOfYear()==date.getDayOfYear()) {
                            System.out.println(key.getNameTask());
                        }
                    }
                    case "Однократная" -> {
                        if (item.values().contains(date)) {
                            System.out.println(key.getNameTask());
                        }
                    }
                    case "Еженедельная" -> {
                        if (item.get(key).getDayOfWeek()== date.getDayOfWeek()) {
                            System.out.println(key.getNameTask());
                        }
                    }
                }
            }
        }
    }



    @Override
    public String toString() {
        return "taskList: " + taskList;
    }
}
