/* Name: Philip Chen
Teacher: Mr. Guglielmi
Date: October 27, 2020
Assignment: Using and manipulating files and arrays to create an interactive student mark book program
*/
import hsa.Console;
import java.awt.*;
import java.io.*;

// MarkBook class
public class MarkBook
{
    // declaration statements
    // c; instance variable for Console object
    // students; String array to store student names
    // marks; double array to store student marks
    // dataLoaded; stores boolean value for whether or not data has been loaded into program
    private Console c;
    private String[] students;
    private double[] marks;
    private boolean dataLoaded = false;
    
    // MarkBook class constructor; creates new Console object for output display
    public MarkBook()
    {
	c = new Console("TDSBMarkBook");
    }
    
    
    // splashScreen method; draws program splashScreen
    public void splashScreen()
    {
	// colour variables
	Color blue = new Color(94, 234, 255);
	Color green = new Color(3, 168, 42);
	Color yellow = new Color(255, 217, 64);
	Color darkBlue = new Color(3, 107, 168);        
	Color orange = new Color(247, 140, 52);
	Color red = new Color(255, 59, 59);
	Color lightGreen = new Color(65, 201, 62);
	
	c.setTextBackgroundColor(blue);
	c.clear();
	c.setFont(new Font("Century Gothic", 1, 60));
	c.setColor(green);
	c.drawString("t", 75, 260);
	c.setColor(yellow);
	c.drawString("d", 93, 260);
	c.setColor(darkBlue);
	c.drawString("s", 130, 260);
	c.setColor(orange);
	c.drawString("b", 153, 260);
	c.setColor(Color.white);
	c.drawString("MarkBook",195, 260);
	c.setColor(red);
	c.fillOval(495,205,70,70);
	c.setColor(lightGreen);
	c.setFont(new Font("Century Gothic", 1, 100));
	c.drawString("/",521,200);
	c.setColor(blue);
	c.fillRect(495,125,500,70);
	c.setColor(Color.white);
	c.fillRect(98,350,440,5);
	try
	{
	    Thread.sleep(500);
	}
	catch(Exception e)
	{
	}
	c.setColor(Color.black);
	c.fillRect(98,350,50,5);
	try
	{
	    Thread.sleep(500);
	}
	catch(Exception e)
	{
	}
	c.fillRect(148,350,50,5);
	try
	{
	    Thread.sleep(500);
	}
	catch(Exception e)
	{
	}
	c.fillRect(198,350,200,5);
	try
	{
	    Thread.sleep(250);
	}
	catch(Exception e)
	{
	}
	c.fillRect(398,350,100,5);
	try
	{
	    Thread.sleep(750);
	}
	catch(Exception e)
	{
	}
	c.fillRect(498,350,40,5);
	try
	{
	    Thread.sleep(250);
	}
	catch(Exception e)
	{
	}
	c.setTextBackgroundColor(Color.white);
    }
    
    
    // title method; prints program title on clear screen
    private void title()
    {
	c.clear();
	c.print(' ',33);
	c.println("TDSBMarkBook");
	c.println();
    }
    
    
    // pause method; pauses program and waits for user key input to continue
    private void pause()
    {
	c.println();
	c.println("(Press any key to continue)");
	c.getChar();
    }
    
    
    // pause method; pauses program and waits for user key input to continue
    private void pause(int spaces)
    {
	c.println();
	c.print(' ',spaces - 1);
	c.println("(Press any key to continue)");
	c.getChar();
    }
    
    
    // menu method; opens program main menu
    public void menu()
    {        
	// choiceStr; stores user String input that is parsed to type integer for valid integer input check
	// choice; stores integer value for user choice
	// run; stores boolean value for program loop control
	// ask; stores boolean value for local error handling loop control
	String choiceStr;
	int choice;
	boolean run = true;
	boolean ask;
    
	while(run)
	{
	    choiceStr = "";
	    choice = 0;
	    ask = true;
	    
	    // displays program options and prompts for user choice
	    title();
	    c.println("Welcome back.");
	    c.println("What would you like to do today?");
	    c.println("1. Load marks");
	    c.println("2. Display marks");
	    c.println("3. Update mark");
	    c.println("4. Save mark data");
	    c.println("5. Display average");
	    c.println("6. Create new class");
	    c.println("7. Quit");
	
	    // reads in and validates user choice
	    while(ask)
	    {
		try
		{
		    choiceStr = c.readLine();
		    choice = Integer.parseInt(choiceStr);
		    if(choice < 1 || choice > 7)
		    {
			title();
			c.println("Welcome back.");
			c.println("What would you like to do today?");
			c.println("1. Load marks");
			c.println("2. Display marks");
			c.println("3. Update mark");
			c.println("4. Save mark data");
			c.println("5. Display average");
			c.println("6. Create new class");
			c.println("7. Quit");
			c.println("Invalid choice. Please enter a valid choice.");
		    }
		}
		catch(Exception e)
		{
		    title();
		    c.println("Welcome back.");
		    c.println("What would you like to do today?");
		    c.println("1. Load marks");
		    c.println("2. Display marks");
		    c.println("3. Update mark");
		    c.println("4. Save mark data");
		    c.println("5. Display average");
		    c.println("6. Create new class");
		    c.println("7. Quit");
		    c.println("Invalid choice. Please enter a valid choice.");
		}
		
		// performs program function based on user choice
		switch(choice)
		{
		    case 1:
			ask = false;
			readFile();
			break;
		    case 2:
			if(dataLoaded)
			{
			    ask = false;
			    display();
			    break;
			}
			else
			{
			    title();
			    c.println("Welcome back.");
			    c.println("What would you like to do today?");
			    c.println("1. Load marks");
			    c.println("2. Display marks");
			    c.println("3. Update mark");
			    c.println("4. Save mark data");
			    c.println("5. Display average");
			    c.println("6. Create new class");
			    c.println("7. Quit");
			    c.println("Nothing to display.");
			    choiceStr = "";
			    choice = 0;
			    break;
			}
		    case 3:
			if(dataLoaded)
			{
			    ask = false;
			    update();
			    break;
			}
			else
			{
			    title();
			    c.println("Welcome back.");
			    c.println("What would you like to do today?");
			    c.println("1. Load marks");
			    c.println("2. Display marks");
			    c.println("3. Update mark");
			    c.println("4. Save mark data");
			    c.println("5. Display average");
			    c.println("6. Create new class");
			    c.println("7. Quit");
			    c.println("Nothing to update.");
			    choiceStr = "";
			    choice = 0;
			    break;
			}
		    case 4:
			if(dataLoaded)
			{
			    ask = false;
			    save();
			    break;
			}
			else
			{
			    title();
			    c.println("Welcome back.");
			    c.println("What would you like to do today?");
			    c.println("1. Load marks");
			    c.println("2. Display marks");
			    c.println("3. Update mark");
			    c.println("4. Save mark data");
			    c.println("5. Display average");
			    c.println("6. Create new class");
			    c.println("7. Quit");
			    c.println("Nothing to save.");
			    choiceStr = "";
			    choice = 0;
			    break;
			}
		    case 5:
			if(dataLoaded)
			{
			    ask = false;
			    average();
			    break;
			}
			else
			{
			    title();
			    c.println("Welcome back.");
			    c.println("What would you like to do today?");
			    c.println("1. Load marks");
			    c.println("2. Display marks");
			    c.println("3. Update mark");
			    c.println("4. Save mark data");
			    c.println("5. Display average");
			    c.println("6. Create new class");
			    c.println("7. Quit");
			    c.println("Nothing to display.");
			    choiceStr = "";
			    choice = 0;
			    break;
			}
		    case 6:
			ask = false;
			createNew();
			break;
		    case 7:
			goodbye();
		}
	    }
	}
    }
    
    
    // readFile method; reads in names and marks from class file into students and marks arrays, respectively
    public void readFile()
    {
	// input; instance variable for BufferedReader object to read input from file
	// file; stores user String input for name of file to read into program
	// num; stores int value of number of students in file
	// ask; stores boolean value for local error handling loop control
	// line; stores String input from file
	BufferedReader input;
	String file = "";
	int num;
	boolean ask = true;
	String line;
	
	title();
	
	while(ask)
	{
	    try
	    {
		// prompts for file name and opens file
		c.println("Enter file name:");
		file = c.readLine();
		input = new BufferedReader(new FileReader(file));
		
		// verifies file by searching for file header "Class"
		line = input.readLine();
		if(line.equals("Class"))
		{
		    // initializes students and marks arrays to proper size based on data in file
		    num = Integer.parseInt(input.readLine());
		    students = new String[num];
		    marks = new double[num];
		    
		    // reads file data into students and marks arrays
		    for(int i = 0; i < num; i++)
		    {                    
			line = input.readLine();
			students[i] = line;
			line = input.readLine();
			marks[i] = Double.parseDouble(line);
		    }
		    ask = false;
		    
		    // indicates to user that file has been successfully loaded
		    c.println("Successfully loaded " + file);
		    dataLoaded = true;
		}
		// indicates to user that file is not valid for program use
		else
		{
		    title();
		    c.println("Invalid file format. Please enter a properly formatted class file.");
		}
	    }
	    // indicates to user that file does not exist
	    catch(Exception e)
	    {
		title();
		c.println("Could not find " + file + ", please try again.");
	    }
	}
	
	pause();
    }
    
    
    // display method; displays students with index location, name, and mark
    public void display()
    {
	title();
	
	c.print(' ',36);
	c.println("Class");
	c.println();
	c.print(' ',11);
	c.print("ID");
	c.print(' ',22);
	c.print("Student");
	c.print(' ',20);
	c.println("Mark");
	
	for(int i = 0; i < students.length; i++)
	{
	    c.print(' ',11);
	    if(i < 10)
	    {
		c.print("0" + i);
	    }
	    else
	    {
		c.print(i);
	    }
	    c.print(' ',22);
	    c.print(students[i]);
	    c.setCursor(i + 6,63);
	    c.println(marks[i]);
	}
	
	pause(26);
    }
    
    
    // update method; updates mark of student specified by user String input
    public void update()
    {
	// student; stores user String input for which student to update mark
	// id; stores int value of student index number in students array
	// isStudent; stores boolean value to verify if String student is a valid existing student name
	// markStr; stores user String input that is parsed into type double for valid double input check
	// mark; stores double value of updated student mark
	// ask; stores boolean value for local error handling loop control
	String student = "";
	int id = 0;
	boolean isStudent = false;
	String markStr = "";
	double mark = 0;
	boolean ask = true;
    
	title();
	
	// prompts for student name
	while(ask)
	{
	    c.println("Enter student full name:");
	    student = c.readLine();
	    for(int i = 0; i < students.length; i++)
	    {
		if(student.equals(students[i]))
		{
		    id = i;
		    isStudent = true;
		    i = students.length;
		}
	    }
	    
	    if(isStudent)
	    {
		ask = false;
	    }
	    else
	    {
		title();
		c.println("No student named " + student + ". Please try again.");
	    }
	}
	ask = true;
	
	// prompts for student's updated mark
	c.println("Enter updated student mark:");
	while(ask)
	{
	    try
	    {                
		markStr = c.readLine();
		mark = Double.parseDouble(markStr);
		if(mark < 0)
		{
		    title();
		    c.println("Enter student full name:");
		    c.println(student);
		    c.println("Enter updated student mark:");
		    c.println("Invalid mark. Mark cannot be less than 0.");
		}
		else
		{
		    ask = false;
		}
	    }
	    catch(Exception e)
	    {
		title();
		c.println("Enter student full name:");
		c.println(student);
		c.println("Enter updated student mark:");
		c.println("Invalid mark. Please enter a valid decimal mark.");
	    }
	}
	
	// updates student's mark
	marks[id] = mark;
	
	// indicates to user that student's mark has been successfully updated
	c.println("Successfully updated " + student + "'s mark.");
	
	pause();
    }
    
    
    // save method; saves class data to new or existing file
    public void save()
    {
	// output; instance variable for PrintWriter object to write output to file
	// input; instance variable for BufferedReader object to verify file existence
	// file; stores user String input for name of file to save class data to
	// choiceStr; stores user String input that is parsed into type int for valid int input check
	// choice; stores int value for save destination choice
	// ask; stores boolean value for local error handling loop control
	PrintWriter output = null;
	BufferedReader input;
	String file = "";
	String choiceStr;
	int choice = 0;
	boolean ask = true;
	
	title();
	
	// prompts for save destination
	c.println("Choose save destination:");
	c.println("1. Existing file");
	c.println("2. New file");
	
	// reads in and validates user choice
	while(ask)
	{
	    try
	    {
		choiceStr = c.readLine();
		choice = Integer.parseInt(choiceStr);
		if(choice < 1 || choice > 2)
		{
		    title();
		    c.println("Choose save destination:");
		    c.println("1. Existing file");
		    c.println("2. New file");
		    c.println("Invalid choice. Please enter a valid choice.");
		}
		else
		{
		   ask = false;
		}
	    }
	    catch(Exception e)
	    {
		title();
		c.println("Choose save destination:");
		c.println("1. Existing file");
		c.println("2. New file");
		c.println("Invalid choice. Please enter a valid choice.");
	    }
	}
	ask = true;
	
	title();
	
	switch(choice)
	{
	    case 1:
		// verifies file existence
		while(ask)
		{
		    try
		    {
			c.println("Enter file name:");
			file = c.readLine();
			input = new BufferedReader(new FileReader(file));
			ask = false;
		    }
		    catch(Exception e)
		    {
			title();
			c.println("Could not find " + file + ", please try again.");
		    }
		}
		
		// opens file
		try
		{
		    output = new PrintWriter(new FileWriter(file));
		}
		catch(Exception e)
		{
		}
		// prints header
		output.println("Class");
		// prints class size
		output.println(students.length);
		// prints data from students and marks arrays
		for(int i = 0; i < students.length; i++)
		{
		    output.println(students[i]);
		    output.println(marks[i]);
		}
		
		// saves file
		output.close();
		break;
	    case 2:
		c.println("Enter new file name:");
		file = c.readLine();
		
		// creates new file
		try
		{
		    output = new PrintWriter(new FileWriter(file));
		}
		catch(Exception e)
		{
		}
		// prints header
		output.println("Class");
		// prints class size
		output.println(students.length);
		// prints data from students and marks arrays
		for(int i = 0; i < students.length; i++)
		{
		    output.println(students[i]);
		    output.println(marks[i]);
		}
		
		// saves file
		output.close();
	}
	
	// indicates to user that class data has been successfully saved to file
	c.println("Successfully saved class data to " + file);
	
	pause();
    }
    
    
    // average method; displays class average
    public void average()
    {        
	
	title();
	
	// calls private calcAverage method to calculate class average
	// rounds class average to nearest whole number before displaying
	c.println("The class average is: " + (int) (calcAverage(marks) + 0.5));
	
	pause();
    }
    
    
    // calcAverage method; calculates class average
    private double calcAverage(double[] d)
    {
	// average; stores double value of class average
	// sum; stores double value of sum of all student marks
	double average;
	double sum = 0;
	
	// calculates sum
	for(int i = 0; i < d.length; i++)
	{
	    sum += d[i];
	}
	
	// calculates average
	average = sum / d.length;
	
	return average;
    }
    
    
    // createNew method; creates new class with students and marks from user input
    public void createNew()
    {   
	// sizeStr; stores user String input that is parsed into type int for valid int input check
	// size; stores int value of the number of students in the new class
	// student; stores user String input for student name
	// markStr; stores user String input that is parsed into type double for valid double input check
	// mark; stores double value of student mark
	// ask; stores boolean value for local error handling loop control
	String sizeStr;
	int size = 0;
	String student = "";
	String markStr;
	double mark = 0;
	boolean ask = true;
	
	title();
	
	// prompts for number of students
	while(ask)
	{
	    try
	    {
		c.println("Enter number of students:");
		sizeStr = c.readLine();
		size = Integer.parseInt(sizeStr);
		if(size < 0)
		{
		    title();
		    c.println("Invalid number. Number of students cannot be less than 0.");
		}
		else
		{
		    ask = false;
		}
	    }
	    catch(Exception e)
	    {
		title();
		c.println("Invalid number. Please enter a valid number.");
	    }
	}
	ask = true;
	
	// initializes students and marks arrays to proper size based on user input
	students = new String[size];
	marks = new double[size];
	
	// prompts for student names and marks individually
	for(int i = 0; i < size; i++)
	{
	    title();
	
	    // student #i name
	    c.println("Enter student #" + i + " name:");
	    student = c.readLine();
	    students[i] = student;
	    
	    // student #i mark
	    c.println("Enter student #" + i + " mark:");
	    while(ask)
	    {
		try
		{                    
		    markStr = c.readLine();
		    mark = Double.parseDouble(markStr);
		    if(mark < 0)
		    {
			title();
			c.println("Enter student #" + i + " name:");
			c.println(student);
			c.println("Enter student #" + i + " mark:");
			c.println("Invalid mark. Mark cannot be less than 0.");
		    }
		    else
		    {
			ask = false;
		    }
		}
		catch(Exception e)
		{
		    title();
		    c.println("Enter student #" + i + " name:");
		    c.println(student);
		    c.println("Enter student #" + i + " mark:");
		    c.println("Invalid mark. Please enter a valid decimal mark.");
		}
	    }
	    marks[i] = mark;
	    ask = true;
	}
	
	// indicates to user that new class has been successfully created
	c.println("Successfully created new class.");
	dataLoaded = true;
	
	pause();
    }
    
    
    // goodbye method; displays program exit screen
    public void goodbye()
    {
	title();
	c.println("Exited program.");
	c.println("Thank you for using TDSBMarkBook.");
	c.println("Have a great day!");
	pause();
	System.exit(0);
    }
    
    
    // main method; executes program
    public static void main(String[] args)
    {
	MarkBook m = new MarkBook();
	m.splashScreen();
	m.menu();
    }
}
