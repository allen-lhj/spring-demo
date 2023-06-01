package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.MallUserToken;
public interface NewBeeMallUserTokenMapper {
    int insertSelective(MallUserToken record);
    MallUserToken selectByPrimaryKey(Long userId);
    MallUserToken selectByToken(String token);
    int updateByPrimaryKeySelective(MallUserToken record);
}
