import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class JsonFile {
    private val gson = Gson()

    // Save data
    fun save(user: User, file: File){
        val jsonData = gson.toJson(user)
        file.writeText(jsonData)
    }

    // Load data
    fun load(file: File): User{
        val jsonData = file.readText()
        return gson.fromJson(jsonData, User::class.java)
    }

    // Save a list of user in JsonFile
    fun saveList(dataList: ArrayList<User>, file: File){
        val jsonData = gson.toJson(dataList)
        file.writeText(jsonData)
    }

    // Load a list if user from JsonFile
    fun loadList(file: File): ArrayList<User>{
        val jsonData = file.readText()
        val type = object: TypeToken<List<User>>(){}.type
        return gson.fromJson<ArrayList<User>>(jsonData, type)
        //return  Arrays.asList(gson.fromJson(jsonData, User.class))
    }
//    fun loadList(file: File): List<User> {
//        val jsonData = file.readText()
//        val type = object : TypeToken<List<User>>() {}.type
//        return gson.fromJson(jsonData, Array<User>::class.java).asList()
//    }

    //Reload a data in a existing json file
//    fun reloadData(user: User, file: File){
//        val jsonDataList: List<User> = loadList(file)
//        jsonDataList.add(user)
//        saveList(jsonDataList, file)
//    }
}