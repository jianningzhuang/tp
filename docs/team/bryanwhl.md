# Bryan Wong's Project Portfolio Page

### Project: ModMan
Short for Module Manager, ModMan is a desktop app designed to help teaching assistants manage their module(s). It is optimized for use via a Command Line Interface (CLI). ModMan helps to track module details as well as students’ progress and data, all in one platform. It can also perform autograding for MCQ assignments.

Given below are my contributions to the project.

- New Feature: Added the ability to save the user's data for his/her next use upon exiting the application.
    - What it does: Automatically saves the user's data upon exiting of the application.
    - Justification: This feature improves the product significantly because a user can save his/her data from the particular session and will not have to input his/her past data again the next time he/she uses the app.

- New Feature: Added the ability to keep track of assignments within the app.
    - Justification: TAs often need to be the ones grading and handling assignment submissions. Adding support for tracking assignments will enhance the application drastically.
    
- New Feature: Added the ability to keep track of assignment comments and student grades for the assignment within the app.
    - Justification: TAs could use these features to keep track of assignment statistics and make notes for themselves for future use.

- Code contributed: https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=bryanwhl

- Project management:
    - Managed releases v1.0 - v2.1 (3 releases) on GitHub
    - Resolved Continuous Integration issues that occurred at the start of the project
    - Organized weekly team meetings with the group
    - Discussed and lead the planning for various technical aspects of the application such as overall program architecture, database features and defensive programming. 
- Enhancements to existing features:
    - Added Exceptions and JUnit tests for bug-prone features like adding deadlines to assignments. #222
    - Added restrictions for date to be set between the recent 10 years to prevent typos on the year from getting registered as a valid date. #222
    - Added functionality for additional spaces between parameters to not affect the program from capturing the parameter input. This makes the program smarter and smoother for use. #244
    
- Documentation:
    - User Guide:
        - Added documentation for listing assignment feature #89
        - Added documentation for adding assignment feature #218
        - Added documentation for setting assignment percentage feature #218
        - Added documentation for adding assignment percentage feature #256
        - Added documentation for setting assignment comments feature #256
        - Added documentation for getting assignment comments feature #256
        - Added documentation for setting assignment deadline feature #256
        
    - Developer Guide:
        - Added implementation details of the Storage feature: #115
        - Added UML Diagrams for different features in Storage: #235 & #251
- Community:
    - PRs reviewed (with non-trivial review comments): #122