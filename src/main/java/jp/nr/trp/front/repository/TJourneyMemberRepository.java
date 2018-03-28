package jp.nr.trp.front.repository;

import jp.nr.trp.front.entity.TJourneyMember;
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
public interface TJourneyMemberRepository {

    /**
     * @param id
     * @return the TJourneyMember entity
     */
    @Select
    TJourneyMember selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TJourneyMember entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TJourneyMember entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TJourneyMember entity);
}