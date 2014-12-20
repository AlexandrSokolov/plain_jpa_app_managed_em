package com.savdev.plainjpaembedded.repository;

import com.savdev.plainjpaembedded.entities.Spaceship;
import org.junit.Before;
import org.junit.Test;

/**
 * User: sav
 * Date: 19.12.14
 */
public class SpaceshipRepositoryCrudServiceTestUsingApplicationManagedEM extends ApplicationManagedEMTestBase {

    SpaceshipRepositoryCrudServiceBean spaceshipRepositoryCrudService;

    @Before
    public void instantiate() {
        this.spaceshipRepositoryCrudService = new SpaceshipRepositoryCrudServiceBean();
        this.spaceshipRepositoryCrudService.repositoryCrudService = getRepositoryCrudServiceBean();
    }

    @Test
    public void testCreate() {
        spaceshipRepositoryCrudService.create(new Spaceship("New Space", 100));
    }
}
