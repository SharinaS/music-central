# MusicCentral
A fullstack Java application and RESTful API that serves to store favorite songs and albums, and link them over to YouTube.

# Contributor
Sharina Stubbs
### About
Java software developer and life-long learner. Works to write clean and intelligent code, maintain a solid sense of humor, a learning mindset and an ever-improving emotional IQ, not necessarily in that order.

# Dependencies
(descriptions taken directly from the Spring Initializer, at `start.spring.io)
* Spring Data JPA
  * To persist data in SQL stores with data persistence API using Spring Data and Hibernate.
* Spring Security
  * Highly customizable authentication and access-control framework for Spring applications.
* Spring Boot DevTools
  * Provides fast application restarts, LiveReload, and configuration for enhanced development experience.
* PostgreSQL Driver
  * A JDBC and R2DBC driver that allows Java programs to connect to a PostgreSQL database using standard, database independent Java Code.
* Thymeleaf
  * A modern server-side Java template engine for both web and standalone environments. Allows HTML to be correctly displayed in browsers and as static prototypes.
* Spring Web
  * Build web, including Restful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.


# Key-Words
* Relational Database Management System
* RESTful API
* Object Oriented Programming

# User Stories
Please see file in repo, called USERSTORIES.md

# Domain Modeling
Pending.

# Domain-Entity-Relationships
Pending

# Stretch Goals to Consider
* Set up a many to many relationship between users so a user can follow other users and see what music they like / other users can follow signed in user.
  * Can view and be notified of addition of artists and/or songs, and be exposed to different genres. 
* Display a notification to user when other users add an artist. Consider WebSockets or AWS 
  * Using WebSockets, make notifications system show updates in real time, not just when the page refreshes.