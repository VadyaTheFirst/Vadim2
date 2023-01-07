import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    TaskService taskService = new TaskService();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        start:
        while (true) {
            System.out.println("Введите команду");
            System.out.println("1 - создать задачу");
            System.out.println("2 - вывести список всех задач");
            System.out.println("3 - найти задачу по id");
            System.out.println("4 - вывести список задач на определенную дату");
            System.out.println("0 - выйти");
            if (scanner.hasNextInt()) {
                switch (scanner.nextLine()) {
                    case "1" -> addTask();
                    case "2" -> getTasks();
                    case "3" -> getTaskById();
                    case "4" -> getTaskByDate();
                    case "0" -> {
                        break start;
                    }
                }
            }
        }
    }

    public void addTask() {
        Repeatable repeatable = setRepeatable();
        CategoryTask category = setCategoryTask();
        Task task = switch (repeatable) {
            case ONCE ->
                    new OnceTask(
                            category,
                            setNameTask(),
                            setDescription(),
                            repeatable);
            case DAILY ->
                    new DailyTask(
                            category,
                            setNameTask(),
                            setDescription(),
                            repeatable);
            case WEEKLY ->
                    new WeeklyTask(
                            category,
                            setNameTask(),
                            setDescription(),
                            repeatable);
            case MONTHLY ->
                    new MonthlyTask(
                            category,
                            setNameTask(),
                            setDescription(),
                            repeatable);
            case YEARLY ->
                    new YearlyTask(
                            category,
                            setNameTask(),
                            setDescription(),
                            repeatable);
        };
        this.taskService.addTaskInTaskList(task);

    }

    public void getTasks() {
        this.taskService.getTask();
    }

    public void getTaskById() {
        System.out.println("Введите id:");
        this.taskService.getTaskById(scanner.nextInt());
    }

    public void getTaskByDate() {
        System.out.println("Введите дату в формате: yyyy-MM-dd");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        this.taskService.getTaskByDate(date);
    }

    public String setDescription() {
        System.out.println("Введите описание задачи");
        String description = scanner.nextLine();
        return description;
    }

    public String setNameTask() {
        System.out.println("Введите заголовок задачи");
        String name = scanner.nextLine();
        return name;
    }

    public CategoryTask setCategoryTask() {
        System.out.println("Введите категорию задачи");
        System.out.println("1 - личная");
        System.out.println("2 - рабочая");
        String category = scanner.nextLine();
        if (scanner.nextLine().equals("1")) {
            return CategoryTask.PERSONAL;
        } else return CategoryTask.WORK;
    }
    public Repeatable setRepeatable() {
        System.out.println("Введите повторяемость задачи");
        System.out.println("1 - однократная");
        System.out.println("2 - ежедневная");
        System.out.println("3 - еженедельная");
        System.out.println("4 - ежемесячная");
        System.out.println("5 - ежегодная");
        Integer num = scanner.nextInt();
        if (num == 1) {
            return Repeatable.ONCE;
        } else if (num == 2) {
            return Repeatable.DAILY;
        } else if (num == 3) {
            return Repeatable.WEEKLY;
        } else if (num == 4) {
            return Repeatable.MONTHLY;
        } else if (num == 5) {
            return Repeatable.YEARLY;
        } else return null;
    }


}