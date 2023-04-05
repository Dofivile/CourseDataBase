import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface  {
	
	private CourseDBStructure CourseStructure = new CourseDBStructure(20);
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 * */

	@Override
	public void add(String courseID, int crn, int number_of_credits, String room_Number, String instructor) {
		CourseDBElement element = new CourseDBElement(courseID, crn, number_of_credits, room_Number, instructor);
		
		CourseStructure.add(element);
		
	}

	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
	
			try {
				return CourseStructure.get(crn);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		
	
	}
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override

	public void readFile(File input) throws FileNotFoundException {
	    Scanner fileData = new Scanner(input);
	    
	    while(fileData.hasNext()) {
	        String courseId = fileData.next();
	        int crn = fileData.nextInt();
	        int number_of_credits = fileData.nextInt();
	        String room_Number = fileData.next();
	        String instructor = fileData.nextLine();
	        
	        add(courseId, crn, number_of_credits, room_Number, instructor);
	    }
	    fileData.close();
	}
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */

	@Override
	public ArrayList<String> showAll() {
		return CourseStructure.showAll();
	}



}
