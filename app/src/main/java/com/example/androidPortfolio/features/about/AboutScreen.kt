package com.example.androidPortfolio.features.about

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        // Header: Profile photo + name + title
        ProfileHeader()

        Spacer(modifier = Modifier.height(24.dp))

        // Areas of expertise
        SectionTitle("Areas of expertise")
        ExpertiseTags(
            listOf("Android Development", "Jetpack Compose", "Kotlin", "Data Modelling", "System Architecture")
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Additional experience
        SectionTitle("Professional Experience")
        ExperienceList(
            items = listOf(
                ExperienceItem(
                    title = "Senior Android Developer",
                    company = "Mobile Tech Solutions",
                    period = "2020 – Present"
                ),
                ExperienceItem(
                    title = "Software Engineer",
                    company = "AppDev Studio",
                    period = "2017 – 2020"
                )
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Education
        SectionTitle("Education & Certifications")
        EducationList(
            items = listOf(
                EducationItem(
                    degree = "BSc in Computer Science",
                    institution = "University of Technology",
                    year = "2017"
                ),
                EducationItem(
                    degree = "Google Associate Android Developer",
                    institution = "Google Developers",
                    year = "2021"
                )
            )
        )
    }
}

@Composable
private fun ProfileHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        // Gradient background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.tertiary
                        )
                    )
                )
        )

        // Circular avatar overlay
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = "https://i.pravatar.cc/150?img=3",
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Android Developer",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Kotlin & Jetpack Compose Portfolio",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White.copy(alpha = 0.9f)),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun ExpertiseTags(tags: List<String>) {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tags.forEach { tag ->
            AssistChip(
                onClick = { },
                label = {
                    Text(text = tag, style = MaterialTheme.typography.labelMedium)
                }
            )
        }
    }
}

@Composable
private fun ExperienceList(items: List<ExperienceItem>) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items.forEach { item ->
            ExperienceItemCard(item)
        }
    }
}

@Composable
private fun ExperienceItemCard(item: ExperienceItem) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Vertical line
        Box(
            modifier = Modifier
                .width(3.dp)
                .height(48.dp)
                .background(MaterialTheme.colorScheme.primary)
                .align(Alignment.Top)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = item.company,
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )
            Text(
                text = item.period,
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )
        }
    }
}

@Composable
private fun EducationList(items: List<EducationItem>) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items.forEach { item ->
            EducationItemRow(item)
        }
    }
}

@Composable
private fun EducationItemRow(item: EducationItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.School,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Column {
            Text(
                text = item.degree,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
            )
            Text(
                text = "${item.institution}, ${item.year}",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )
        }
    }
}

data class ExperienceItem(
    val title: String,
    val company: String,
    val period: String
)

data class EducationItem(
    val degree: String,
    val institution: String,
    val year: String
)
