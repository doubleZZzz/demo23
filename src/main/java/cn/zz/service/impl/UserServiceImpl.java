package cn.zz.service.impl;

import cn.zz.domain.User;
import cn.zz.mapper.UserMapper;
import cn.zz.service.IUserService;

/**
 * @Auther: ZhangZhuo
 * @Date: 2019/4/24 17:02
 * @Description:
 */
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    public void insert(User user) {
        User u = new User();
        u.setAge(18);
        u.setName("zhangsan");
        userMapper.insert(u);
    }
}
