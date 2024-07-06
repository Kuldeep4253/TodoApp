package com.todos.todomanage.controllers;

import com.todos.todomanage.models.Todo;
import com.todos.todomanage.services.TodoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class ToDoControllers {

    Logger log= LoggerFactory.getLogger(ToDoControllers.class);
    Random rand=new Random();
    @Autowired
    private TodoServices todoservices;


    @PostMapping
    public ResponseEntity<Todo> createToDoHandler(@RequestBody Todo todo){
        todo.setId(rand.nextInt(99999));
        Date date=new Date();
        log.info("Current Date {}"+date);
        todo.setAddedDate(date);
        log.info("Create TODO");
        log.info("Calling service to create TODO");
        return new ResponseEntity<Todo>(todoservices.createTodo(todo), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Todo>> getAllToDos(){
        log.info("Getting TODO");
        log.info("Calling service to Get TODO");
        return new ResponseEntity<List<Todo>>(todoservices.getTodos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getToDo(@PathVariable  int id){
        log.info("Getting Single TODO");
        log.info("Calling service to Get Single TODO ID");
        return new ResponseEntity<Todo>(todoservices.getSingleTodos(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateToDoHandler(@RequestBody Todo newtodo,@PathVariable int id){
        log.info("Update TODO");
        log.info("Calling service to Update TODO");
        return new ResponseEntity<Todo>(todoservices.updatetodo(newtodo,id), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteToDoHandler(@PathVariable int id){
        log.info("Delete TODO");
        log.info("Calling service to Delete TODO");
        todoservices.deletetodo(id);
        return new ResponseEntity<String>( HttpStatus.ACCEPTED);
    }


    //Exception Handler
    @ExceptionHandler(NullPointerException.class)
    //@ExceptionHandler(value={NullPointerException.class, NumberFormatException.class, ArrayIndexOutOfBoundsException.class})
    public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException ex){
        return new ResponseEntity<String>("Some Issue found in application .... "+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
}

