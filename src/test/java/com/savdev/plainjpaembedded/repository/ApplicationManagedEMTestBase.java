package com.savdev.plainjpaembedded.repository;

import org.junit.ClassRule;
import org.junit.Rule;

/**
 * User: sav
 * Date: 20.12.14
 */
public class ApplicationManagedEMTestBase {

    @ClassRule
    public static ApplicationManagedRepositoryCrudService4Test repositoryServiceResource = new ApplicationManagedRepositoryCrudService4Test();

    TransactionHelper transactionHelper = new TransactionHelper(repositoryServiceResource.em.getTransaction());

    @Rule
    public ApplicationManagedEMTransactionTestBase transactionResource = new ApplicationManagedEMTransactionTestBase(transactionHelper);

    public RepositoryCrudServiceBean getRepositoryCrudServiceBean(){
        return repositoryServiceResource.repositoryCrudService;
    }
}
