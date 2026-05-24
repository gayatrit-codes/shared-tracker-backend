package notestodolist.task.repository;
import notestodolist.task.entity.Taskentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Taskentity, Long> {

}