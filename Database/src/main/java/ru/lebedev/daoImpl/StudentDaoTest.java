package ru.lebedev.daoImpl;




public class StudentDaoTest {
	public static void main(String[] args) {
		var studentDao = StudentsDao.getInstance();
		studentDao.findAll()
			.stream()
			.forEach(s -> System.out.println(s + " \n --------------"));
	}
}
