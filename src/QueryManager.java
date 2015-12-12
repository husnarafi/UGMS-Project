public class QueryManager {

	public float findGpaByStudentId(String studentId, Bag<Student> studentBag) {
		// input function-> std id and std bag
		// iterate through std bag
		// check the std id with given id
		// if std id matches then get the gpa
		// else no students id exists

		for (Student std : studentBag) {
			if (studentId.equals(std.getId())) { 
				return std.getGpa();
			}
		}
		
		return -1;
	}
}
