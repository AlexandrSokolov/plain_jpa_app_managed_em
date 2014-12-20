package com.savdev.plainjpaembedded.repository;

import javax.annotation.Resource;
import javax.persistence.EntityTransaction;
import java.util.Objects;

/**
 * User: sav
 * Date: 20.12.14
 */
public class TransactionHelper {
    @Resource
    private EntityTransaction userTransaction;

    public TransactionHelper(EntityTransaction userTransaction) {
        Objects.requireNonNull(userTransaction, "UserTransaction cannot be nullable");
        this.userTransaction = userTransaction;
    }

    void beginTransaction() {
        System.out.println("begin transacaton");
        try {
            userTransaction.begin();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void commitTransaction() {
        System.out.println("commit transacaton");
        try {
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void commitAndBeginTransaction() {
        try {
            userTransaction.commit();
            userTransaction.begin();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void rollbackTransaction() {
        try {
            userTransaction.rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
