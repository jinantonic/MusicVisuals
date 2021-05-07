# Music Visualiser Project

Name: Jina Park

Student Number: D19123917


# Description of the assignment
It has been over a year since the pandemic hit the whole world and here we are still living our lives, wasting our youth. Even though it has been such a devastating experience, as a Korean poet Sang-Wha Lee said, Spring comes to the lost land. This assignment represents the eagerness for the joy that we used to appreciate and the hope that we soon will be able to reunite with it. Since I am a huge music fan who barely turns off the music, I wanted to create an art piece that reacts to the music, so that it could enlighten my time while listening to the tunes. My all-time favourite character is Elmo, so he was chosen as the main actor in the program. He starts dancing with his two friends and as the song is being closer to the hook, mini Elmos are generated vibing together.


# Instructions
This project is consist of 4 classes which are Main, JinasVisual, Star and  Monster. Through the main class, the other three classes start executing and sharing the visualisation. 

# How it works
When you are partying, nothing boosts up the vibe more than the disco ball light. Star class contains constructors and 2 methods called update() and show() which calculate the star points using the map function and draw it. 
Now the disco ball and the light are ready, it is time to bring the dancers to the stage. Monster class is created to form the figure and it is efficient to have it as a separate class so that multiple Elmos can be created easily and quickly. Monster class has the constructor, update(), render(), getters and setters. Through updat

The song named DARE by Gorillaz is chosen which helped to get through the hard time this year, so that this could remind me of .
# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

