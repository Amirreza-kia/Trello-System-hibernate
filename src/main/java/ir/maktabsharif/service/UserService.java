package ir.maktabsharif.service;

import ir.maktabsharif.model.Role;

public interface UserService {
    Role login(String username, String password);
    void addMember(String username, String password);
    void removeMember(Long memberId);
}
