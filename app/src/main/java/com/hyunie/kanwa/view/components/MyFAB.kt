package com.hyunie.kanwa.view.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hyunie.kanwa.model.controller.DataController
import com.hyunie.kanwa.model.entity.Kanwa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFAB() {
    val sheetState = rememberModalBottomSheetState()
    val isOpenSheet = remember { mutableStateOf(false) }
    val titleKanwa = remember { mutableStateOf("") }
    FloatingActionButton(onClick = { isOpenSheet.value = true }, shape = CircleShape) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            modifier = Modifier.size(35.dp)
        )
    }
    if (isOpenSheet.value) {
        ModalBottomSheet(
            onDismissRequest = { isOpenSheet.value = false },
            sheetState = sheetState
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 7.dp)
            ) {
                OutlinedTextField(
                    label = { Text("Title kanwa", style = MaterialTheme.typography.labelLarge) },
                    value = titleKanwa.value,
                    onValueChange = { newValue -> titleKanwa.value = newValue },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    DataController.user.lsKanwa.add(Kanwa(titleKanwa.value))
                    titleKanwa.value = ""
                    isOpenSheet.value = false
                }) {
                    Text(
                        "Add Kanwa",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}