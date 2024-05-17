package parniyan.mahmoudroid.compose.network.util

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

/**
 ** Created by Parniyan on 5/10/2024.
 **
 */

object TypeConverter {
    val gson = Gson()

    inline fun <reified T> deserialize(string: String): T? {
        return runCatching { gson.fromJson(string, T::class.java) }.getOrNull()
    }

    inline fun <reified T> deserialize(jsonObject: JsonObject): T? {
        return runCatching { gson.fromJson(jsonObject, T::class.java) }.getOrNull()
    }
    inline fun <reified T> deserializeList(string: String): List<T>? {
        val itemType = object : TypeToken<List<T>>() {}.type
        return runCatching { gson.fromJson<List<T>>(string, itemType) }.getOrNull()
    }
}
