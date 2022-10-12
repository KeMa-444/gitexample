1. ssss

2. ssss

3. **What is the basic steps to init a git repo in you local ?**

  - Create a new directory and go into this directory
  - Use ```git init ``` to initialize a empty repository
  - Create your project files
  - Use ```git add .``` to add all files, or ```git add <file_name>``` to add a specific file
  - Use ```git commit``` to record changes to the repository

4. **How to clone a repo from GitHub ?**

  - At the GitHub repository page, copy its URL
  - Type ```git clone``` and paste that URL   

5. **How to create a new branch and checkout to that branch ?**

  - ```
    git branch <branch_name> 
    git checkout <branch_name>
    ```

  - Or ```git checkout -b <branch_name>```

6. **How to merge the branch_test to master branch in command ? **

   ```
   git checkout master
   git merge branch_test
   ```

7. **How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? **

   ```
   git stash
   git stash pop
   ```

8. **How do you understand PR is based on Branch?**

​		Pull Request shows the changes you've pushed to a branch. It shows the changes between 		the compare branch and the base branch. 

9. **What is maven role ? what it be used to do ?**

​		Maven is a tool that used for building and managing Java-based project. Maven's roles    		include manage dependencies, build project, documentation and reporting.

10. **What is the lifecycle of maven? could you tell me the details ?**
