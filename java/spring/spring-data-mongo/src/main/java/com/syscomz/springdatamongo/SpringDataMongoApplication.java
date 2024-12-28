package com.syscomz.springdatamongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataMongoApplication {

	public static final String EMAIL = "b.dostumski@gmail.com";

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(StudentRepository repository,
//							 MongoTemplate template) {
//		return args -> {
//			Address address = new Address("Bulgaria", "Sofia", "1000");
//			Student student = new Student(
//					"Borislav",
//					"Dostumski",
//					EMAIL,
//					Gender.MALE,
//					address,
//					List.of(
//							"computer science",
//							"maths",
//							"physics",
//							"chemistry",
//							"biology"
//					),
//					BigDecimal.TEN,
//					LocalDateTime.now()
//			);
//
////			usingMongoTemplateAndQuery(repository, template, student);
//
//			repository.findStudentByEmail(student.getEmail())
//					.ifPresentOrElse(studentEntity -> {
//						System.out.println(studentEntity + " already exists");
//					}, () -> {
//						System.out.println("Inserting student " + student);
//						repository.insert(student);
//					});
//		};
//	}

//	private static void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate template, Student student) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("email").is(EMAIL));
//		List<Student> students = template.find(query, Student.class);
//
//		if(students.size() > 1)
//			throw new IllegalStateException("Found many students with email " + EMAIL);
//
//		if(students.isEmpty()) {
//			System.out.println("Inserting student " + student);
//			repository.insert(student);
//		} else {
//			System.out.println(student + " already exists");
//		}
//	}
}
