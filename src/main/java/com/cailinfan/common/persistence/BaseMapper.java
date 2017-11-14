package com.cailinfan.common.persistence;

import java.util.List;

/**
 * base interface for MyBatis mapper
 *
 * @param <T> the identifier's type of entity
 * @param <E> the type of entity
 *
 * Created by cailinfan on 2017/11/14.
 */
public interface BaseMapper<T, E> {
    E selectOne(T id);

    List<E> selectList(E entity);

    int insert(E entity);

    int update(E entity);

    int delete(T id);
}
