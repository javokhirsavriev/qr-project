package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.contact

data class ContactState(
    val firstName: String = "",
    val lastName: String = "",
    val phone: String = "",
    val email: String = "",
    val website: String = "",
    val address: String = "",
    val isEnabled: Boolean = false
)