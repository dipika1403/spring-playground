package com.galvanize.playground.springplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    // get all records
    @GetMapping("")
    public Iterable<Lesson> all(){
        return this.repository.findAll();
    }

    //insert new
    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson){
        return this.repository.save(lesson);
    }

    //delete by id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    //update title
    @PatchMapping("/{id}/title/{title}")
    public void update(@PathVariable Long id, @PathVariable String title){
//        Optional<Lesson> lessonById = repository.findById(id);
//        if (lessonById.isPresent()) {
//            Lesson lesson = lessonById.get();
//            lesson.setTitle(title);
//            repository.save(lesson);
//        }
        repository.updateTitleById(title, id);

    }
}
