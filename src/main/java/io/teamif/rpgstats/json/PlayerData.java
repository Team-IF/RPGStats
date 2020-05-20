package io.teamif.rpgstats.json;

import com.google.gson.annotations.Since;
import io.teamif.rpgstats.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class PlayerData implements IJson {

    /**
     * String = 마인크래프트 UUID;
     * Player = 플레이어 데이터 객체
     */
    @Since(1.0)
    @Getter
    @Setter
    private Map<String, Player> datas;

    @Override
    public String getFileName() {
        return "PlayerData";
    }
}
