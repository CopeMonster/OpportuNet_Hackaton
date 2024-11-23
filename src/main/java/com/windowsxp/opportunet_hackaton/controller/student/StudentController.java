package com.windowsxp.opportunet_hackaton.controller.student;

import com.windowsxp.opportunet_hackaton.dto.auth.student.StudentDTO;
import com.windowsxp.opportunet_hackaton.entities.CV;
import com.windowsxp.opportunet_hackaton.entities.Student;
import com.windowsxp.opportunet_hackaton.exception.UserNotFoundException;
import com.windowsxp.opportunet_hackaton.repositories.CVRepository;
import com.windowsxp.opportunet_hackaton.repositories.StudentRepository;
import com.windowsxp.opportunet_hackaton.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long studentId) {
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents() {
        List<StudentDTO> studentDTOS = studentService.getStudents();
        return ResponseEntity.ok(studentDTOS);
    }

    @PostMapping("/{studentId}/upload-cv")
    public ResponseEntity<CV> uploadCv(
            @PathVariable Long studentId,
            @RequestParam("file") MultipartFile file) {
        CV cv = studentService.uploadCV(file, studentId);
        return ResponseEntity.ok(cv);
    }

    @GetMapping("/{studentId}/cv")
    public ResponseEntity<CV> getStudentCv(@PathVariable Long studentId) {
        CV cv = studentService.getCV(studentId);
        return ResponseEntity.ok(cv);
    }

    @PutMapping("/{studentId}/update-profile")
    public ResponseEntity<Student> updateStudentProfile(
            @PathVariable Long studentId,
            @RequestParam(value = "aboutMe", required = false) String aboutMe,
            @RequestParam(value = "skills", required = false) List<String> skills,
            @RequestParam(value = "portfolioLink", required = false) String portfolioLink) {

        Student updatedStudent = studentService.updateStudentProfile(studentId, aboutMe, skills, portfolioLink);
        return ResponseEntity.ok(updatedStudent);
    }
}
