package top.crazybanana.modules.base.repository;

import org.apache.ibatis.annotations.Param;
import top.crazybanana.domain.modules.account.User;

import java.util.List;

public interface BaseRepository<T> {

    Integer count();

    T getById(@Param("id") Integer id);

    T getByName(@Param("name") String name);

    List<T> getAll();

    List<T> getByPage(@Param("skip")Integer skip, @Param("pageSize")Integer pageSize);
}
