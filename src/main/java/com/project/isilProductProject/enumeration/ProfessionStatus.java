package com.project.isilProductProject.enumeration;

import lombok.Getter;

@Getter
public enum ProfessionStatus {
    DOCTOR(true), ENGINEER(true), NURSE(true), BAKER(false), DRIVER(false);

    //private final String professionStatus;
    private final boolean isAdvantaged;

    ProfessionStatus(boolean isAdvantaged) {
        // this.professionStatus = professionStatus;
        this.isAdvantaged = isAdvantaged;
    }
}
