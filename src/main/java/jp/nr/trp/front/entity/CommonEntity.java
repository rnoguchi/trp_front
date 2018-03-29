package jp.nr.trp.front.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class CommonEntity implements Serializable {

    /**  */
    @Column(name = "updated_at")
    public LocalDateTime updatedAt;

    @Column(name = "updated_user")
    public String updatedUser;

    /**  */
    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @Column(name = "created_user")
    public String createdUser;
}
