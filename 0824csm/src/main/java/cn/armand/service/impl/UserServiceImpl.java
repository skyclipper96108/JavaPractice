package cn.armand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.armand.domain.User;
import cn.armand.mapper.UserMapper;
import cn.armand.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper mapper;
	@Override
	public User findByUser(User user) {
			User dbUser = mapper.findByUsername(user.getUsername());
			if(dbUser==null) {
				throw new RuntimeException("没有该用户");
			}else if(!dbUser.getPassword().equals(user.getPassword())) {
					throw new RuntimeException("密码不正确");
			}else {
				return dbUser;
			}
		
	}
	
}
