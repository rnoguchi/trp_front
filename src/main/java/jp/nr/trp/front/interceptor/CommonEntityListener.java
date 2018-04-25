package jp.nr.trp.front.interceptor;

import jp.nr.trp.front.entity.CommonEntity;
import jp.nr.trp.front.util.TrpDateUtil;
import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class CommonEntityListener<T extends CommonEntity> implements EntityListener<T> {

    @Override
    public void preUpdate(T entity, PreUpdateContext<T> context) {
        entity.updatedAt = TrpDateUtil.get();
        entity.updatedUser = context.getMethod().getDeclaringClass().getName();
    }

    @Override
    public void preInsert(T entity, PreInsertContext<T> context) {
        entity.updatedAt = TrpDateUtil.get();
        entity.updatedUser = context.getMethod().getDeclaringClass().getName();
        entity.createdAt = TrpDateUtil.get();
        entity.createdUser = context.getMethod().getDeclaringClass().getName();
    }
}
