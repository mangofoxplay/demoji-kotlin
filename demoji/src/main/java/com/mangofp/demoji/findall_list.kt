package com.mangofp.demoji

import com.google.gson.Gson
import java.io.File

class findall_list(string: String, desc: Boolean){
    var returnedlist = _findall_list(string,desc)

}


fun main() {
//
//    val a = findall_list("OMG! 🥲😎🥲😈😘😊", false).returnedlist
//
//    println(a)
}


val _CODE_TO_DESC: Map<*,*> = _load_codes_from_file()
val _EMOJI_PAT = _compile_codes(_CODE_TO_DESC)

fun _load_codes_from_file(): Map<*,*>{
    val relativeFilePath = "demoji\\src\\codes.json" // Replace with your relative file path
    val file = File(relativeFilePath)
    val absolutePath = file.absolutePath

    val jsonString = File(absolutePath).readText()


    val jsonreturned = Gson().fromJson(jsonString, Map::class.java)

    return jsonreturned
}


fun _compile_codes(codes: Map<*, *>): Regex {
    val escapedCodes = codes.keys.sortedByDescending{ it.toString().length }.map{ Regex.escape(it.toString()) }
    return Regex(escapedCodes.joinToString("|"))
}




fun _findall_list(string: String, desc: Boolean):List<String> {
    val matches = _EMOJI_PAT.findAll(string).map{it.value}.toList()
    if (desc ==true) {
        return matches.map{ _CODE_TO_DESC[it].toString() }

    } else {
        return matches
    }

}











