# University-Student-Assistant
A Web-Application written in Spring-Boot

The application has the following Classses and Functionalities 


TimeTable 

Short Description :

This class would be implemented using the Singleton Creational Design pattern. It will hold an array list of Cell and one cell would consist, of course, its time and the instructor. 
Methods:

Create Optimal TimeTable
This function takes an input list of User courses and finds the most optimal timetable using a stored algorithm
Help in TimeTable
This allows the user to select his own preferred courses at gives suggestions and warnings 
Evaluate TimeTable 
This takes as input from the User a TimeTable and outputs its score based on our matric
Update TimeTable
This takes input from Information class about the updated information regarding TimeTable


Review
Short Description:
This is the abstract parent class for all review classes. Holds review information and defines basic review methods.
Methods:
Add review
Takes review text, reviewer and reviewee information as a parameter and stores it in the database
Delete review
Takes review id (fetched by search function) and deletes it from the database if the user it authorized to do so
Search review
Searches review database over some input parameter and returns a list of matching reviews
Edit review
Takes review ID and review details and updates the review in the database


TeacherReview
Short description: 
This class extends review class and implements review functions specific to teacher reviews
Methods:
Implements the methods in the aforementioned review class


PlaceReview
Short description: 
This class extends review class and implements review functions specific to place (classrooms) reviews
Methods:
	Implements the methods in the aforementioned review class

Place
Short description:
This class holds information about a physical place such as a garden or cafeteria. It is further extended to classRoom class
Methods:
	This class does not define any methods


ClassRoom
Short description: 
This class extends place class and includes variables that add classroom specific information (department etc)
Methods:
	This class does not define any methods 

Person
Short description: 
This class represents a person in our app.
Methods:
	This class does not define any methods


Account	
Short description: 
The class is used to authenticate users when they use the app. An account object is created for every user that registers for the app.
Methods:
Create Account
Takes username, email and password and enters it into the database
Authenticate
Takes username and password from user and checks if they are correct from the database
Forgot Password
Takes username from user and sends an email to the user with a password reset code.


Swapper
Short description: 
The class is used to swap to sections or courses in between 2 persons. A swapper object is created for those users which requests for swap. The swapper object will only keep the information about one user which has requested the swap, because on the time of creation, the information for only one user is available.
Methods:
Request a swap
Gets the current and required username, section and course and creates an object of swap.
Contact swapper
Takes the username of a user and sends the user of swapper object a message to contact or confirm swap(The user will confirm from the confirm swap method).
Confirm Swap
Confirms the swap between 2 users and delete the swapper object form the database.


Course	
Short description: 
The Course Information would be extracted from the excel sheet, it would include its code, Credit hours, timing and sections(if any). These courses are selected by students and used in creating TimeTable.
Methods:
	This class has a state method, used to change some information based on          Section 

 
 Section 
Short Description:
This is a state class of Course, which could exist for some courses. With different sections, some information about class changes.

Swapper
Short description: 
This class is used to find empty spots on campus for students to sit and enjoy/study at. 
Methods:
Best Rated Class
This function returns the best rated empty class available at  the current time.
Nearest Class
This function returns the nearest empty class available at  the current time according to the current location entered by the user.
Empty Classes
This function returns all the empty classes available at the current time.
