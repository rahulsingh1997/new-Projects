package in.co.srdt.service;

import java.util.List;

import in.co.srdt.entity.Student;
import in.co.srdt.model.ResponseMessage;

public interface IStudentService {

	public ResponseMessage saveStudent(Student student);

	public List<Student> getAllStudents();

	public ResponseMessage updateStudent(Student student,Long id);

	public ResponseMessage deleteStudent(Long id);
}
