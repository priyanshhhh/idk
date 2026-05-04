package com.storygrab.telegramdownloader.presentation.screens.paywall

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.storygrab.telegramdownloader.R

@Composable
fun PaywallScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.premium_title),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(32.dp))
        
        PremiumFeatureItem(
            icon = Icons.Default.Check,
            text = stringResource(R.string.unlimited_downloads)
        )
        PremiumFeatureItem(
            icon = Icons.Default.Check,
            text = stringResource(R.string.auto_check)
        )
        PremiumFeatureItem(
            icon = Icons.Default.Check,
            text = stringResource(R.string.no_ads)
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        Button(
            onClick = { /* Launch Billing Flow */ },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(stringResource(R.string.subscribe_now))
        }
    }
}

@Composable
fun PremiumFeatureItem(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
    }
}
