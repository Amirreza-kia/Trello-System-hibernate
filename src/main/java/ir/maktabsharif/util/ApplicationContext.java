package ir.maktabsharif.util;

import ir.maktabsharif.repository.TaskRepository;
import ir.maktabsharif.repository.UsersRepository;
import ir.maktabsharif.repository.impl.TaskRepositoryImpl;
import ir.maktabsharif.repository.impl.UserRepositoryImpl;
import ir.maktabsharif.service.TaskService;
import ir.maktabsharif.service.UserService;
import ir.maktabsharif.service.impl.TaskServiceImpl;
import ir.maktabsharif.service.impl.UserServiceImpl;

public class ApplicationContext {
    public static final String[] LOGIN_MENU_ITEM = {"LOGIN", "EXIT"};
    public static final String[] ADMIN_MENU_ITEM = {"ADD Task","User", "EXIT"};

    public static UsersRepository usersRepository = new UserRepositoryImpl();
    public static TaskRepository taskRepository = new TaskRepositoryImpl();

    public static UserService usersService = new UserServiceImpl();
    public static TaskService taskService = new TaskServiceImpl();

}
