package com.windowsxp.opportunet_hackaton.controller.student;

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


@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

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
}
