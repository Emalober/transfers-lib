package com.example.transfers.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.example.transfers.domain.model.Contact
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.transfers.R

@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
    contact: Contact,
    showAvatar: Boolean = true
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ContactIcon(
                modifier = Modifier.size(48.dp, 48.dp),
                initials = "${contact.firstName[0]}${contact.lastName[0]}",
                imageUrl = if (showAvatar) contact.imageUrl else null
            )
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${contact.firstName} ${contact.lastName}",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = if (contact.isClient) FontWeight.Bold else FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview("default")
@Composable
private fun ContactCardPreview() {
        Column() {
            ContactCard(
                modifier = Modifier.fillMaxWidth(),
                contact = Contact(
                    firstName = "Julieta Daniela",
                    lastName = "Perez",
                    isClient = true
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            ContactCard(
                modifier = Modifier.fillMaxWidth(),
                contact = Contact(
                    firstName = "Manuel ",
                    lastName = "Martinez",
                    isClient = false
                )
            )
        }
}

@Composable
private fun ContactIcon(
    modifier: Modifier = Modifier,
    initials: String,
    imageUrl: String? = null
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.medium
            ),
        contentAlignment = Alignment.Center
    ) {
        if (imageUrl.isNullOrEmpty()) {
            Text(
                text = initials,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(1.dp)
            )
        } else {
            Image(
                painter = rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        crossfade(true)
                        placeholder(drawableResId = R.drawable.avartar)
                    }
                ),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1.0f)
                    .size(56.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}
