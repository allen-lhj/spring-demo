package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.MallUser;
import org.apache.ibatis.annotations.Param;
public interface MallUserMapper {
    MallUser selectByLoginNameAndPasswd(@Param("loginName")  String loginName,
                                        @Param("password") String password);
}
