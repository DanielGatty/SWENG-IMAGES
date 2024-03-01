# SWENG-IMAGES

Contract Stipulates
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

In order to meet this contract, the package contains two relevant classes:
1. SingleImage
2. Presentation

The properties the SingleImage needs to be able to control are: 
1. The image source
2. The image position
3. The image scale
4. The image width 
5. The image height
6. The image rotation
7. The image delay
8. The image duration

Constructors for SingleImage:
1. The image source
2. The image source, position
3. The image source, position, scale
4. The image source, position, scale, rotation
5. The image source, position, scale, rotation, delay
6. The image source, position, scale, rotation, delay and duration

Methods for SingleImage:
1. The ability to change the image url
2. The ability to reposition the image
3. The ability to rescale the image
4. The ability to change width of image
5. The ability to change height of image
6. The ability to rotate the image
7. The ability to hide the image
8. The ability to show the image

The properties the Presentation needs to be able to control are:
1. The images themselves (i.e. adding and removing images)
2. The position of the presentation
3. The width of the presentation
4. The height of the presentation
5. The timings of the presentation 
6. The direction of the presentation (forwards or backwards)
7. Start / Stop status

Constructors for Presentation:
1. Nothing specified
2. The position of the presentation
3. The position of the presentation, width, height
4. The position of the presentation, width, height, timings
5. The position of the presentation, width, height, timings, direction

Methods for Presentation:
1. The ability to add images to the presentation (use varargs to do it all in one go)
2. The ability to remove an image from the presentation
3. The ability to reposition the presentation
4. The ability to change the presentation width
5. The ability to change the presentation height
6. The ability to change presentation timings
7. The ability to change presentation direction
8. The ability to stop the presentation
9. The ability to start the presentation

Transitions between images are by default instant, but fading may be implemented on a time dependent basis.
