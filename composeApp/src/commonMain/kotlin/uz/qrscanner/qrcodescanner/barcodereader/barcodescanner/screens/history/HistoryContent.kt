package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppNavigationBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTopBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.UiEvent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings.SettingsScreen

@Composable
fun HistoryContent(
    state: HistoryState,
    sendEvent: (UiEvent) -> Unit
) {
    Box {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            AppTopBar(
                title = AppStrings.history,
                trailingIcon = AppIcons.Settings,
                onTrailingIconClick = {
                    sendEvent(UiEvent.Navigate(SettingsScreen))
                }
            )
        }

        AppNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            currentNavigationType = NavigationType.History,
            sendEvent = sendEvent
        )
    }
}