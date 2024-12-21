package com.hyunie.kanwa.view.components

import android.widget.GridView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hyunie.kanwa.model.entity.KanwaCard
import com.hyunie.kanwa.ui.theme.KanwaTheme

@Composable
fun CardKanwa() {
    var kanwaCard: KanwaCard = KanwaCard("Cost Camping")
    Card(onClick = {}, modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = false, onCheckedChange = {})
            Text(text = kanwaCard.title, style = MaterialTheme.typography.labelLarge)
        }
        HorizontalDivider(thickness = 2.dp)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(kanwaCard.lsPerson.size + 1) { index ->
                if (index == kanwaCard.lsPerson.size) {
                    Card(
                        onClick = {},
                        colors = CardDefaults.cardColors().copy(containerColor = Color.Green),
                        modifier = Modifier.height(70.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add new Person",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                } else {
                    ItemCardKanwa(kanwaCard.lsPerson[index])
                }
            }
        }
        HorizontalDivider(thickness = 2.dp)
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 7.dp)) {
            Text(text = "Total ${kanwaCard.title}:", style = MaterialTheme.typography.labelLarge)
            Text(text = kanwaCard.getTotalAmount().displayMoney(), style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardKanwaPreview() {
    KanwaTheme {
        CardKanwa()
    }
}