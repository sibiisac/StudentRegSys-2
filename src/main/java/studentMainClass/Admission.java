package studentMainClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.joda.time.LocalDate;

import registration.Course;
import registration.Module;
import registration.Student;



public class Admission {

	public static void main(String[] args) {
		LocalDate sDate, eDate;
		HashMap <String, List<Module>> moduleList;
		
		Course ece, eee;
		List<Course> courses = new ArrayList<Course>(); 
		ArrayList<Student> studentsList = new ArrayList<Student>();
		Module ct1,ee1,ee2,ee3;
		
		sDate = new LocalDate(2017,9,04);
		eDate = new LocalDate(2021, 5,15);
		
		
		LocalDate dobPeter = new LocalDate (2000, 6, 25);
		Student peter = new Student ("Peter Lessly", dobPeter, 12100950);
		LocalDate dobVictor =  new LocalDate(2001,02, 05);
		Student victor = new Student("Victor George", dobVictor, 13100920 );
		
		LocalDate dobVirat =  new LocalDate(1999,5,15);
		Student virat = new Student("Virat Dua",dobVirat, 111000950);
		LocalDate dobJils = new LocalDate (2001, 9, 12);
		Student jils = new Student ("Jils John", dobJils, 13100100);
		studentsList.add(peter);studentsList.add(victor);
		studentsList.add(virat);studentsList.add(jils);
		//Module Objects 
		ee1 = new Module("Signals and Communications","EE357");
		ee2 = new Module("Analogue Systems Design","EE342");
		ee3 = new Module("Power Electronics","EE448");
		ct1 = new Module("Engineering Computing I","CT1110");
		
		List<Student> ee1_students = new ArrayList<Student>();
		List<Student> ee2_students = new ArrayList<Student>();
		List<Student> ee3_students = new ArrayList<Student>();
		List<Student> ct1_students = new ArrayList<Student>();
		
		//Adding students to the list
		ee1_students.add(peter);ee1_students.add(victor);
		ee2_students.add(virat);ee2_students.add(jils);
		ct1_students.add(peter);ct1_students.add(victor);
		ee3_students.add(virat);ee3_students.add(jils);
		
		ee1.addStudent("ee1", ee1_students);ee2.addStudent("ee2",ee2_students);
		ee3.addStudent("ee3", ee3_students);ct1.addStudent("ct1",ct1_students);
		
		
		// Course Objects 
		ece = new Course("Electronics & Computer Engineering",sDate,eDate);
		eee = new Course ("Electronics & Electrical Engineering", sDate, eDate); 

		List<Module> eceModules = new ArrayList<Module>();
		List<Module> eeeModules = new ArrayList<Module>();
		
		eceModules.add(ee1);eceModules.add(ct1);
		eeeModules.add(ee2);eeeModules.add(ee3);
		
		ece.addModule("ece", eceModules);eee.addModule("eee", eeeModules);

		courses.add(ece);courses.add(eee);
		
		System.out.printf("%s",String.format("%0$-25s%0$-35s%0$-50s","Student Name","Modules","Course"));
		System.out.println();
		System.out.printf("%s",String.format("%0$-25s%0$-35s%0$-50s","============","========", "======"));
		System.out.println();
		for (Student student : studentsList) {
			boolean coursePrint = true;
			boolean studentPrint = true;
			for (Course course: courses) {
				moduleList = course.getModuleList();
				for (List<Module> modules: moduleList.values()) {
					for (Module module: modules) {
						HashMap<String, List<Student>> students = module.getStudentList() ;
						for (List<Student> stdList:students.values()) {
							for(Student std: stdList) {
								if (std.getName().equals(student.getName())){
									if (studentPrint) {
										System.out.printf("%s",String.format("%0$-25s",student.getName()));
										studentPrint = false;
									}
									else {
										System.out.printf("%s",String.format("%0$-25s",' '));
									}
									System.out.printf("%s",String.format("%0$-35s",module.getModuleName()));
									if (coursePrint) {
										System.out.printf("%s",String.format("%0$-50s",course.getCourseName()));
										coursePrint = false;
									}
								}
							}
							System.out.println();
						}
					}
				}
			}
		}
	
// TODO Auto-generated method stub

	}

}
