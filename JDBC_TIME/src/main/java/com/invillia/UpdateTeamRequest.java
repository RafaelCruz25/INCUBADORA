package com.invillia;

public class UpdateTeamRequest {
    private String name;

    public UpdateTeamRequest(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
