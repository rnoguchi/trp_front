package jp.nr.trp.front.repository;

import jp.nr.trp.front.entity.TJourneyTimeline;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

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

    @Select
    List<TJourneyTimeline> selectTimelineByJourneyId(Long journeyId);

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