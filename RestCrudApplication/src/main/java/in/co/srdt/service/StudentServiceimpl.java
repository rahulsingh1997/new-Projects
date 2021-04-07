package in.co.srdt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.srdt.entity.Student;
import in.co.srdt.model.ResponseMessage;
import in.co.srdt.repository.IStudentRepository;

@Service
public class StudentServiceimpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public ResponseMessage saveStudent(Student student) {
		studentRepository.save(student);
		return new ResponseMessage("Student Saved");
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public ResponseMessage updateStudent(Student student,Long id) {
		String message = "";
		Optional<Student> data=studentRepository.findById(id);
		if (data.isPresent()) {
//			Student entity=new Student();
//			entity.setId(id);
//			entity.setName(student.getName());
//			entity.setStandard(student.getStandard());
            student.setId(id);
			
			studentRepository.save(student);
			message = "Student Updated";
		} else {
			message = "Student Id not Found";
		}
		return new ResponseMessage(message);
	}

	@Override
	public ResponseMessage deleteStudent(Long id) {
		String message = "";
		if (studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			message = "Student Deleted";
		} else {
			message = "Student id is not found";
		}

		return new ResponseMessage(message);
	}

}
