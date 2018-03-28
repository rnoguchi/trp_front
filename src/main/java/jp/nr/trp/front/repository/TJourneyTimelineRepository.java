package jp.nr.trp.front.repository;

import jp.nr.trp.front.entity.TJourneyTimeline;
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
public interface TJourneyTimelineRepository {

    /**
     * @param id
     * @return the TJourneyTimeline entity
     */
    @Select
    TJourneyTimeline selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TJourneyTimeline entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TJourneyTimeline entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TJourneyTimeline entity);
}