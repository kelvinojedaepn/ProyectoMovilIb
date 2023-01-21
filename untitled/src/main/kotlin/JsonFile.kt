import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import kotlin.collections.ArrayList

class JsonFile {
    private val gson = Gson()


    // Save a list of user in JsonFile
    fun saveList(dataList: ArrayList<User>, file: File) {
        val jsonData = gson.toJson(dataList)
        file.writeText(jsonData)
    }

    // Load a list if user from JsonFile
    fun loadList(file: File): ArrayList<User> {
        val jsonData = file.readText()
        val type = object : TypeToken<List<User>>() {}.type
        try {
            return gson.fromJson<ArrayList<User>>(jsonData, type)
        } catch (e: NullPointerException) {
            return ArrayList()
        }

    }

    fun isUserInFile(id: String, file: File): Boolean {
        val listOfUsers: ArrayList<User> = loadList(file)
        var user: User? = null
        var isFind = false
        for (userList: User in listOfUsers) {
            if (userList.id == id) {
                isFind = true
            }
        }
        return isFind

    }

    fun insertUser(user: User, file: File) {
        val listOfUsers: ArrayList<User> = loadList(file)
        if (!isUserInFile(user.id, file)) {
            listOfUsers.add(user)
            saveList(listOfUsers, file)
        }
    }

    fun getAllUser(file: File): ArrayList<User> {
        return loadList(file)
    }

    fun getUserById(id: String, file: File): User? {
        val listOfUsers = loadList(file)
        var user: User? = null
        for (userList: User in listOfUsers) {
            if (userList.id == id) {
                user = userList
                break
            }
        }

        return user;
    }



    fun updateUser(user: User, file: File): Boolean {
        val listOfUsers: ArrayList<User> = loadList(file)
        var userFind: User? = null
        var isUpdate: Boolean = false
        if (isUserInFile(user.id, file)) {
            userFind = getUserById(user.id, file)
            if (userFind != null) {
                listOfUsers.remove(userFind)
                listOfUsers.add(user)
                saveList(listOfUsers, file)
                isUpdate = true
            } else {
                isUpdate = false
            }
        }
        return isUpdate
    }

    fun removeUser(user: User, file: File): Boolean {
        val listOfUsers = loadList(file)
        var isRemove = false
        if (isUserInFile(user.id, file)) {
            listOfUsers.remove(user)
            saveList(listOfUsers, file)
            isRemove = true
        }
        return isRemove
    }

    fun removeUserById(id: String, file: File): Boolean {
        val listOfUser: ArrayList<User> = loadList(file)
        var isRemove = false
        if (isUserInFile(id, file)) {
            val user: User? = getUserById(id, file)
            listOfUser.remove(user)
            isRemove = true
            saveList(listOfUser, file)
        }

        return isRemove
    }

    fun getListOfCarByUserId(id: String, file: File): ArrayList<Car> {
        val listOfUsers = loadList(file)
        var listOfCars: ArrayList<Car> = ArrayList()
        for (userList: User in listOfUsers) {
            if (userList.id == id) {
                listOfCars = userList.listOfCars
                break
            }
        }
        return listOfCars
    }

    fun getCarByLicense(user: User,license: String, file: File): Car?{
        val listOfCars = getListOfCarByUserId(user.id, file)
        var carReturn: Car? = null
        for (car: Car in listOfCars){
            if( car.carLicense == license ) {
                carReturn = car
                break
            }

        }
        return carReturn
    }

    fun updateCarByLicense(user: User, car: Car, file: File) {
        var isUpdate = false
        val listOfCars = getListOfCarByUserId(user.id, file)
        val carFinding = getCarByLicense(user, car.carLicense, file)
        listOfCars.remove(carFinding)
        listOfCars.add(car)
        user.listOfCars = listOfCars
        updateUser(user, file)
    }






}