package jp.nr.trp.front.repository;

import jp.nr.trp.front.entity.TMember;
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
public interface TMemberRepository {

    /**
     * @param id
     * @return the TMember entity
     */
    @Select
    TMember selectById(Long id);

    @Select
    TMember selectByLoginId(String loginId);

    @Select
    TMember selectByTmpLoginId(String tmpLoginId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TMember entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TMember entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TMember entity);
}