package com.code.distancepincode.service;

import java.util.List;

public class GoogleMapsResponse {
    private List<Route> routes;




    public GoogleMapsResponse() {
    }

    public GoogleMapsResponse(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public static class Route {
        private List<Leg> legs;
        private String summary;

        public Route() {
        }

        public Route(List<Leg> legs, String summary) {
            this.legs = legs;
            this.summary = summary;
        }

        public List<Leg> getLegs() {
            return legs;
        }

        public void setLegs(List<Leg> legs) {
            this.legs = legs;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

    }

    public static class Leg {
        private Distance distance;
        private Duration duration;

        public Leg() {
        }

        public Leg(Distance distance, Duration duration) {
            this.distance = distance;
            this.duration = duration;
        }

        public Distance getDistance() {
            return distance;
        }

        public void setDistance(Distance distance) {
            this.distance = distance;
        }

        public Duration getDuration() {
            return duration;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }

    }

    public static class Distance {
        private String text;

        public Distance() {
        }

        public Distance(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

    public static class Duration {
        private String text;

        public Duration() {
        }

        public Duration(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }
}