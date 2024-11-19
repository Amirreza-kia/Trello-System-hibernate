package ir.maktabsharif.service.impl;

import ir.maktabsharif.exception.GenerallyNotFoundException;
import ir.maktabsharif.model.Members;
import ir.maktabsharif.model.Role;
import ir.maktabsharif.model.Users;
import ir.maktabsharif.service.UserService;
import ir.maktabsharif.util.ApplicationContext;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Role login(String username, String password) {
        Optional<Users> optionalUser = ApplicationContext.usersRepository.login(username, password);
        if (optionalUser.isEmpty()) {
            throw new GenerallyNotFoundException("UserName or Password is incorrect");
        }
        return optionalUser.get().getRole();
    }

    @Override
    public void addMember(String username, String password) {
        Members members = new Members();
        members.setUsername(username);
        members.setPassword(password);
        members.setRole(Role.USER);
        ApplicationContext.usersRepository.saveOrUpdate(members);
    }

    @Override
    public void removeMember(Long memberId) {
        ApplicationContext.usersRepository.delete(memberId);
    }

}
