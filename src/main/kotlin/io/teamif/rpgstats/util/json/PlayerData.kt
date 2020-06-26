package io.teamif.rpgstats.util.json

import io.teamif.rpgstats.player.Player
import java.io.Serializable

class PlayerData : JsonObject(), Serializable {
    internal val data: HashMap<String, Player> = HashMap()

    override val fileName = "PlayerData"
}