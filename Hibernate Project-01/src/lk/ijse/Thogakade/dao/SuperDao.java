package lk.ijse.Thogakade.dao;

import lk.ijse.Thogakade.entity.SuperEntity;

import java.util.List;

public interface SuperDao<Entity extends SuperEntity, Id>  {
    boolean add(Entity entity) throws Exception;

    boolean delete(Id id) throws Exception;

    boolean update(Entity entity) throws Exception;

    Entity find(Id id) throws Exception;

    List<Entity> findAll() throws Exception;
}
