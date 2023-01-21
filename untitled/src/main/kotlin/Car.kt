data class Car(
    var doorNumber: Int,
    var mileage: Double,
    var isNew: Boolean = true,
    var carLicense: String,
    var beginCarLicense: Char,
    var ownerId: String = ""
) {
    fun changeMileage(mileageMod: Double){
        this.mileage = mileageMod
    }
    fun changeIsNew(){
        this.isNew = false
    }

    fun changeCarLicense(carLicenseMod: String) {
        this.carLicense = carLicenseMod
    }

    override fun toString(): String {
        return "Numero puertas: $doorNumber\n" +
                "Kilometros recorridos: $mileage\n" +
                "Es nuevo: $isNew\n" +
                "Licencia de carro: '$carLicense\n'" +
                "Inicial licencia de carro: ${carLicense.get(0)}\n"
    }


}