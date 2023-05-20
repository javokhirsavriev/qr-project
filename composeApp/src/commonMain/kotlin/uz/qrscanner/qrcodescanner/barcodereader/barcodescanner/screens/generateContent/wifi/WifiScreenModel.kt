package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi

import kotlinx.coroutines.flow.update
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.BaseScreenModel


class WifiScreenModel : BaseScreenModel<WifiState, WifiEvent>(WifiState()) {

    override fun onEvent(event: WifiEvent) {
        when (event) {
            is WifiEvent.NetworkNameChanged -> onValueChanged(networkName = event.text)
            is WifiEvent.PasswordChanged -> onValueChanged(password = event.text)
        }
    }

    private fun onValueChanged(
        networkName: String? = null,
        password: String? = null
    ) {
        stateData.update {
            val newNetworkName = networkName ?: it.networkName
            val newPassword = password ?: it.password

            it.copy(
                networkName = newNetworkName,
                password = newPassword,
                isEnabled = newNetworkName.isNotEmpty() && newPassword.isNotEmpty()
            )
        }
    }

    fun getContent(): QrGenerateContent {
        return QrGenerateContent(
            qrContent = "WIFI:S:${state.value.networkName}" + ";P:" + state.value.password + ";;",
            formattedContent = state.value.networkName + "\n" + state.value.password
        )
    }
}