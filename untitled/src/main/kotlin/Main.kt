import com.google.gson.Gson
import java.io.File
import java.nio.file.Paths

fun main() {
    val listaCarros = ArrayList<Car>()
    listaCarros.add(Car(2, 123.45, false, "PBN123", 'P'))
     val user01 = User("Kelvin", 21, 19.98, true, 'S', listaCarros)

    println(user01)
//    val path = Paths.get("").toAbsolutePath().toString()
    val gson = Gson()
    val jsonData = gson.toJson(user01)
    val file = File("data.json")
    file.writeText(jsonData)
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

