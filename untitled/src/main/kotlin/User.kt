data class User(
    val name: String = "No  name",
    val age: Int = 0,
    val salary: Double = 0.0,
    val isMen: Boolean,
    val estadoCivil: Char = 'S',
    var listaCarros: ArrayList<Car>
) {

    public fun addCar(car: Car) {
        this.listaCarros.add(car)
    }

    override fun toString(): String {
        return "User(name='$name', age=$age, salary=$salary, isMen=$isMen, estadoCivil=$estadoCivil, listaCarros=$listaCarros)"

    }


}