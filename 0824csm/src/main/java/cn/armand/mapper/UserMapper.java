package cn.armand.mapper;

import cn.armand.domain.User;

public interface UserMapper {

	User findByUsername(String username);

}
