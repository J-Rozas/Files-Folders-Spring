package com.codeclan.file.folders.components;

import com.codeclan.file.folders.models.File;
import com.codeclan.file.folders.models.Folder;
import com.codeclan.file.folders.models.Person;
import com.codeclan.file.folders.repositories.FilesRepository;
import com.codeclan.file.folders.repositories.FolderRepository;
import com.codeclan.file.folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!Test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FilesRepository filesRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Person john = new Person("John");
        Person dave = new Person("Dave");
        Person jane = new Person("Jane");
        personRepository.save(john);
        personRepository.save(dave);
        personRepository.save(jane);

        Folder accounting_folder = new Folder("Accounting Folder", john);
        Folder finance_folder = new Folder("Finance Fodler", jane);
        Folder engineering_folder = new Folder("Engineering Folder", dave);
        folderRepository.save(accounting_folder);
        folderRepository.save(finance_folder);
        folderRepository.save(engineering_folder);

        File accounting_basics = new File(".doc", 39384, accounting_folder);
        File accounting_brief = new File(".docx", 4828, accounting_folder);
        File finance_presentation = new File(".pdf", 382334, finance_folder);
        File engineering_base_front_end = new File(".js", 93843, engineering_folder);
        filesRepository.save(accounting_basics);
        filesRepository.save(accounting_brief);
        filesRepository.save(finance_presentation);
        filesRepository.save(engineering_base_front_end);
    }
}
