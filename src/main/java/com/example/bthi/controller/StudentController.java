package com.example.bthi.controller;

import com.example.bthi.entitty.Student;
import com.example.bthi.entitty.TestDetail;
import com.example.bthi.repository.StudentRepository;
import com.example.bthi.repository.TestDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private TestDetailsRepository testDetailsRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/")
    public String listTestDetails(Model model) {
        List<TestDetail> testDetailsList = (List<TestDetail>) testDetailsRepository.findAll();
        model.addAttribute("testDetailsList", testDetailsList);
        return "home";
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam String keyword, Model model) {

        List<Student> students = studentRepository.findByEmailContainingOrFullNameContaining(keyword, keyword);

        List<TestDetail> passedStudents = testDetailsRepository.findByPointObtainedGreaterThanEqual(5.0);

        model.addAttribute("students", students);
        model.addAttribute("passedStudents", passedStudents);

        return "home";
    }
}


