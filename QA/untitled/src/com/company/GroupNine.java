package com.company;

import java.util.List;

public class GroupNine {
    private List<String> groupMembers;

    public GroupNine(List<String> groupMembers) {

        this.groupMembers = groupMembers;
    }

    public Object getAll() {
        return this.groupMembers;
    }
}
