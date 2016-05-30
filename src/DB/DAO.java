package DB;

import java.util.List;

/**
 * Created by User on 23.05.2016.
 */
public interface DAO<T>{
    boolean create(T type);

    List<T> findAll();

    T findById(int id);

    void update(T type);

    void delete(T type);
}
