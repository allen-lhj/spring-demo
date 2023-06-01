package ltd.newbee.mall.service.impl;

import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.dao.MallUserMapper;
import ltd.newbee.mall.dao.NewBeeMallUserTokenMapper;
import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.service.NewBeeMallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewBeeMallUserServiceImpl implements NewBeeMallUserService {
    @Autowired
    private MallUserMapper mallUserMapper;
    @Autowired
    private NewBeeMallUserTokenMapper newBeeMallUserTokenMapper;

    @Override
    public String login(String loginName, String passwordMD5) {
        MallUser user = mallUserMapper.selectByLoginNameAndPasswd(loginName, passwordMD5);
        if (user != null) {
            if (user.getLockedFlag() == 1) {
                return ServiceResultEnum.LOGIN_USER_LOCKED.getResult();
            }
            // 登陆后即执行修改token的操作
            String token = getNewToken(System.currentTimeMillis() + "", user.getUserId());
        }
    }
}
