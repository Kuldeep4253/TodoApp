package com.todos.todomanage.services;

import com.todos.todomanage.controllers.ToDoControllers;
import com.todos.todomanage.exception.ResourceNotFoundException;
import com.todos.todomanage.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class TodoServices {
    Logger log= LoggerFactory.getLogger(TodoServices.class);
    List<Todo> todos=new ArrayList<>();

    /***
     *
     * @param todo as request body to create todo taks
     * @return todo object
     */
    public Todo createTodo(Todo todo){
        todos.add(todo);
        log.info("Todo Created Successfully: {}",this.todos);
        return todo;
    }

    public List<Todo> getTodos(){
        log.info("Todo Get Successfully: {}",this.todos);
        return todos;
    }
    public Todo getSingleTodos(int id){
        log.info("Todo Get Single Successfully: {}",this.todos);
        return todos.stream().filter(t->id==t.getId()).findAny().orElseThrow(()->new ResourceNotFoundException("Todo Not Found {}"+id, HttpStatus.NOT_FOUND));
    }
    public Todo updatetodo(Todo todo,int id){
        List<Todo> updatetodos=todos.stream().map(t->{
            if(t.getId()==id){
                todo.setTitle(todo.getTitle());
                todo.setContents(todo.getContents());
                //Perform update
                return t;
            }
            else{
                return t;
            }
        }).collect(Collectors.toList());
        todos=updatetodos;
        todo.setId(id);
        return todo;
    }
    public void deletetodo(int id){
        List<Todo> updatetodos=todos.stream().filter(t->t.getId()!=id).collect(Collectors.toList());
        todos=updatetodos;
    }
}
