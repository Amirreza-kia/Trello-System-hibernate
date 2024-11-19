package ir.maktabsharif.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    Optional<T> findById(Long id);
    List<T> getAll() ;
    void saveOrUpdate(T object) ;
    void delete(Long id) ;


}
