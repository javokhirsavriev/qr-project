package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.datetime

import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.core.extensions.az

data class DateTimeModel(
    val dayOfMonth: Int = 1,
    val month: Int = 1,
    val monthName: String = "",
    val weekName: String = "",
    val year: Int = 2000,
    val hour: Int = 0,
    val minute: Int = 0,
    val second: Int = 0,
) {
    private val monthShortName = if (monthName.length >= 3) monthName.take(3) else monthName

    val defaultDateTime =
        "${dayOfMonth.az()} $monthShortName $year, ${hour.az()}:${minute.az()}" // dd MMM yyyy, HH:mm
    val defaultDate =
        "${dayOfMonth.az()} $monthShortName $year" // dd MMM yyyy, HH:mm
}