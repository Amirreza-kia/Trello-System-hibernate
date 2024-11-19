package ir.maktabsharif.service.impl;

import ir.maktabsharif.model.Task;
import ir.maktabsharif.model.TaskStates;
import ir.maktabsharif.service.TaskService;
import ir.maktabsharif.util.ApplicationContext;

import java.util.Date;

public class TaskServiceImpl implements TaskService {
    @Override
    public void addTask(Date deadLine, String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadLine(deadLine);
        task.setTaskStates(TaskStates.CREATE);
        task.setCreateDate(new Date());
        ApplicationContext.taskRepository.saveOrUpdate(task);
    }
}
