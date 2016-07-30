This file is intended to help users to execute the security-module-client-1.0.jar for generating hash(es), 
which can be further used to test the REST service created using a similar secret key.

Pre-requisites: 
Java 1.7 or higher
Windows OS
maven

Steps to run the executable jar:

1. Initially clone the url https://github.com/ashinrobi/security-module-client.git to any Windows directory of your choice
2. Using maven build the project.
3. Using command line, change directory to <git_directory>/security-module-client/target
4. Now execute the command, java -jar security-module-client-1.0.jar
5. The following details would show up on screen, prompting for user inputs(name, to begin with).


##############################################
##############################################
##                                          ##
##    HMACSHA256 Hash/Signature generator   ##
##                                          ##
##############################################
##############################################

 Kindly enter details as prompted 

     Enter your name : Ashin Wilson
Enter your e-mail id : ashin.robi@gmail.com
  Enter your country : INDIA

The hash/signature for your data entered is : 
ohlIxBJTdE9mXPoSZ5Lq15T74EngJ3hAGZe+Hv14sEQ=