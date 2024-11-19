package ir.maktabsharif.repository;

import ir.maktabsharif.model.Members;
import ir.maktabsharif.model.Users;

import java.util.Optional;

public interface UsersRepository extends BaseRepository<Members>{
    Optional<Users> login(String username, String password);
}
