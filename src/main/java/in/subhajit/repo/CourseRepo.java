package in.subhajit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.subhajit.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

}
