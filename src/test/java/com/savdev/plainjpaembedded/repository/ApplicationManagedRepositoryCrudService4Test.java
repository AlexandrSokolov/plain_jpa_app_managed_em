package com.savdev.plainjpaembedded.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExternalResource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * User: sav
 * Date: 19.12.14
 */
public class ApplicationManagedRepositoryCrudService4Test extends ExternalResource {

    EntityManager em;
    RepositoryCrudServiceBean repositoryCrudService;

    @Override
    public void before() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        this.em = emf.createEntityManager();
        this.repositoryCrudService = new RepositoryCrudServiceBean();
        this.repositoryCrudService.em = this.em;
    }
}
