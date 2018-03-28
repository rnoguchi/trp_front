package jp.nr.trp.front.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import jp.nr.trp.front.entity.CommonEntity;

/**
 * 
 */
@Entity(listener = SysConfigListener.class)
@Table(name = "sys_config")
public class SysConfig extends CommonEntity {

    /**  */
    @Id
    @Column(name = "variable")
    public String variable;

    /**  */
    @Column(name = "value")
    public String value;

    /**  */
    @Column(name = "set_time")
    public LocalDateTime setTime;

    /**  */
    @Column(name = "set_by")
    public String setBy;
}