package in.co.srdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.srdt.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{

}
