package DAO;
import java.util.Optional;

/*
    DAO Stands for data access object. This interface provides the base methods for the concrete implementations
    of the DAO functionality. This allows for concrete implementations of accessing the lower level data
    (such as a database) to be decoupled from the usage of classes that implement the DAO interface.

    If now the Pizzas were to be stored in a Microsoft SQL server, all that is needed is to change the implementation
    of the DAO classes, without needing to change their usage.
 */

public interface DAO<T> {

    Optional<T> get(long id);

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}