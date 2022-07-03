package com.codeclan.file.folders;

import com.codeclan.file.folders.models.File;
import com.codeclan.file.folders.models.Folder;
import com.codeclan.file.folders.models.Person;
import com.codeclan.file.folders.repositories.FilesRepository;
import com.codeclan.file.folders.repositories.FolderRepository;
import com.codeclan.file.folders.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ApplicationTests {

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	FilesRepository filesRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canAddPersonAndFolderAndFile() {
		Person person = new Person("John");
		personRepository.save(person);

		Folder folder = new Folder("Folder 1", person);
		folderRepository.save(folder);

		File file = new File(".jpeg", 50093, folder);
		filesRepository.save(file);
	}

}
