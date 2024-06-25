package himedia.myportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.dao.UserDao;
import himedia.myportal.repositories.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean join(UserVo vo) {
		int insertedCount = 0;
		insertedCount = userDao.insert(vo);
		return insertedCount == 1;
	}

	@Override
	public UserVo getUser(String email) {
		UserVo userVo = userDao.selectUser(email);
		//System.out.println("Service UserVo: " + userVo);
		return userVo;
	}

	@Override
	public UserVo getUser(String email, String password) {
		UserVo userVo = userDao.selectUser(email, password);
		return userVo;
	}
	

}
