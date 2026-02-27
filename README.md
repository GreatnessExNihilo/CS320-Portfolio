# CS320-Portfolio
## Module 8 Journal

### CS 320 – Software Testing Portfolio Reflection

#### How can I ensure that my code, program, or software is functional and secure?

I ensure functionality and security by using a requirements-driven testing approach. For each functional requirement, I create corresponding unit tests that verify both expected behavior (positive tests) and invalid inputs or edge cases (negative and boundary tests). Using JUnit 5, I validated constraints such as unique IDs, field length limits, and null prevention to ensure data integrity. Security is reinforced by rejecting invalid or malicious inputs early, preventing improper state changes, and limiting direct access to object fields through encapsulation. Consistent testing, input validation, and controlled updates help reduce defects and vulnerabilities before deployment.

#### How do I interpret user needs and incorporate them into a program?

I begin by translating user requirements into clearly defined functional constraints. Each requirement becomes a measurable rule within the codebase. For example, if a user needs uniquely identifiable contacts, I implement ID validation and duplicate checks within the service layer. I then design test cases that directly align with those needs to verify that the implementation satisfies the original requirement. By mapping requirements to both code and test cases, I ensure traceability and alignment between what the user expects and what the system delivers.

#### How do I approach designing software?

I approach software design by starting with clear requirements, then breaking the system into modular components with defined responsibilities. In Project One, I separated object classes (Contact, Task, Appointment) from their service classes to maintain single responsibility and clean architecture. I focus on encapsulation, validation within constructors, and controlled update methods to maintain object integrity. I also design with testability in mind, ensuring that each method can be independently verified through unit testing. This structured, modular approach improves maintainability, scalability, and overall software quality.
