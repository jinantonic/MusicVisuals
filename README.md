# Music Visualiser Project

Name: Jina Park

Student Number: D19123917


# Description of the assignment
It has been over a year since the pandemic hit the whole world and here we are still living our lives, wasting our youth. Even though it has been such a devastating experience, as a Korean poet Sang-Wha Lee said, Spring comes to the lost land. This assignment represents the eagerness for the joy that we used to appreciate and the hope that we soon will be able to reunite with it. Since I am a huge music fan who barely turns off the music, I wanted to create an art piece that reacts to the music, so that it could enlighten my time while listening to the tunes. My all-time favourite character is Elmo, so he was chosen as the main actor in the program. He starts dancing with his two friends and as the song is being closer to the hook, mini Elmos are generated vibing together.


# Instructions
This project is consist of 4 classes which are Main, JinasVisual, Star and  Monster. Through the main class, the other three classes start executing and sharing the visualisation. 

# How it works
When you are partying, nothing boosts up the vibe more than the disco ball light. Star class contains constructors and 2 methods called update() and show() which calculate the star points using the map function and draw it. 

Now the disco ball and the light are ready, it is time to bring the dancers to the stage. Monster class is created to form the figure and it is efficient to have it as a separate class so that multiple Elmos can be created easily and quickly. Monster class has the constructor, update(), render(), getters and setters. Through update method, it eliminates the number of minimies that are created by the lerped average and through draw method, it creates the figure of the character. Getters and setters are in the class monster as well to pass the variables that are used in the Monster class to JinasVisual class. 

JinasVisual class creates the array of Star and Monster that their contained methods can be called. In settings(), it sets the screen size and the variables of half width and height which will be used in the drawing method. 



# What I am most proud of in the assignment
It was definitely a challenge since I am not familiar with the java language and my coding skill was not enough to implement my imagination. However, as time goes by, I was able to carry out some functions that I planned and gained so much knowledge discovering the methods and techniques for each situation. I never thought I could create a project that reacts to the music and now I have a quite satisfying result which can remind me of one of my favourite songs that helped me go through the hard time and this fun experience with Brayn. 

# Control
It is a very simple program which reacts to the music so the music and the movement stops when you press the space bar and when you hit a space bar again, music starts playing and Elmos start dancing again. 

![An image](images/p8.png)


[![YouTube](https://i.ytimg.com/vi/xY2zeKEhhEc/maxresdefault.jpg)](https://youtu.be/xY2zeKEhhEc)
