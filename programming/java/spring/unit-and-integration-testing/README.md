# Unit and Integration software testing

Software testing:
- Unit testing [StudentRepository, StudentService] by using Junit5 and AssertJ
- Integration testing [StudentController] by using Mockito


<a href="https://junit.org/junit5/docs/current/user-guide/" target="_blank">JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage</a>
- The JUnit Platform serves as a foundation for launching testing frameworks on the JVM.
- JUnit Jupiter is the combination of the new programming model and extension model for writing tests and extensions in JUnit 5.
- JUnit Vintage provides a TestEngine for running JUnit 3 and JUnit 4 based tests on the platform.

<a href="https://assertj.github.io/doc/" target="_blank">AssertJ</a> is a Java library that provides a rich set of assertions and truly helpful error messages, improves test code readability.

<a href="https://site.mockito.org/" target="_blank">Mockito</a> is a mocking framework that tastes perfect. It lets you write beautiful tests with a clean & simple API. Mockito doesn't give you hangover because the tests are very readable, and they produce clean verification errors.

<a href="https://www.h2database.com/html/main.html" target="_blank">H2</a> is an in-memory database that is used from StudentRepositoryTest to test our custom method, all JPA methods are already tested, and we don't need to test them.

<a href="https://www.postgresql.org/" target="_blank">PostgreSQL</a> is a powerful, open source object-relational database. This project uses two databases one dev for development and one test for testing purposes.

