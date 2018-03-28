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
@Entity(listener = TMemberListener.class)
@Table(name = "t_member")
public class TMember extends CommonEntity {

    /**  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    /**  */
    @Column(name = "login_id")
    public String loginId;

    /**  */
    @Column(name = "tmp_login_id")
    public String tmpLoginId;

    /**  */
    @Column(name = "password")
    public String password;

    /**  */
    @Column(name = "nickname")
    public String nickname;




}