# Airelogic
BugTrackerApplication
======================================================================================
Bug Tracker Application (Note:This is only a backend code of the BugTrackerApplication)

The Bug Tracker Application is used to track bugs. The application has been developed using the springboot framework with MongoDB as the database. Springboot was chosen because it is a robust framework which can be set up pretty easily and quickly and it can be run as a standalone application without thinking too much about the container setup. Sprinboot comes with inbuilt tomcat setup so there is no need to worry about the setup of the server.

For the kind of data required for the BugTracker Application MongoDB is quite appropriate as a database. MongoDB is a no SQL databse with no fixed schema. MongoDB is a document database. So there is no need to design tables upfront and establish relationships. The developer has to just design a class and mongoDB will create the corresponding collection out of the box
==================================================================================
Softwares Used: 
Java: java version "10.0.1"
Spring Version: Spring CLI v2.0.3.RELEASE
IDE : Spring Tool Suite : Version: 3.9.5.RELEASE
Build Tool : Maven

================================================================================== 
Prerequisites:

The user has to make sure MongoDB is installed and running on their system.The setup for the MongoDB is very easy. For windows users the user has to download the jars and install Mongodb. For Mac users the setup is the easiest. I will explain the mac setup. Windows users can refer to the setup online. Only prerequsite for MongDB is the user has to create a /data/db folder for storing the data.

For installing on mac just issue the following command.

brew install mongodb

Once installed run the following command to start the server

mongod

That will start the mongo server on port 27017. This can be changed in application.properties file of the springboot application.

===================================================================================== Below are the listed features of functionality provided.

The default port is assumed 8080 this can be changed by the server.port property in application.properties file.

One can view a list of URLS to access the various CRUD operations in sprinboot. The URLs are self explanatory:

Data is stored in collections in MongoDB in document format.Following are the collections and URL's for CRUD operations.

User:

http://localhost:8080/getusers -> Lists all users

http://localhost:8080/getuserbyusername/{userName} -> Lists a username. Username here is unique and can be email id. In this application the username has not been set to unique due to time constraint. One can create a unique or sparse index on emailid field to make it unique. This can be implemented when there is sufficient time.

http://localhost:8080/updateuser -> Update user details.

http://localhost:8080/deleteuser/{userName} -> Delete user with a specific user name

http://localhost:8080/deleteallusers

Bug:

http://localhost:8080/getbugs -> list of all bugs including their titles http://localhost:8080/addbug -> To add a bug http://localhost:8080/getbugbyuserid/{userId -> Retrieve bug for a specific user id http://localhost:8080/getbugbystatusopen -> This can be implemented better to query for any status by making use of the Optional feature introduced in Java 8. Also streams and lambdas features can be used for this sort of functionality. http://localhost:8080/updatebugbyuserid http://localhost:8080/deletebugbyuserid/{userId} http://localhost:8080deleteallbugs

Comments:

http://localhost:8080/addcomment http://localhost:8080/getallcomments http://localhost:8080/getcommentbyusername/{userName} http://localhost:8080/getcommentbybugid/{bugId} http://localhost:8080/updatecommentbyusername http://localhost:8080/updatecommentbybugid http://localhost:8080/deletecommentbybugid/{userName} http://localhost:8080/deleteallcomments

History:

http://localhost:8080/addhistory http://localhost:8080/getallhistory http://localhost:8080/gethistorybyuserid/{userId} http://localhost:8080/gethistorybybugid/{bugId} http://localhost:8080/updatehistorybybugid http://localhost:8080/updatehistorybyuserid http://localhost:8080/deletehistorybybugid/{bugId} http://localhost:8080/deletehistorybyuserid/{userId} http://localhost:8080/deleteallhistory

The signup and login functionality has to be developed as well for this application which will enable the user to signup or login to the application. Once a user is logged in he can have the authority to assign/reassign bugs , update comments, etc. SO Spring boot provides features of Authorisation & Auhtentication. This has not been developed but can be developed using a few framweorks. The simplest is by using MongoTemplate. There are many Spring security features which can be implemented for better security. One is implementing OAuth.

Unit Testing could not be completed in the limited timeframe but can be done using the Springboot test capabilities.
Just setup a test class and wrote a test but not fully working. 

© 2018 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
API
Training
Shop
Blog
About
Press h to open a hovercard with more details.
