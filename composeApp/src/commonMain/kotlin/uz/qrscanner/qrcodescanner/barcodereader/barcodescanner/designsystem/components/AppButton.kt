package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.designsystem.resources.AppStrings

@Composable
fun AppFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    containerColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = MaterialTheme.colors.onPrimary,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.button,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = AppButtonDefaults.NormalButtonHeight),
        enabled = isEnabled && !isLoading,
        colors = AppButtonDefaults.filledButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(horizontal = 20.dp),
        content = {
            ProvideTextStyle(value = textStyle) {
                Text(text = if (isLoading) AppStrings.loading else text)
            }
        }
    )
}

@Composable
fun AppTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    containerColor: Color = Color.Transparent,
    contentColor: Color = MaterialTheme.colors.onBackground,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.button,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
            .heightIn(min = AppButtonDefaults.NormalButtonHeight),
        enabled = isEnabled && !isLoading,
        colors = AppButtonDefaults.filledButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(horizontal = 20.dp),
        content = {
            ProvideTextStyle(value = textStyle) {
                Text(text = if (isLoading) AppStrings.loading else text)
            }
        }
    )
}

object AppButtonDefaults {

    val NormalButtonHeight = 48.dp
    private const val DisabledButtonContainerAlpha = 0.12f
    private const val DisabledButtonContentAlpha = 0.38f

    @Composable
    fun filledButtonColors(
        containerColor: Color = MaterialTheme.colors.onBackground,
        contentColor: Color = MaterialTheme.colors.onPrimary
    ) = ButtonDefaults.buttonColors(
        backgroundColor = containerColor,
        contentColor = contentColor,
        disabledBackgroundColor = MaterialTheme.colors.onBackground.copy(
            alpha = DisabledButtonContainerAlpha
        ),
        disabledContentColor = MaterialTheme.colors.onBackground.copy(
            alpha = DisabledButtonContentAlpha
        )
    )
}