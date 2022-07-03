package com.codeclan.file.folders.controllers;

import com.codeclan.file.folders.models.File;
import com.codeclan.file.folders.repositories.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    FilesRepository filesRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles() {
        return new ResponseEntity<>(filesRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<File> getFile(@PathVariable Long id) {
        return new ResponseEntity(filesRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postFile(@RequestBody File file) {
        filesRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}
