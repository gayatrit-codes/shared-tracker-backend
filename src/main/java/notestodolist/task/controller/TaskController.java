package notestodolist.task.controller;
import notestodolist.task.entity.Taskentity;
import notestodolist.task.service.TaskService;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
public class TaskController {


    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Taskentity createTask(@RequestBody Taskentity task) {
        return service.createTask(task);
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