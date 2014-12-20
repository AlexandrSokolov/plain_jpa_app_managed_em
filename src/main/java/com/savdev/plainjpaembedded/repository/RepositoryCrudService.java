package com.savdev.plainjpaembedded.repository;

/**
 * User: sav
 * Date: 19.12.14
 */
interface RepositoryCrudService {
    <T> T create(T t);

    <T> T createAndRefresh(T t);

    <T> T find(Object id, Class<T> type);

    <T> T update(T t);

    void delete(Object t);
}
