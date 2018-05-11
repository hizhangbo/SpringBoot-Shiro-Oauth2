package top.crazybanana.modules.account.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.crazybanana.domain.modules.account.User;
import top.crazybanana.modules.base.repository.BaseRepository;

import java.util.List;

@Mapper
public interface UserRepository extends BaseRepository<User> {
}