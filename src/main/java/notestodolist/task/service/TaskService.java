package notestodolist.task.service;
import notestodolist.task.entity.Taskentity;
import notestodolist.task.repository.TaskRepository;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Taskentity createTask(Taskentity task) {
        return repository.save(task);
    }

    public List<Taskentity> getAllTasks() {
        return repository.findAll();
    }

    public Taskentity updateTask(Long id, Taskentity updatedTask){
        Taskentity task = repository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        task.setNeedsReminder(updatedTask.isNeedsReminder());
        return repository.save(task);

    }
}