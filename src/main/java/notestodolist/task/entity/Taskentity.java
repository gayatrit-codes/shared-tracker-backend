package notestodolist.task.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Taskentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private boolean needsReminder;
    public Taskentity() {    
    } 
    public Taskentity(Long id, String title, String description, boolean completed, boolean needsReminder) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.needsReminder =  needsReminder;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public boolean isCompleted() {
        return completed;
    }

    public boolean isNeedsReminder(){
        return needsReminder;
    }

     public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void setNeedsReminder(boolean needsReminder){
        this.needsReminder = needsReminder;
    }
}
