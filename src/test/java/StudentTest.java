import base.BaseTest;
import com.hellen.domain.Student;
import com.hellen.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by DS on 2018/1/6.
 */
@Slf4j
public class StudentTest extends BaseTest{

    @Autowired
    private IStudentService studentService;

    @Test
    public void testinsert() throws Exception {
        Student student = new Student();
        student.setName("hellen");
        student.setAge(11);
        Integer integer = studentService.insertOne(student);
        log.info(integer+"");
    }
}
