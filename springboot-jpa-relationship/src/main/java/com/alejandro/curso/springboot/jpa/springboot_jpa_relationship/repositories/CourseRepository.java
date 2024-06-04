package com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
