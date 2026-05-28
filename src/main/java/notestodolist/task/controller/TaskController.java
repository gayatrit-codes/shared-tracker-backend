package notestodolist.task.controller;
import notestodolist.task.entity.Taskentity;
import notestodolist.task.service.TaskService;
import notestodolist.task.repository.TaskRepository;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TaskController {


    @GetMapping("/") 
    public String home() { 
        return "Shared Tracker Backend Running!"; 
    }

    private final TaskService service;
    private final TaskRepository taskRepository;
    
    public TaskController(TaskService service, TaskRepository taskRepository) {
        this.service = service;
        this.taskRepository = taskRepository;   
    }

    @PostMapping
    public Taskentity addTask(
        @RequestBody Taskentity task) {

    return taskRepository.save(task);
    }

    @RequestMapping("/tasks")
    @GetMapping
    public List<Taskentity> getTasks() {
        return service.getAllTasks();
    }
    
    @PutMapping("/{id}")
    public Taskentity updateTask(
        @PathVariable Long id,
        @RequestBody Taskentity updatedTask
    ){
        return service.updateTask(id, updatedTask);
    }

   
}