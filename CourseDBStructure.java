import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	
	private int size;
	private final double loadingFactor = 1.5;
	protected  ArrayList<LinkedList<CourseDBElement>> hashTable;


	public CourseDBStructure(int number_of_elements) {
		
		this.size = next4k3Prime((int) (number_of_elements / loadingFactor));


		hashTable = new ArrayList<>(this.size);


		for (int i = 0; i < size; ++i) {
			hashTable.add(null);
		}
	}


	public CourseDBStructure(String testing, int size) {
	
		this.size = size;

	
		hashTable = new ArrayList<>(size);


		for (int i = 0; i < size; ++i) {
			hashTable.add(null);
		}
	}

	/** 
	 * Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	 * of the CourseDatabaseElement object's crn value.
	 * If the CourseDatabaseElement already exists, exit quietly
	 *  
	 * @param element the CourseDBElement to be added to CourseDBStructure
	 */
	@Override
	public void add(CourseDBElement element) {
		
		int index = element.getCRN()%hashTable.size();
		
		if (hashTable.get(index) == null) {
			LinkedList<CourseDBElement> course = new LinkedList<>();
			course.add(element);
			hashTable.set(index, course);
		} else {
		
			boolean checked = false;
			LinkedList<CourseDBElement> course = hashTable.get(index);
			for (int i = 0; i < hashTable.size(); ++i) {
				CourseDBElement list = course.get(i);
				if (list.getCRN() == element.getCRN()) {
					
					course.set(i, element);
					checked = true;
					break;
				}
			}
			if (!checked) {
			
				course.add(element);
			}

		}
	}

	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	public CourseDBElement get(int crn) throws IOException {
		
		CourseDBElement dummyElement = new CourseDBElement("", crn, 0, "", "");
		int hashCode = dummyElement.getCRN() % size;

		
		if (hashTable.get(hashCode) != null) {
			
	        for (CourseDBElement element : hashTable.get(hashCode)) {
	            if (element.getCRN() == crn) {
	                
	                return element;
	            }
	        }
	    }
	    throw new IOException("CRN not found");
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
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < hashTable.size(); i++) { // loop through hashTable
			LinkedList<CourseDBElement> tempList = hashTable.get(i);
			if(tempList != null) {
				for(int j = 0; j < tempList.size(); j++) { // loop through buckets
					CourseDBElement element = tempList.get(j);
					list.add(element.toString());
				}
			}
		}
		return list;
	}
	@Override
	public int getTableSize() {
		return this.size;
	}
	
	
	
	public static int next4k3Prime(int n) {
	    int num = (n / 4) * 4 + 3;
	    while (!isPrime(num)) {
	        num += 4;
	    }
	    return num;
	}

	public static boolean isPrime(int n) {
	    if (n <= 1) {
	        return false;
	    }
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
}
