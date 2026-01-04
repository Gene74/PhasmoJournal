package app.gene74.phasmojournal.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.gene74.phasmojournal.R
import app.gene74.phasmojournal.changeLog

@Composable
fun ChangesScreen(isDarkTheme: Boolean) {
    val uriHandler = LocalUriHandler.current
    val githubUrl = "https://github.com/Gene74/PhasmoJournal"
    val githubIcon = if (isDarkTheme) R.drawable.github_mark_white else R.drawable.github_mark

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween, // Push content to edges
            modifier = Modifier
                .fillMaxWidth() // Fill width to allow pushing to edges
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "Change Log:",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(id = githubIcon),
                contentDescription = "GitHub",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(32.dp) // Set a fixed, smaller size (adjust as needed)
                    .clickable { uriHandler.openUri(githubUrl) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(changeLog) { change ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = change.date,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(0.3f)
                    )
                    Text(
                        text = change.description,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(0.7f)
                    )
                }
            }
        }
    }
}