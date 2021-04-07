package in.co.srdt.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.srdt.entity.Student;
import in.co.srdt.model.ResponseMessage;
import in.co.srdt.service.IStudentService;

@RestController
@RequestMapping("/api/student")
public class StudentResource {

	@Autowired
	private IStudentService studentService;

	@PostMapping("/saveStudent")
	public ResponseMessage saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PutMapping("/updateStudent/{id}")
	public ResponseMessage updateStudent(@RequestBody Student student,@PathVariable("id") Long id) {
		return studentService.updateStudent(student,id);
	}

	@DeleteMapping("/deleteStudentById/{id}")
	public ResponseMessage deleteStudentById(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}

}
