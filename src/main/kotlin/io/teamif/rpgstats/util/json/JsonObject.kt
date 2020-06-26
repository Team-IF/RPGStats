package io.teamif.rpgstats.util.json

/**
 * This class provides a Json-able object for this project.
 * Initializing and using this class directly is not allowed.
 *
 * After extending this object, it is recommended to add
 * the object to [io.teamif.rpgstats.util.json.io.JsonIOManager],
 * which manages the project's Json IO.
 */
abstract class JsonObject internal constructor() {
    open val fileName: String
        get() = throw UnsupportedOperationException()
}