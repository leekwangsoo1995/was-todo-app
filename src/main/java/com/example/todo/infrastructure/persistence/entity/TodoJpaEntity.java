package com.example.todo.infrastructure.persistence.entity;

import com.example.todo.domain.entity.Todo;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * JPAエンティティ - インフラ層のみが持つ。ドメインエンティティとは分離。
 */
@Entity
@Table(name = "TODOS")
@NamedQueries({
    @NamedQuery(name = "TodoJpaEntity.findAll",
                query = "SELECT t FROM TodoJpaEntity t ORDER BY t.createdAt DESC")
})
public class TodoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 255)
    private String title;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "COMPLETED", nullable = false)
    private boolean completed;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;

    public TodoJpaEntity() {
    }

    /**
     * ドメインエンティティからJPAエンティティへ変換
     */
    public static TodoJpaEntity fromDomain(Todo todo) {
        TodoJpaEntity entity = new TodoJpaEntity();
        entity.id = todo.getId();
        entity.title = todo.getTitle();
        entity.description = todo.getDescription();
        entity.completed = todo.isCompleted();
        entity.createdAt = todo.getCreatedAt();
        entity.updatedAt = todo.getUpdatedAt();
        return entity;
    }

    /**
     * JPAエンティティからドメインエンティティへ変換
     */
    public Todo toDomain() {
        Todo todo = new Todo();
        todo.setId(this.id);
        todo.setTitle(this.title);
        todo.setDescription(this.description);
        todo.setCompleted(this.completed);
        todo.setCreatedAt(this.createdAt);
        todo.setUpdatedAt(this.updatedAt);
        return todo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
