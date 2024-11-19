package ir.maktabsharif.service;

import ir.maktabsharif.model.Task;

import java.util.Date;

public interface TaskService {
        void addTask(Date deadLine,String title,String description);

}
