package org.samierfabien.dao;

import org.samierfabien.model.Entity;

import java.util.List;

public interface DAOInterface {
    public Entity find(int id);

    public List<Entity> findAll();

    public void insert(Entity entity);

    public void update(Entity entity);

    public void delete(Entity entity);
}
