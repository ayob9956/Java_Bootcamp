package com.example.homework13p1.Controller;

import com.example.homework13p1.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api/v1/task/homework13")
public class ControllerTask {

    ArrayList<Task> tasks = new ArrayList<>();
    @GetMapping(path = "/get")
    public ArrayList<Task> getTask(){
        return tasks;
    }
    @PostMapping("/add")
    public String createTask(@RequestBody Task task1){
        tasks.add(task1);
        return"Task created";
    }
    @PutMapping("/update/{index}")
    public String updatedTask(@PathVariable int index,@RequestBody Task task1){
        tasks.set(index,task1);
        return "task updated";

    }
    @PutMapping("/status/{index}")
    public String changeTask(@PathVariable int index){
        Task task1 = tasks.get(index);
        if (task1.getStatus().equalsIgnoreCase("done")){
            task1.setStatus("not done");


        } else if (task1.getStatus().equalsIgnoreCase("not done")){
            task1.setStatus("done");

        }

        return "task status updated "+ task1.getStatus();

    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index){
        tasks.remove(index);
        return"task removed";

    }

    @GetMapping("/search/{title}")
    public Task serchTask(@RequestBody @PathVariable String title){
        for (Task task:tasks) {
            if (task.getTitle().equalsIgnoreCase(title)){
                return task;

            }


        }return new Task("Not found","Not found","Not found","Not found");

    }



}
