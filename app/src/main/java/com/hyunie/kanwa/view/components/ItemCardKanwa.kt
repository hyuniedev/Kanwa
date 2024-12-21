package com.hyunie.kanwa.view.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hyunie.kanwa.model.entity.Person

@Composable
fun ItemCardKanwa(person: Person) {
    Card(
        onClick = {},
        modifier = Modifier
            .height(70.dp)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(10.dp))
    ) {
        Column(modifier = Modifier.padding(5.dp).fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Text(text = person.name, style = MaterialTheme.typography.labelLarge)
            HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(bottom = 3.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total:", style = MaterialTheme.typography.bodyLarge)
                Text(
                    person.money.displayMoney(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
