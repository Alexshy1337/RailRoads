package ru.vsu.railroads.service;


import ru.vsu.railroads.persistence.DBTrainStore;
import java.util.List;
import java.util.Map;

public class UniService<T> {
    private DBTrainStore store = DBTrainStore.getInstance();
    public Class<T> curClass;

    public UniService(Class<T> cClass){
        curClass = cClass;
    }
    public boolean create(Map<String, String> params) {
        return store.create(curClass, params);
    }

    public List<T> readAll(String where) {
        return store.readAll(curClass, where);
    }

    public T readById(Long id) {
        return store.readAll(curClass, " where id="+id).get(0);
    }

    public boolean update(Long id, Map<String, String> params) {
        return store.update(curClass, id, params);
    }

    public boolean delete(Long id) {
        return store.deleteById(curClass.getSimpleName().toLowerCase(), id);
    }
}
