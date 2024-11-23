package com.windowsxp.opportunet_hackaton.service.student;

import com.windowsxp.opportunet_hackaton.entities.CV;
import com.windowsxp.opportunet_hackaton.entities.Student;
import com.windowsxp.opportunet_hackaton.exception.EmptyFileException;
import com.windowsxp.opportunet_hackaton.exception.NotFoundException;
import com.windowsxp.opportunet_hackaton.exception.UserNotFoundException;
import com.windowsxp.opportunet_hackaton.repositories.CVRepository;
import com.windowsxp.opportunet_hackaton.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CVRepository cvRepository;

    @Value("${upload.directory}")
    private String uploadDirectory;

    public CV uploadCV(MultipartFile file, Long studentId) {
        if (file.isEmpty()) {
            throw new EmptyFileException();
        }

        try {
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new UserNotFoundException("Student not found"));

            File dir = new File(uploadDirectory);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            File uploadFile = new File(dir, originalFilename);

            file.transferTo(uploadFile);

            CV cv = student.getCv() != null ? student.getCv() : new CV();
            cv.setFileName(originalFilename);
            cv.setFilepath(uploadFile.getAbsolutePath());
            cv.setUploadedAt(LocalDateTime.now());
            cv.setStudent(student);

            cvRepository.save(cv);

            student.setCv(cv);
            studentRepository.save(student);

            return cv;

        } catch (IOException e) {
            e.printStackTrace();
            throw new EmptyFileException();
        }
    }

    public CV getCV(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new UserNotFoundException("Student not found"));

        CV cv = student.getCv();
        if (cv == null) {
            throw new NotFoundException();
        }

        return cv;
    }
}
