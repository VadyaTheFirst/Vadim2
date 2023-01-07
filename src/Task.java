import java.util.Objects;

public abstract class Task {
    private CategoryTask categoryTask;
    private String nameTask;
    private String descriptionTask;
    private Repeatable repeatable;
    public Task(CategoryTask categoryTask, String nameTask, String descriptionTask, Repeatable repeatable) {
        if (categoryTask != null) {
            this.categoryTask = categoryTask;
        } else {
            throw new RuntimeException("Введите категорию задачи: личная ил рабочая");
        }
        if (nameTask != null && !nameTask.isEmpty() && !nameTask.isBlank()) {
            this.nameTask = nameTask;
        } else {
            throw new RuntimeException("Введите название задачи");
        }
        if (descriptionTask != null && !descriptionTask.isEmpty() && !descriptionTask.isBlank()) {
            this.descriptionTask = descriptionTask;
        } else {
            throw new RuntimeException("Введите описание задачи");
        }
        if (repeatable != null) {
            this.repeatable = repeatable;
        } else {
            throw new RuntimeException("Введите период повторяемости задачи");
        }
    }

    public CategoryTask getCategoryTask() {
        return categoryTask;
    }

    public void setCategoryTask(CategoryTask categoryTask) {
        if (categoryTask != null) {
            this.categoryTask = categoryTask;
        } else {
            throw new RuntimeException("Введите категорию задачи: личная ил рабочая");
        }
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        if (nameTask != null && !nameTask.isEmpty() && !nameTask.isBlank()) {
            this.nameTask = nameTask;
        } else {
            throw new RuntimeException("Введите название задачи");
        }
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        if (descriptionTask != null && !descriptionTask.isEmpty() && !descriptionTask.isBlank()) {
            this.descriptionTask = descriptionTask;
        } else {
            throw new RuntimeException("Введите описание задачи");
        }
    }

    public String getRepeatable() {
        String repeat = null;
        if (repeatable == Repeatable.ONCE) {
            repeat = "Однократная";
        }
        if (repeatable == Repeatable.DAILY) {
            repeat = "Ежедневная";
        }
        if (repeatable == Repeatable.WEEKLY) {
            repeat = "Еженедельная";
        }
        if (repeatable == Repeatable.MONTHLY) {
            repeat = "Ежемесячная";
        }
        if (repeatable == Repeatable.YEARLY) {
            repeat = "Ежегодная";
        }
        return repeat;
    }
    public String getCategory() {
        String category = null;
        if (categoryTask == CategoryTask.WORK) {
            category = "Рабочая";
        }
        if (categoryTask == CategoryTask.PERSONAL) {
            category = "Личная";
        }
        return category;
    }

    public void setRepeatable(Repeatable repeatable) {
        if (repeatable != null) {
            this.repeatable = repeatable;
        } else {
            throw new RuntimeException("Введите период повторяемости задачи");
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return categoryTask == task.categoryTask && Objects.equals(nameTask, task.nameTask) && Objects.equals(descriptionTask, task.descriptionTask) && repeatable == task.repeatable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryTask, nameTask, descriptionTask, repeatable);
    }

    @Override
    public String toString() {
        return "Категория задачи: " + getCategory() +
                ", Название задачи: " + nameTask +
                ", Описание задачи: " + descriptionTask +
                ", Повторяемость задачи: " + getRepeatable();
    }
}

