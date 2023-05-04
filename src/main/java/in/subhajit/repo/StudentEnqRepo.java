package in.subhajit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.subhajit.entity.StudentEnqEntity;

public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity, Integer> {

}
