package ru.vsu.railroads.domain;

import java.util.Objects;

public class Train {

    private Long id, routeId;

    public Train() {
    }

    public Train(Long id) {
        this.id = id;
    }

    public Train(Long id, Long routeId) {
        this.id = id;
        this.routeId = routeId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        Train item = (Train) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public String toString() {
        return "train, id=" + id;
    }
}
