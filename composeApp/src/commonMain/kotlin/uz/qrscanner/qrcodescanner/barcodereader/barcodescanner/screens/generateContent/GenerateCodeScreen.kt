package uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.GenerateType
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.data.model.QrGenerateContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generate.GenerateScreen
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.business.BusinessContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.business.BusinessScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.contact.ContactContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.contact.ContactScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.driverLicense.DriverLicenseContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.driverLicense.DriverLicenseScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.email.EmailContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.email.EmailScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.location.LocationContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.location.LocationScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone.PhoneContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.phone.PhoneScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.sms.SmsContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.sms.SmsScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.socialMedia.SocialMediaContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.socialMedia.SocialMediaScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.text.TextContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.text.TextScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.website.WebsiteContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.website.WebsiteScreenModel
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi.WifiContent
import uz.qrscanner.qrcodescanner.barcodereader.barcodescanner.screens.generateContent.wifi.WifiScreenModel

data class GenerateCodeScreen(
    val type: GenerateType
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        fun navigateToGenerate(content: QrGenerateContent) {
            navigator.push(GenerateScreen(content, type))
        }

        GenerateCodeContent(
            type = type,
            onNavigateUp = { navigator.pop() },
        ) {
            when (type) {
                GenerateType.Text -> {
                    val screenModel = rememberScreenModel { TextScreenModel() }
                    val state by screenModel.state.collectAsState()

                    TextContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Website -> {
                    val screenModel = rememberScreenModel { WebsiteScreenModel() }
                    val state by screenModel.state.collectAsState()

                    WebsiteContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Wifi -> {
                    val screenModel = rememberScreenModel { WifiScreenModel() }
                    val state by screenModel.state.collectAsState()

                    WifiContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Event -> {
                    Spacer(modifier = Modifier.height(56.dp))
                }

                GenerateType.Contact -> {
                    val screenModel = rememberScreenModel { ContactScreenModel() }
                    val state by screenModel.state.collectAsState()

                    ContactContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Business -> {
                    val screenModel = rememberScreenModel { BusinessScreenModel() }
                    val state by screenModel.state.collectAsState()

                    BusinessContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.DriverLicense -> {
                    val screenModel = rememberScreenModel { DriverLicenseScreenModel() }
                    val state by screenModel.state.collectAsState()

                    DriverLicenseContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Location -> {
                    val screenModel = rememberScreenModel { LocationScreenModel() }
                    val state by screenModel.state.collectAsState()

                    LocationContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Sms -> {
                    val screenModel = rememberScreenModel { SmsScreenModel() }
                    val state by screenModel.state.collectAsState()

                    SmsContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Email -> {
                    val screenModel = rememberScreenModel { EmailScreenModel() }
                    val state by screenModel.state.collectAsState()

                    EmailContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Phone,
                GenerateType.WhatsApp -> {
                    val screenModel = rememberScreenModel {
                        PhoneScreenModel(type == GenerateType.WhatsApp)
                    }
                    val state by screenModel.state.collectAsState()

                    PhoneContent(
                        state = state,
                        isWhatsApp = type == GenerateType.WhatsApp,
                        onEvent = screenModel::onEvent,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }

                GenerateType.Youtube,
                GenerateType.Instagram,
                GenerateType.Facebook,
                GenerateType.Twitter,
                GenerateType.TikTok,
                GenerateType.Telegram,
                GenerateType.Twitch,
                GenerateType.LinkedIn,
                GenerateType.Github -> {
                    val screenModel = rememberScreenModel { SocialMediaScreenModel(type) }
                    val state by screenModel.state.collectAsState()

                    SocialMediaContent(
                        state = state,
                        onEvent = screenModel::onEvent,
                        type = type,
                        onGenerate = {
                            navigateToGenerate(screenModel.getContent())
                        }
                    )
                }
            }
        }
    }
}