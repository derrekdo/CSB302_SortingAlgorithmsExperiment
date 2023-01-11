# Sorting Algorithms Experiment

Purpose: To practice and demonstrate proficiency in creating algorithms for sorting as well as testing and analyzing their efficiencies.

Skills Used: Java programming

Knowledge Goals: Sorting Algorithm Efficiencies




Summary

In this project, you will use Java to run experiments in testing the efficiencies of the Sorting Algorithms: 

Insertion Sort
Binary Insertion Sort
Merge Sort
Quick Sort (pivot selected as first element)
Quick Sort (pivot selected as random element)
Quick Sort (pivot selected with Median-of-three)
Heap Sort
Counting Sort
Bucket Sort
Radix Sort (optional)

In addition to the coding, a Word document final report will be created that will detail the design and experimental results.




Part 1: Designing the Experiment

When you are designing your experiment, you and your team will determine the following:

Design a UML document for your software's organization.
Decide on reasonable inputs and how to generate reasonable sample inputs. 
Range restriction on inputs: array of any size, but only includes integers between 0 and 10,000. There can be duplicate values and its encouraged. Test at least 10 arrays of increasing size per configuration (see below). 
Test the following variations of input configurations to test. Examples would be:
Random Ordered Array
Reverse Ordered Array
Ordered Array
50% Ordered Array
75% Ordered Array
Metrics for complexity measurement.
Size of data input
Count actual number of basic operation's executions
(Optional) Recording the number of microseconds (nanoseconds / 1000) the algorithms takes would be an interesting addition.
Decide on how the results will be displayed
Plan on displaying results using a plot chart. You can do this by either using Java libraries or outputting a file and generating them in Excel. Other forms of data visualization may be approved with permission.
Add Experiment Design details into Final Report Document. Include the UML document, specifications on metrics chosen as well as the chosen results display. Discuss reasoning for organization of code.




Part 2: Java Implementation

Implement the algorithms previously mentioned in Java and perform the experiments with the chosen input lists. Results should be evaluated in terms of the metrics.

The implementation of this is largely up to you. Here are a few things I look for in well-designed implementations:

Follows principles of OOP: Inheritance, Polymorphism, Abstraction, Encapsulation
I'm not checking for each one of these. Obviously, there are situations where none or very few will be used and there are situations where all may be used. Use your discretion.
Well-organized project structure.
This could include multiple packages or possibly not. 
Use of Interfaces.
For any classes where it will be relevant, use of interfaces is a great idea. 
Easy-to-understand output for testing.
Output for this project will contain two parts: 
Part 1: Evidence of successful execution by printing output from main into Terminal.
Part 2: Output printed to files that will be used to create charts OR separate Chart visualizations by using Java libraries.
Use of junit tests is optional but encouraged as well.
Because you will be using graphs in this project, some of your output will be in charts. You will either need to do your research around how to create charts in Java or output to text files and create charts separately.
Output your data structures with your data to output text files.




Part 3: Illustrating and Analyzing Results

In this step, you will provide charts to illustrate the performance of the algorithms. Action items:

Compare the performance of all of the algorithms using plot charts.
Final Report: Include sections on the design, experimental results (charts) and provide comments in your program that discuss the empirical results with the theoretical results. Do your findings meet theoretical expectations?




Examples of Chart outputs (your results may look very different)




Some other items of importance
Use javadoc comments on your functions to explain what they do. You do not have to do this in the class implementations where there is an interface, you can use @inheritDoc.
Be sure your code is clean, legible and easy to read.
Feel free to go above and beyond!  Add new methods and functionality, test in different ways in addition to what you are required to do, be creative! The top grades go to those who go above and beyond. Strive for excellence.
You are not required to create unit tests but are welcome to do so if you wish.
Including the runtime as a comment on algorithms with loops in them will be seen as going above and beyond as well.




Format Requirements
Please ensure you follow the structure as listed above. Use IntelliJ to do your work. Use javadoc comments where appropriate.
Your submissions will be by providing a link to your Team's Github repo where this code is stored.
For your final report, be as professional as possible. I am not putting direct limitations on its length.




Assessment

Please see the Rubric attached for assessment.




Deliverables
Github repo link (includes code and report file)
