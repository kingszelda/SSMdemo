package share.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import share.dao.UserMapper;
import share.entity.User;
import share.service.UserService;

import javax.annotation.Resource;

/**
 * Created by shining.cui on 2015/11/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

}
