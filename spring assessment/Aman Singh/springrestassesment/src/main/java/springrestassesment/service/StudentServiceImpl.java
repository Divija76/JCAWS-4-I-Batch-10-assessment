package springrestassesment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrestassesment.entity.Student;
import springrestassesment.exception.StudentNotFoundException;
import springrestassesment.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> retrieveAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student addStudent(Student newStudent) {
		return studentRepository.save(newStudent);
	}

	@Override
	public Student retrieveStudentById(Integer studentId) throws StudentNotFoundException {
		return studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
	}

	@Override
	public Student retrieveStudentByName(String studentName){
		return studentRepository.findStudentByName(studentName);
	}
	
}