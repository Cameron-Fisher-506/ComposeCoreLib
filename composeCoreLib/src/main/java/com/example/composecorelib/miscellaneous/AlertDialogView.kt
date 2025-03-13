package com.example.composecorelib.miscellaneous

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogView(
    modifier: Modifier = Modifier,
    openDialog: Boolean = false,
    title: String = "",
    description: String = "",
    positiveButtonText: String = "POSITIVE",
    negativeButtonText: String = "NEGATIVE",
    onPositiveButtonClick: () -> Unit,
    onNegativeButtonClick: () -> Unit,
    onDismiss: () -> Unit
) {

    if (openDialog) {
        BasicAlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            modifier = modifier
        ) {
            Surface(
                modifier = modifier.wrapContentSize(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = modifier.padding(16.dp)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    DividerView()
                    Spacer(modifier = modifier.height(16.dp))
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = modifier.height(16.dp))
                    Row(
                        modifier = modifier
                            .padding(end = 16.dp)
                            .align(alignment = Alignment.End)
                    ) {
                        TextButton(
                            onClick = {
                                onDismiss()
                                onNegativeButtonClick()
                            }
                        ) {
                            Text(text = negativeButtonText)
                        }
                        TextButton(
                            onClick = {
                                onDismiss()
                                onPositiveButtonClick()
                            }
                        ) {
                            Text(text = positiveButtonText)
                        }
                    }
                }
            }
        }
    }
}