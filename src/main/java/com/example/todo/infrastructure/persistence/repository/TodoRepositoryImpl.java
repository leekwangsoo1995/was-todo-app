package com.example.todo.infrastructure.persistence.repository;

import com.example.todo.domain.entity.Todo;
import com.example.todo.domain.repository.TodoRepository;
import com.example.todo.infrastructure.persistence.entity.TodoJpaEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * リポジトリ実装 - インフラ層。EJB @Stateless でトランザクション管理。
 */
@Stateless
public class TodoRepositoryImpl implements TodoRepository {

    @PersistenceContext(unitName = "todoPU")
    private EntityManager em;

    @Override
    public Todo save(Todo todo) {
        TodoJpaEntity entity = TodoJpaEntity.fromDomain(todo);
        if (entity.getId() == null) {
            em.persist(entity);
            em.flush();
        } else {
            entity = em.merge(entity);
        }
        return entity.toDomain();
    }

    @Override
    public Optional<Todo> findById(Long id) {
        TodoJpaEntity entity = em.find(TodoJpaEntity.class, id);
        return Optional.ofNullable(entity).map(TodoJpaEntity::toDomain);
    }

    @Override
    public List<Todo> findAll() {
        return em.createNamedQuery("TodoJpaEntity.findAll", TodoJpaEntity.class)
                .getResultList()
                .stream()
                .map(TodoJpaEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        TodoJpaEntity entity = em.find(TodoJpaEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return em.find(TodoJpaEntity.class, id) != null;
    }
}
