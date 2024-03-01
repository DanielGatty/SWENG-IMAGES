# SWENG-IMAGES

Contract Stipulates:

- This contract will contain all the tools necessary to implement a professional and coherent Image library that
complies with the project wide standards specified.
- Each item within the Image library should be accompanied by comprehensive metadata, including a title, description,
  creation date and comments.
- A documented version control would be ideal if providing revised versions at a later date.
- Examples of things the Images library should enable us to do is: define source file (URL) of the image, control the
  time of (or sequence of) presentation, control the size and position of the image on screen and the duration the
  image is on the screen.
- This contract should be delivered through a compressed ZIP file with all tools necessary to run the product using Java 11.
- Example images (if provided) should be stored using PWS compliant formats.

From assignment spec:

images:
- source file,
- time of (or sequence of) presentation
- size and position on screen
- duration

The user interface must also provide the following features (their actual implemented appearance may vary substatntially):
- a file browser highlighting media presentation files locally from file systems and/or remotely
- mouse and/or touchscreen support

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import java.time.Duration;

