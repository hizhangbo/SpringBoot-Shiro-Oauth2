package top.crazybanana.modules.account.service;

import top.crazybanana.domain.common.P;
import top.crazybanana.domain.modules.account.User;

import java.util.List;

public interface UserService {
    Integer count();

    User getById(Integer id);

    User getByName(String name);

    List<User> getAll();

    List<User> getByPage(Integer pageIndex, Integer pageSize);

    P<User> page(int pageIndex, int pageSize);
}
