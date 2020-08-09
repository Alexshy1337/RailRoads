package ru.vsu.railroads.persistence;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBTrainStore {
    private static DBTrainStore instance;

    private DBTrainStore() {
    }

    public static DBTrainStore getInstance() {
        if (instance == null)
            instance = new DBTrainStore();
        return instance;
    }

    public boolean create(String curClass, Map<String, String> params) {
        StringBuilder query = new StringBuilder().append("insert into ").append(curClass).append(" (");
        String[] keys = params.keySet().toArray(new String[0]);

        query.append(keys[0]);
        for(int i = 1; i < keys.length; i++)
            query.append(",").append(keys[i]);
        query.append(") values (").append(params.get(keys[0]));

        for(int i = 1; i < keys.length; i++)
            query.append(",").append(params.get(keys[i]));
        query.append(")");
        return DoQueries.executeNonSelectQuery(query.toString());
    }

    public <T> List<T> readAll(Class<T> curClass) {
        DoQueries.Mapper<T> mapper = rs -> {
            List<T> list = new ArrayList<>();
            final Field[] declaredFields = curClass.getDeclaredFields();
            for (Field f : declaredFields)
                f.setAccessible(true);
            while (rs.next()) {
                T test = (T) curClass.getConstructor().newInstance();
                for (Field field : declaredFields) {
                    String name = field.getName();
                    try {
                        String value = rs.getString(name);
                        field.set(test, field.getType().getConstructor(String.class).newInstance(value));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.add(test);
            }
            return list;
        };
        String className = curClass.getSimpleName().toLowerCase();
        return DoQueries.executeSelectQuery("select * from " + className, mapper);
    }

    public <T> List<T> readById(Long id) {
        DoQueries.Mapper<T> mapper= null;//rs -> {

        // };
        return DoQueries.executeSelectQuery("query", mapper);
    }

    public boolean update(){
        return DoQueries.executeNonSelectQuery("update from ");
    }

    public boolean deleteOneById(String curClass, long id) {
        return DoQueries.executeNonSelectQuery("delete from " + curClass + " where id=" + id + ";");
    }
}
