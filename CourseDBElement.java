
public class CourseDBElement implements Comparable {
	
	private String courseID;
	private int crn;
	private int number_of_credits;
	private String room_number;
	private String instructor_name;
	
	public CourseDBElement(String courseID, int crn, int number_of_credits, String room_number, String instructor_name ) {
		this.courseID=courseID;
		this.crn=crn;
		this.number_of_credits=number_of_credits;
		this.room_number=room_number;
		this.instructor_name=instructor_name;
		
	}

	public CourseDBElement() {
		courseID = "";
		crn = 0;
		number_of_credits = 0;
		room_number = "";
		instructor_name = "";
	}
	
	public int hashCode() {
		String str = String.valueOf(crn);
		return str.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDBElement other = (CourseDBElement) obj;
		if (crn != other.crn)
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		CourseDBElement obj=(CourseDBElement) o;
		return Integer.compare(obj.crn, crn);
	}
	
	


	public String getID() {
		return courseID;
	}



	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}



	public int getCRN() {
		return crn;
	}



	public void setCRN(int crn) {
		this.crn = crn;
	}



	public int getNumber_of_credits() {
		return number_of_credits;
	}



	public void setNumber_of_credits(int number_of_credits) {
		this.number_of_credits = number_of_credits;
	}



	public String getRoomNum() {
		return room_number;
	}



	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}



	public String getInstructor_name() {
		return instructor_name;
	}



	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}
	
	@Override
	public String toString() {
		String str = "\nCourse:" + courseID + " CRN:" + crn + " Credits:" + number_of_credits + " Instructor:" + instructor_name + " Room:" + room_number;
		return str;
	}


}
