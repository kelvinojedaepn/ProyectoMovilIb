public class Car(
    val doorNumber: Int,
    var mileage: Double,
    var isNew: Boolean = true,
    var carLicense: String,
    var beginCarLicense: Char
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
        return "Car(doorNumber=$doorNumber, mileage=$mileage, isNew=$isNew, carLicense='$carLicense', beginCarLicense=$beginCarLicense)"
    }


}