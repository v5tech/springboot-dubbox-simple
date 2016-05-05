package net.aimeizi.user;


import net.aimeizi.DataResult;
import net.aimeizi.user.User;

public interface UserService {

    /**
     * 检测服务健康状态用
     * @return
     */
    String ping();

    DataResult<User> registerUser(User u);

    DataResult<User> getUserById(Long userId);

    DataResult<Boolean> deleteUserById(Long userId);

    DataResult<Boolean> updatePassword(Long userId, String oldPwd, String newPwd);
}