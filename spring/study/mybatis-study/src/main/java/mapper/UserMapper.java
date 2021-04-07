package mapper;

import entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dsx
 */
public interface UserMapper {

    @Select("select * from t_user")
    public List<User> listAll();
}
