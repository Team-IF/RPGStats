package io.teamif.rpgstats.util.json.io

import io.teamif.rpgstats.util.json.PlayerData

class JsonIOManager {
    var playerData = PlayerData()
        internal set

    fun loadJsons() {
        playerData = JsonIOHandler.fileToJson(playerData)
    }

    fun saveJson() {
        JsonIOHandler.jsonToFile(playerData)
    }
}