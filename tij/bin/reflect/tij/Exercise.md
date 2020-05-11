Exercise 1: (1) In ToyTest.java, comment out Toy’s default constructor and explain what happens.
'''
Cannot instantiate
'''
Exercise 2: (2) Incorporate a new kind of interface into ToyTest.java and verify that it is detected and displayed properly.
'''
interface Color{}
'''
Exercise 3: (2) Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape, then downcast it back to a Rhomboid. Try downcasting to a Circle and see what happens.

Exercise 4: (2) Modify the previous exercise so that it uses instanceof to check the type before performing the downcast. 398 Thinking in Java Bruce Eckel
Exercise 5: (3) Implement a rotate(Shape) method in Shapes.java, such that it checks to see if it is rotating a Circle (and, if so, doesn’t perform the operation).
Exercise 6: (4) Modify Shapes.java so that it can "highlight" (set a flag in) all shapes of a particular type. The toString( ) method for each derived Shape should indicate whether that Shape is "highlighted."
Exercise 7: (3) Modify SweetShop.java so that each type of object creation is controlled by a command-line argument. That is, if your command line is "Java Sweetshop Candy," then only the Candy object is created. Notice how you can control which Class objects are loaded via the commandline argument.
Exercise 8: (5) Write a method that takes an object and recursively prints all the classes in that object’s hierarchy.
Exercise 9: (5) Modify the previous exercise so that it uses Class.getDeclaredFields( ) to also display information about the fields in a class.
Exercise 10: (3) Write a program to determine whether an array of char is a primitive type or a true Object