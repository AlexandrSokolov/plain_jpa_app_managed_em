package com.savdev.plainjpaembedded.repository;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User: sav
 * Date: 19.12.14
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
class RepositoryCrudServiceBean implements RepositoryCrudService{

    @PersistenceContext
    EntityManager em;

    /**
     * The passed entity is persisted frst, then the flush method is invoked. This forces the EntityManager to flush its
     * cache to the database. The state of the cached entities will be written to the database with one or more INSERT
     * statements—but not committed yet. Either the database or the EntityManager will have to compute any technical
     * primary key now. This strange behavior is sometimes required to force the JPA provider to update the technical key in the entity instance.
     * The persist and flush sequence further enforces the update of the @Id computed in the database. It is not backed by the spec,
     * but it works with the popular providers.
     *
     * @param t
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(T t) {
        this.em.persist(t);
        this.em.flush();
        return t;
    }

    /**
     * The passed entity is persisted first, then the flush method is invoked. This forces the EntityManager to flush its
     * cache to the database. The state of the cached entities will be written to the database with one or more INSERT
     * statements—but not committed yet. Either the database or the EntityManager will have to compute any technical
     * primary key now. After the flush invocation, the entity is going to be refreshed. The state of the entity is
     * overwritten with the state in the database. Finally, the fresh entity is returned to the caller. This strange
     * behavior is sometimes required to force the JPA provider to update the technical key in the entity instance.
     * The persist, flush, and refresh sequence further enforces the update of the @Id computed in the database. It is
     * not backed by the spec, but it works with the popular providers.
     *
     * The method is needed to be invoked when there are some defaults on database schema table, but jpa entity does not know about it anything.
     * Such invocations are very heavy and not recommended. The better option is to update JPA entity and invoke the "create" method instead
     *
     * @param t
     * @param <T>
     * @return
     */
    @Override
    public <T> T createAndRefresh(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }



    @Override
    public <T> T find(Object id, Class<T> type) {
        return (T) this.em.find(type, id);
    }

    @Override
    public <T> T update(T t) {
        return (T) this.em.merge(t);
    }

    @Override
    public void delete(Object t) {
        //only managed entities can be removed.
        //obtaining an entity with the EntityManager#getReference method is a faster and lighter variant.
        //you could also merge or find the entity before removing.
        //merging before removing is required for checks of the @Version field
        //Only up-to-date entities can be removed. The attempt to delete a stale entity will fail with javax.persistence.OptimisticLockException.
        Object ref = this.em.getReference(t.getClass(), t);
        this.em.remove(ref);
    }
}
