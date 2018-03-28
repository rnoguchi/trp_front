package jp.nr.trp.front.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import jp.nr.trp.front.entity.CommonEntity;

/**
 * 
 */
@Entity(listener = TJourneyTimelineListener.class)
@Table(name = "t_journey_timeline")
public class TJourneyTimeline extends CommonEntity {

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    /**  */
    @Column(name = "journey_id")
    public Long journeyId;

    /**  */
    @Column(name = "start_date")
    public LocalDateTime startDate;

    /**  */
    @Column(name = "end_date")
    public LocalDateTime endDate;

    /**  */
    @Column(name = "title")
    public String title;

    /**  */
    @Column(name = "description")
    public String description;




}