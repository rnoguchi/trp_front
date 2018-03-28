package jp.nr.trp.front.repository;

import jp.nr.trp.front.entity.TJourney;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 */
@Dao
@ConfigAutowireable
public interface TJourneyRepository {

    /**
     * @param id
     * @return the TJourney entity
     */
    @Select
    TJourney selectById(Long id);

    @Select
    List<TJourney> selectMyJourneyByLoginId(String loginId);

    @Select
    List<TJourney> selectMyJourneyByTmpLoginId(String tmpLoginId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TJourney entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TJourney entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TJourney entity);
}