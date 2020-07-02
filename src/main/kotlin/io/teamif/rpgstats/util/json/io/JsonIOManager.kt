package io.teamif.rpgstats.util.json.io

import io.teamif.rpgstats.util.json.PlayerData

internal class JsonIOManager {
    var playerData = PlayerData()
        private set

    fun loadJsons() {
        playerData = JsonIOHandler.fileToJson(playerData)
    }

    fun saveJson() {
        JsonIOHandler.jsonToFile(playerData)
    }
}