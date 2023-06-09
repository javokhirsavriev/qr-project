package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.NavigationType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppIcon
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppNavigationBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.AppTopBar
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components.SurfaceContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppIcons
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.base.UiEvent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.GenerateCodeScreen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.settings.SettingsScreen

@Composable
fun CategoriesContent(
    state: CategoriesState,
    sendEvent: (UiEvent) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = 100.dp,
                bottom = 120.dp
            ),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(state.categories) {
                GenerateItem(
                    type = it,
                    onClick = {
                        sendEvent(UiEvent.Navigate(GenerateCodeScreen(it)))
                    }
                )
            }
        }

        AppTopBar(
            title = AppStrings.generate_qr,
            trailingIcon = AppIcons.Settings,
            onTrailingIconClick = {
                sendEvent(UiEvent.Navigate(SettingsScreen))
            }
        )

        AppNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            currentNavigationType = NavigationType.Categories,
            sendEvent = sendEvent
        )
    }
}

@Composable
private fun GenerateItem(
    type: GenerateType,
    onClick: () -> Unit
) {
    SurfaceContent {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AppIcon(
                imageVector = type.icon,
                modifier = Modifier.size(30.dp)
            )

            Text(
                text = type.title,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }
}