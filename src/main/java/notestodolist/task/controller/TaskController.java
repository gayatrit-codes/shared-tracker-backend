package notestodolist.task.controller;
import notestodolist.task.entity.Taskentity;
import notestodolist.task.service.TaskService;
import notestodolist.task.repository.TaskRepository;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/tasks") 

public class TaskController {

    private final TaskService service;
    private final TaskRepository taskRepository;

    public TaskController(TaskService service, TaskRepository taskRepository) {
        this.service = service;
        this.taskRepository = taskRepository;   
    }
   
    @PostMapping
    public Taskentity addTask(
        @RequestBody Taskentity task) {
                System.out.println(task.getId());

    return taskRepository.save(task);
    }

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