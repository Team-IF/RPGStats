package io.teamif.rpgstats.json;

import lombok.AccessLevel;
import lombok.Getter;

public class JsonManager {
    @Getter(AccessLevel.PUBLIC)
    private PlayerData _playerData;

    public void LoadJsons() {
        _playerData = JsonController.LoadJson(PlayerData.class);
    }
}
