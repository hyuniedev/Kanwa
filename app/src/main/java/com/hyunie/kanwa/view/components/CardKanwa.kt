package com.hyunie.kanwa.view.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hyunie.kanwa.model.entity.Kanwa
import com.hyunie.kanwa.model.entity.Person

@Composable
fun CardKanwa(kanwa: Kanwa) {
    val kanwaState = remember { mutableStateOf(kanwa) }
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 18.dp)
            .sizeIn(minHeight = 100.dp, maxHeight = 350.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = kanwaState.value.completed,
                    onCheckedChange = { newValue ->
                        kanwaState.value = kanwaState.value.copy(completed = newValue)
                    }
                )
                Text(text = kanwaState.value.title, style = MaterialTheme.typography.labelLarge)
            }
            IconButton(onClick = {
                kanwaState.value = kanwaState.value.copy(
                    lsPerson = kanwaState.value.lsPerson + listOf(Person(name = "Person " + kanwaState.value.lsPerson.size))
                )
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add new Person")
            }
        }
        HorizontalDivider(thickness = 2.dp)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.sizeIn(maxHeight = 180.dp)
        ) {
            items(kanwaState.value.lsPerson.size) { index ->
                ItemCardKanwa(kanwaState.value.lsPerson[index])
            }
        }
        Column(modifier = Modifier.height(35.dp)) {
            HorizontalDivider(thickness = 2.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 7.dp)
            ) {
                Text(
                    text = "Total ${kanwaState.value.title}:",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = kanwaState.value.getTotalAmount().displayMoney(),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}
