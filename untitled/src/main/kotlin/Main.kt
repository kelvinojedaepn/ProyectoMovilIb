import com.google.gson.Gson
import java.io.File
import java.lang.reflect.Array
import java.nio.file.Paths

fun main() {
    val jsonFile = JsonFile()
    val file = File("data.json")
    val listaCarros = ArrayList<Car>()
    listaCarros.add(Car(2, 123.45, false, "PBN123", 'P'))
     val user01 = User("Kelvin", 21, 19.98, true, 'S', listaCarros)

    val listaCarrosUser02 = ArrayList<Car>()
    listaCarrosUser02.add(Car(2, 1432.toDouble(), true, "PGB1123", 'P'))
    listaCarrosUser02.add(Car(3, 4444.toDouble(), false, "PGT1523", 'P'))
    val user02 = User("Juan", 13, 1243.toDouble(), true, 'C', listaCarrosUser02)
    val listOfUsers = ArrayList<User>()

//    listOfUsers.add(user01)
//    //val arregloDinamico: java.util.ArrayList<Int> = arrayListOf<Int>
//    listOfUsers.add(user02)
//    for(user in listOfUsers)
//        println(user.toString())
//    jsonFile.saveList(listOfUsers, file)
    val listOfUserFromJson = jsonFile.loadList(file)
    for(user in listOfUserFromJson)
        println(user.toString())

//    val listaJson: ArrayList<User> = jsonFile.loadList(file)
//    jsonFile.reloadData(user02, file)
//    println(user02)
//    val ListaJson= jsonFile.loadList(file)
//    for (user in ListaJson){
//        println(user)
//    }
    
//    val path = Paths.get("").toAbsolutePath().toString()
//    val gson = Gson()
//    val jsonData = gson.toJson(user01)
//    val file = File("data.json")
//    file.writeText(jsonData)
}
//private fun createJsonDataUser(user: User){
//    var json = JSObject()
//    json.setMember("name", user.name)
//    json.setMember("age", user.age)
//    json.setMember("salary", user.salary)
//    json.setMember("isMen", user.isMen)
//    json.setMember("estadoCivil", user.estadoCivil)
//    json.setMember("estadoCivil", user.estadoCivil)
//
//}

//private fun fistMsg(): String{
//    return "1.- Crear usuario\n" +
//            "2.- Modificar usuario\n" +
//            "3.- Eliminar usuario\n"
//}
//
//private fun selectOptionMsg(): String{
//    return "\tSeleccionar una opción: "
//}

