package com.example.StudentProject.Controller;
import com.example.StudentProject.Service.StudentService;
import com.example.StudentProject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //    public StudentController(com.example.StudentProject.Service.StudentService studentService) {
//        super();
//        this.studentService = studentService;
//    }

    // handler method to handle list students and return mode and view
    @GetMapping(value={"", "/", "students"})
    public String listStudents(Model model)
    {
            model.addAttribute("students",studentService.getAllStudents());
            //model.get
            return "students";
    }
    @GetMapping("/students/new")
    public String createStudentFrom(Model model)
    {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/addStudent")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        return "redirect:students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentFrom (@PathVariable Long id, Model model)
    {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }
        @PostMapping("/students/{id}")
        public String updateStudent(@PathVariable Long id,
        @ModelAttribute("student") Student student, Model model )
        {
            // get student from database by id

            Student existingStudent = studentService.getStudentById(id);
            existingStudent.setId(id);
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());

            //save updated student object
            studentService.updateStudent(existingStudent);
            return "redirect:/students";
        }

        // handler method to handle delete student request
        @GetMapping("/students/{id}")
        public String deleteStudent(@PathVariable Long id)
        {
        studentService.deleteStudentById(id);
         return "redirect:/students";
        }

}
