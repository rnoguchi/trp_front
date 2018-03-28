package jp.nr.trp.front.entity;

import org.seasar.doma.*;

/**
 * 
 */
@Entity(listener = TJourneyListener.class)
@Table(name = "t_journey")
public class TJourney extends CommonEntity {

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    /**  */
    @Column(name = "member_id")
    public Long memberId;

    /**  */
    @Column(name = "title")
    public String title;

    /**  */
    @Column(name = "description")
    public String description;




}