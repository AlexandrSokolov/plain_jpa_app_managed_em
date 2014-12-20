package com.savdev.plainjpaembedded.repository;

import com.savdev.plainjpaembedded.entities.Spaceship;

/**
 * User: sav
 * Date: 19.12.14
 */
public interface SpaceshipRepositoryCrudService {
    Spaceship create(Spaceship entity);
    Spaceship find(long id);
    Spaceship update(Spaceship entity);
    void delete(Spaceship entity);
}
