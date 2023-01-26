package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.HashMap;
@Repository //it tells it is the repo layer
public class StudentRepository {

//    creating database to store data because we are not storing in original db
    Map<Integer,Student> db = new HashMap<>();

    //getting the details of student
    public Student getStudent(int id){
        return db.get(id);
    }
    //adding the student
    public String  addStudent(Student student){
        int id = student.getAdminNo();
        db.put(id,student);
        return "Added Successfully";
    }
//delete the student
    public String deleteStudent(int id){
        if(!db.containsKey(id)) {
            return "Invalid Id";
        }
        db.remove(id);
        return "Student deleted successfully";
    }
    //update the student
    public String updateStudent(int id,int age) {
        if(!db.containsKey(id)){
            return null;
        }

//        Student student = db.get(admnNo);
//        student.setAge(age);
//        db.put(admnNo,student);
        db.get(id).setAge(age);
        return "Age updated successfully";
    }

    public Student getStudent(String name){
        for(int i: db.keySet()){
            if(db.get(i).getName().equals(name)){
                return db.get(i);
            }
        }
        return null;
    }
}
