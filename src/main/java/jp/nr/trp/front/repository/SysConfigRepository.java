package jp.nr.trp.front.repository;

import jp.nr.trp.front.entity.SysConfig;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 */
@Dao
@ConfigAutowireable
public interface SysConfigRepository {

    /**
     * @param variable
     * @return the SysConfig entity
     */
    @Select
    SysConfig selectById(String variable);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(SysConfig entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(SysConfig entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(SysConfig entity);
}