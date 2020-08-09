package ru.vsu.railroads.domain;

import java.util.Objects;

public class Route {
    private Long id, trainId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Route(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route item = (Route) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public String toString() {
        //res = ""
        //"Route #" + id + ", train_id " + train_id;
        // "Stations: "
        //for(String station: stations){
        //sys.out.print(station + ", ");}

        return "route, id=" + id;
    }
}
