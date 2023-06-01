package ltd.newbee.mall.service;

public interface NewBeeMallUserService {
    /*
    * 登陆
    * @param loginName
    * @param passwordMD5
    * @return
    * */

    String login(String loginName, String passwordMD5);
}
