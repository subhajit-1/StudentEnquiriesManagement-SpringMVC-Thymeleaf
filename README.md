# AIT Student Inquiries App - 2nd Mini Project

## Overview

This repository contains the source code for the Student Inquiries App. The application is designed to serve as a Front Office Team Portal for managing student inquiries. It includes features such as user registration, account unlocking, login functionality, a dashboard for performance reporting, and the ability to add, view, and filter inquiries.

## Project Structure

The project is structured as follows:

- **src/main/java:** Contains the Java source code.
  - **controller:** Controllers handling HTTP requests.
  - **entity:** Entity classes representing database tables.
  - **exception:** Custom exception handling.
  - **repository:** Repository interfaces for database interactions.
  - **rest:** REST controllers for AJAX functionality.
  - **service:** Service interfaces and implementations.
  - **util:** Utility classes for password and email handling.
- **src/main/resources:** Contains application configuration files and static resources.
  - **static:** Static resources such as CSS and JavaScript files.
  - **templates:** Thymeleaf HTML templates.
  - **application.properties:** Configuration file for datasource and SMTP properties.
- **src/test:** Contains test classes.
- **pom.xml:** Maven project configuration file.

## Technology Stack

- **Backend:** Java + Spring Boot + Data JPA + Web MVC
- **Database:** MySQL
- **Frontend:** HTML + CSS + JQuery + Bootstrap + Ajax + Thymeleaf

## Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/subhajit-1/AIT-StudentEnqiries-App_2nd_mini_Project.git
   ```

2. Open the project in your preferred IDE.

3. Configure the datasource and SMTP properties in the `application.properties` file.

4. Run the application.

## Database Tables

1. **AIT_USER_DTLS:**
   - User details with user ID, name, email, phone number, password, and account status.

2. **AIT_STUDENT_ENQUIRIES:**
   - Student inquiry details with inquiry ID, student name, phone number, class mode, course name, inquiry status, created date, updated date, and user ID.

3. **AIT_COURSES:**
   - Course details with course ID and course name.

4. **AIT_ENQUIRY_STATUS:**
   - Inquiry status with status ID and status name.

## Functionalities

- **Home Page:**
  - Display logo with navigation bar.
  - Carousel for sliding banners.
  - Course images display.
  - Login button.

- **Sign Up:**
  - Unique email validation.
  - Temporary password generation.
  - Registration email sent with a temporary password and unlock link.

- **Unlock Account:**
  - Temporary password validation.
  - Set a new password.
  - Account unlocking.

- **Login:**
  - Only unlocked account users can log in.
  - Invalid credentials check.
  - Account status check.
  - Display dashboard with the logged-in user's performance report on successful login.

- **Forgot Password:**
  - Invalid email: No account found with the given email.
  - Valid email: Retrieve the password from the database and send it to the user's email.

- **Dashboard:**
  - Display the logged-in user's performance report.

- **Add Inquiry:**
  - Add a new inquiry with the status set as 'New.'

- **View Inquiries:**
  - Display inquiries added by the logged-in user.
  - Edit the inquiry to update the status.
  - Filter inquiries based on given criteria asynchronously.

- **Logout:**
  - Display the home page upon logout.

## AJAX Integration

AJAX is used for asynchronous requests to enhance the user experience. The project includes examples of AJAX integration for dynamic content updates without full page reloads.

## Download Resources

[Project Resources](https://www.mediafire.com/file/vswc2h4nswu3ncn/02_mini_project_resources.zip/file)

## Contribution

Contributions are welcome! Feel free to open issues, submit pull requests, or provide suggestions for improvement.
## Authors
 SUBHAJIT DAS 
## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
