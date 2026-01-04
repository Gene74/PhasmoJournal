package app.gene74.phasmojournal.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title: String,
    isDarkTheme: Boolean,
    onThemeChange: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars) // Add padding for the status bar
            .padding(16.dp) // Keep original padding for aesthetics
    ) {
        val themeIcon = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode
        val themeContentDescription = if (isDarkTheme) "Switch to Light Mode" else "Switch to Dark Mode"

        Icon(
            imageVector = themeIcon,
            contentDescription = themeContentDescription,
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable { onThemeChange() }
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}