package com.syscomz.springdatamongo.persistence;

import com.syscomz.springdatamongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
