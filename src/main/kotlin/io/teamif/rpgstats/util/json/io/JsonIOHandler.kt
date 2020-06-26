package io.teamif.rpgstats.util.json.io

import com.google.gson.GsonBuilder
import io.teamif.rpgstats.plugin.RPGStatsPlugin
import io.teamif.rpgstats.util.json.JsonObject
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.lang.reflect.Field
import java.lang.reflect.Modifier

object JsonIOHandler {
    private val GSON = GsonBuilder().setPrettyPrinting().create()
    internal val FOLDER = File(RPGStatsPlugin.instance.dataFolder, "data")

    /***
     * 객체를 Json 파일로 저장해준다.
     *
     * @param jsonObject 저장할 객체
     */
    fun jsonToFile(jsonObject: JsonObject) {
        var name = jsonObject.fileName
        if (!name.endsWith(".json")) name += ".json"
        try {
            FileWriter(File(FOLDER, name)).use { writer ->
                GSON.toJson(jsonObject, writer)
            }
        } catch (e: IOException) {
            val logger = RPGStatsPlugin.instance.logger
            logger.warning("Error occurred while saving json file: $name")
            e.printStackTrace()
        }
    }

    /**
     * T 객체에 해당하는 Json 파일을 로드하여 반환한다
     *
     * @param target 불러올 T 객체
     * @return Json에서 로드된 T 객체
     */
    fun <T : JsonObject> fileToJson(target: T): T {
        val field = target.javaClass.getDeclaredField("fileName")
        field.isAccessible = true

        val modifiersField = Field::class.java.getDeclaredField("modifiers")
        modifiersField.isAccessible = true
        modifiersField.setInt(field, field.modifiers and Modifier.FINAL.inv())

        var name = field.get(target) as String

        if (!name.endsWith(".json")) name += ".json"
        try {
            val file = File(FOLDER, name)
            if (file.exists()) {
                FileReader(file).use { reader ->
                    return GSON.fromJson(reader, target.javaClass)
                }
            }
        } catch (e: IOException) {
            RPGStatsPlugin.instance.logger.warning("Error occurred while loading Json file. FileName: $name")
            e.printStackTrace()
        }
        return target
    }
}