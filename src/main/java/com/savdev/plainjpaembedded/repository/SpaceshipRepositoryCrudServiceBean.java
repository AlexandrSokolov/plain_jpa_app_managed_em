package com.savdev.plainjpaembedded.repository;

import com.savdev.plainjpaembedded.entities.Spaceship;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 * User: sav
 * Date: 19.12.14
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class SpaceshipRepositoryCrudServiceBean implements SpaceshipRepositoryCrudService {

    @Inject
    RepositoryCrudService repositoryCrudService;

    @Override
    public Spaceship create(Spaceship entity) {
        return repositoryCrudService.create(entity);
    }

    @Override
    public Spaceship find(long id) {
        return repositoryCrudService.find(id, Spaceship.class);
    }

    @Override
    public Spaceship update(Spaceship entity) {
        return repositoryCrudService.update(entity);
    }

    @Override
    public void delete(Spaceship entity) {
        repositoryCrudService.delete(entity);
    }
}
