package com.example.android_portfolio.features.about

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Header: Profile photo + name + title
        ProfileHeader()

        Spacer(modifier = Modifier.height(24.dp))

        // Areas of expertise
        SectionTitle("Areas of expertise")
        ExpertiseTags(
            listOf("Data Modelling", "Business Development", "Project Management")
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Additional experience
        SectionTitle("Additional experience")
        ExperienceList(
            items = listOf(
                ExperienceItem(
                    title = "Business Analyst",
                    company = "Arrow Group",
                    period = "March 2014 – June 2015"
                ),
                ExperienceItem(
                    title = "Project Manager",
                    company = "B1 Solutions",
                    period = "April 2012 – March 2014"
                )
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Education
        SectionTitle("Education")
        EducationList(
            items = listOf(
                EducationItem(
                    degree = "MSc in Business Analysis & Consulting",
                    institution = "University of Strathclyde, Glasgow",
                    year = "2010"
                )
            )
        )
    }
}

@Composable
private fun ProfileHeader() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        // Orange gradient background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            Color(0xFFFF8C42)
                        )
                    )
                )
        )

        // Circular avatar overlay
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            AsyncImage(
                model = "https://i.pravatar.cc/150?img=3", // placeholder — replace with real URL
                contentDescription = "Martin Davis profile picture",
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Martin Davis",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Business Analyst",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
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
                onClick = { /* Handle click if needed */ },
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
        // Vertical line (left margin)
        Box(
            modifier = Modifier
                .width(2.dp)
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
            painter = painterResource(id = R.drawable.ic_media_play), // placeholder dot
            contentDescription = null,
            modifier = Modifier.size(16.dp).padding(end = 8.dp),
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

// Data classes
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
