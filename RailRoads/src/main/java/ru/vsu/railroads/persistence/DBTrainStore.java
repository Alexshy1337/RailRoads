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

    public <T> boolean create(Class<T> curClass, Map<String, String> params) {
        StringBuilder query = new StringBuilder().append("insert into ")
                .append(curClass.getSimpleName().toLowerCase()).append(" (");
        String[] keys = params.keySet().toArray(new String[0]);

        query.append(keys[0]);

        for(int i = 1; i < keys.length; i++)
            query.append(",").append(keys[i]);

        query.append(") values (");
        if(params.get(keys[0]).isEmpty() || params.get(keys[0])==null)
            query.append("NULL");
        else
            query.append("'").append(params.get(keys[0])).append("'");

        for(int i = 1; i < keys.length; i++)
        {
            if(params.get(keys[i]).isEmpty() || params.get(keys[i])==null || params.get(keys[i]).equals("NULL"))
                query.append(",").append("NULL");
            else
                query.append(",").append("'").append(params.get(keys[i])).append("'");
        }
        query.append(")");
        //System.out.println(query);
        return DoQueries.executeNonSelectQuery(query.toString());
    }

    public <T> List<T> readAll(Class<T> curClass, String where) {
        DoQueries.Mapper<T> mapper = rs -> {
            List<T> list = new ArrayList<>();
            final Field[] declaredFields = curClass.getDeclaredFields();
            for (Field f : declaredFields)
                f.setAccessible(true);
            while (rs.next()) {
                T test = curClass.getConstructor().newInstance();
                for (Field field : declaredFields) {
                    String name = field.getName();
                    try {
                        String value = rs.getString(name);
                        //if((value!="NULL")||(value!="null"))
                        //System.out.println(value);
                        if(value == null)
                            value = "-1";
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
        return DoQueries.executeSelectQuery("select * from " + className + where, mapper);
    }

    public <T> boolean update(Class<T> curClass, Long id, Map<String, String> params){
        //update + curClass + set + %all fields of an instance% + where id = + instance.id

        StringBuilder query = new StringBuilder().append("update ");
            query.append(curClass.getSimpleName().toLowerCase()).append(" set ");

        for(String key:params.keySet())
        {
            if(params.get(key)==null || params.get(key).isEmpty())
                query.append(key).append("=").append("NULL").append(", ");
            else
                query.append(key).append("=").append(params.get(key)).append(", ");
        }
        query.deleteCharAt(query.length()-2);
        query.append(" where id=").append(id);

        return DoQueries.executeNonSelectQuery(query.toString());
    }

    public boolean deleteById(String curClass, long id) {
        //code to delete 1 or more by id
        return DoQueries.executeNonSelectQuery("delete from " + curClass + " where id=" + id + ";");
    }
}
