package top.crazybanana.modules.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.crazybanana.domain.common.P;
import top.crazybanana.domain.modules.account.User;
import top.crazybanana.modules.account.repository.UserRepository;
import top.crazybanana.modules.account.service.UserService;
import top.crazybanana.modules.base.service.impl.BaseServiceImpl;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer count(){
        return userRepository.count();
    }

    @Override
    public User getById(Integer id){
        return userRepository.getById(id);
    }

    @Override
    public User getByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public List<User> getByPage(Integer pageIndex, Integer pageSize){
        return userRepository.getByPage((pageIndex - 1) * pageSize, pageSize);
    }

    @Override
    public P<User> page(int pageIndex, int pageSize) {
        Integer count = count();
        Integer pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

        P<User> p = new P<>(pageIndex, pageSize, pageCount, getByPage(pageIndex, pageSize));
        return p;
    }

}
