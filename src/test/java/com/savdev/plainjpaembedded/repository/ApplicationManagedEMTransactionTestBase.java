package com.savdev.plainjpaembedded.repository;

import org.junit.rules.ExternalResource;

/**
 * User: sav
 * Date: 20.12.14
 */
public class ApplicationManagedEMTransactionTestBase extends ExternalResource {

    private TransactionHelper transactionHelper;

    public ApplicationManagedEMTransactionTestBase(TransactionHelper transactionHelper) {
        this.transactionHelper = transactionHelper;
    }

    @Override
    protected void before() {
        transactionHelper.beginTransaction();
    }

    @Override
    protected void after() {
        transactionHelper.rollbackTransaction();
    }
}
