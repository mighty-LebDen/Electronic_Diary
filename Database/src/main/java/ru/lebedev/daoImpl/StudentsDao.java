package ru.lebedev.daoImpl;

import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;
import ru.lebedev.dao.Dao;
import ru.lebedev.entity.Student;
import ru.lebedev.infrastructure.ConnectionManager;

public class StudentsDao implements Dao<Long, Student> {
	private final ConnectionManager connectionManager = ConnectionManager.getInstance();
	private static final StudentsDao INSTANCE = new StudentsDao();
	private StudentsDao(){}
	public static StudentsDao getInstance() {
		return INSTANCE;
	}
	@Override
	public Student add(Student student) {
		return null;
	}
	@SneakyThrows
	@Override
	public List<Student> findAll() {
		String sql = """
			SELECT student_id, fio, bd_date, class_id FROM students;
			""";
		List<Student> students = new ArrayList<>();
		try(var connection = connectionManager.open();
		var statement = connection.prepareStatement(sql)) {
			var res = statement.executeQuery();
			Student student = null;
			while (res.next()) {
				student = Student.builder()
					.studentId(res.getLong("student_id"))
					.fio(res.getString("fio"))
					.bdDate(res.getDate("bd_date").toLocalDate())
					.classID(res.getLong("class_id"))
					.build();
				students.add(student);
			}
		}
		return students;
	}
	
	@Override
	public Student findById(Long aLong) {
		return null;
	}
	
	@Override
	public boolean create(Student student) {
		return false;
	}
	
	@Override
	public boolean delete(Long aLong) {
		return false;
	}
}
