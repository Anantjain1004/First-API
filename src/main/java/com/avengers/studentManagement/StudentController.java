package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController//important because it tells us that we are creating restful api in this class(First annotation)
public class StudentController {




    //////////

//    @GetMapping("/get_student/{admnNo}")//now it has become an api
//    //client has to give this information
//    public Student getStudent(@PathVariable("admnNo") int admnNo){//to get in request parameter form,
//        // request param start after ? only
//        return db.get(admnNo);
//    }

    //multiple parameter
// @GetMapping("/get_student")//now it has become an api
//    //client has to give this information
//    public Student getStudent(@RequestParam("admnNo") int admnNo, @RequestParam("name") String name){//to get in request parameter form,
//        // request param start after ? only
//        return db.get(admnNo);
//    }


    @Autowired//no need to create object of class if we use this annotation
StudentService studentService;

    //adding the information of the student
    @PostMapping("/add_student")//it helps in defining endpoint
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    //get information
    @GetMapping("/get_student")//now it has become an api
    //client has to give this information
    public ResponseEntity getStudent(@RequestParam("q") int admnNo){//to get in request parameter form,
        // request param start after ? only
        Student student = studentService.getStudent(admnNo);
       return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

//name ki get api instaed of admnno
@PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id, @RequestParam("age") int age){
        String response = studentService.updateStudent(id,age);
        if(response == null){
            return new ResponseEntity<>("Invalid request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Updated",HttpStatus.ACCEPTED);
}
@DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id")  int id){
        String response = studentService.deleteStudent(id);
        if(response.equals("Invalid Id")){
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(response,HttpStatus.FOUND);
}


//getting through names
    @GetMapping("/get_studentByName/{name}")//now it has become an api
    //client has to give this information
    public ResponseEntity getStudent(@PathVariable("name") String name){//to get in request parameter form,
        // request param start after ? only
        Student student = studentService.getStudent(name);
        return new ResponseEntity<>(student,HttpStatus.FOUND);

    }


}
