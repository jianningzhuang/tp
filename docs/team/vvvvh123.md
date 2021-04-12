# Vikas Harlani's Project Portfolio Page

## Project: ModMan

Short for Module Manager, ModMan is a desktop app designed to help teaching assistants manage their module(s). 
It is optimized for use via a Command Line Interface (CLI). 
ModMan helps to track module details as well as students’ progress and data, all in one platform. 
It can also perform autograding for MCQ assignments.

Given below are a summary of my contributions to the project

- **New Feature**: Added select working module functionality
    - What it does: By selecting a module to work in, all other commands would be executed on that module
    - Justification: Before adding the select module functionality, 
      the user would have to specify which module they would like to execute each command for. 
      This would lead to more tedious input of commands and higher tendency for errors. 
    
  
- **New Feature**: Added current module interface
    - What it does: When working in a particular module (using the select module functionality), 
    the user can easily obtain an overview of the module.
    - Justification: The current module interface provides an easy way for users to obtain an overview of information 
    relevant to that module. This is instead of having to input multiple commands to retrieve the same information,
      saving time and improving the user experience. 
  
    
- **Enhancement Implemented**: Reworked Parser class
    - What it is: Parser class is used to parse out the command and relevant parameters from user input
    - Enhancement: Reworked Parser class to use string slicing by index and the substring method. 
      This is instead of splitting the sentence into words, using space as the delimiter, as it was harder to parse out
      parameters with multiple words. 
      

- **Code contributed**: [*RepoSense* Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=vvvvh123)

<div style="page-break-after: always;"></div>

- **Project management**:
    - Managed releases v1.0 - v2.1 (3 releases) on GitHub
    - Created and assigned issues to relevant members on the team to ensure we meet deadlines
    - Reviewed team members pull requests, and on occasion, 
      helped them fix failing continuous integration issues before merging
        - [Fixing failing CI](https://github.com/AY2021S2-CS2113T-F08-1/tp/pull/61)


- **Documentation**:
    - User Guide:
        - Added documentation for adding and listing students features: #88
        - Added documentation for removing module feature: #105
        - Added documentation for select module functionality: #105
        - Added documentation for current module interface: #105
        - Formatted the ordering of features and table of contents: #274
    - Developer Guide:
        - Added Introduction, Setting Up and Product Scope sections: #263
        - Added overall architecture details of ModMan, including an architecture diagram: #263
        - Added sequence diagram detailing the interactions between components when user inputs a command: #113
        - Added class diagram detailing structure of Assignments and relevant classes in ModMan: #214
    - Javadoc:
        - Added Javadoc for UI and Parser classes: #281
        - Added Javadoc for various commands: #281
    

- **Community**:
    - PRs reviewed (with non-trivial review comments): #123
      - [Review PRs](https://github.com/AY2021S2-CS2113T-F08-1/tp/pull/123)
