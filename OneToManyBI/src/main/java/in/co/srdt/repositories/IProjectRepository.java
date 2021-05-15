package in.co.srdt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.srdt.entities.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long>{

}
