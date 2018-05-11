package top.crazybanana.modules.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.crazybanana.domain.common.P;
import top.crazybanana.modules.base.repository.BaseRepository;
import top.crazybanana.modules.base.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

//    @Autowired
//    BaseRepository<T> baseRepository;
//
//    @Override
//    public Integer count(){
//        return baseRepository.count();
//    }
//
//    @Override
//    public List<T> getById(Integer id){
//        return baseRepository.getById(id);
//    }
//
//    @Override
//    public List<T> getAll() {
//        return baseRepository.getAll();
//    }
//
//    @Override
//    public List<T> getByPage(Integer pageIndex, Integer pageSize){
//        return baseRepository.getByPage((pageIndex - 1) * pageSize, pageSize);
//    }
//
//    @Override
//    public P<T> page(int pageIndex, int pageSize) {
//        Integer count = count();
//        Integer pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
//
//        P<T> p = new P<>(pageIndex, pageSize, pageCount, getByPage(pageIndex, pageSize));
//        return p;
//    }
}
