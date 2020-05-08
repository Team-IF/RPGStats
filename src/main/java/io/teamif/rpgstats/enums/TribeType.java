package io.teamif.rpgstats.enums;

import lombok.AccessLevel;
import lombok.Getter;

public enum TribeType {
    Human("인간"),
    Jinn("정령"),
    Demon("마인"),
    Monster("마물");

    @Getter(AccessLevel.PUBLIC)
    private String tribeName;

    TribeType(String tribeName) {
        this.tribeName = tribeName;
    }
}
