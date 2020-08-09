package ru.vsu.railroads.service;

import ru.vsu.railroads.persistence.DBTrainStore;
import java.util.List;
import java.util.Map;

public class TrainService {
    private DBTrainStore store = DBTrainStore.getInstance();

    public <T> boolean create(String curClass, Map<String, String> params) {
        return store.create(curClass, params);
    }

    public <T> List<T> readAll(Class<T> curClass) {
        return store.readAll(curClass);
    }

    public <T> T readByID(Class<T> curClass, Long id) {
        return null;
    }

    public <T> boolean update(Class<T> curClass, Long id, String[] params) {
        return false;
    }

    public <T> boolean delete(Class<T> curClass, Long id) {
        return store.deleteOneById(curClass.getSimpleName().toLowerCase(), id);
    }
}
