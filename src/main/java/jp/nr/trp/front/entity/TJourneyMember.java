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
@Entity(listener = TJourneyMemberListener.class)
@Table(name = "t_journey_member")
public class TJourneyMember extends CommonEntity {

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    /**  */
    @Column(name = "journey_id")
    public Long journeyId;

    /**  */
    @Column(name = "member_id")
    public Long memberId;

    /**  */
    @Column(name = "name")
    public String name;




}