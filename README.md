STEPS:
1. Open the application in compatiple IDE like STS
2. Run the application on Server with tomcat 9 as server
3. When application opens on browser add /login.htm to begin.

# HotelManagementSystemSpringBoot
Spring Boot application for hotel industry which has different logins for Admin, Receptionist, Manager and Customer. 
Admins has the right to add different users that will only have access to the application within the hotel. 
Receptionist can login and make different bookings for customers visiting the hotel, they can raise room service request for particular booking and can checkout the customer. 
Also, receptionist have the live view of all the current room bookings and the open request that needed attention.
When receptionist create a booking for customers they take the email address of customers which create an entry of that customer in database and a mail is sent to customer confirming the booking made by them at hotel. 
Also, customers can create an account with the same email id they provided while creating the booking which shows all the bookings made by them at hotel and they have facility to provide anonymous feedback for their stay and for each employee of hotel. 
All these feedbacks are only visible to managers with current bookings and open service request.
