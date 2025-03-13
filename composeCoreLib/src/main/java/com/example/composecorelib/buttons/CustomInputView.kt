package com.example.composecorelib.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomInputView(
    title: String = "Title",
    value: String = "",
    placeholder: String = "Placeholder",
    description: String = "",
    errorMessage: String = "Error Message",
    onValueChange: (String) -> Unit
) {
    Surface(Modifier.wrapContentSize()) {
        Column(Modifier.fillMaxWidth()) {
            Text(
                title,
                Modifier.padding(20.dp, 10.dp),
                style = MaterialTheme.typography.titleSmall
            )
            if (errorMessage.isNotBlank()) {
                TextFieldView(placeholder) { onValueChange(it) }
            } else {
                TextFieldView(placeholder, true) { onValueChange(it) }
            }

            if (description.isNotBlank()) {
                Text(
                    description,
                    Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                )
            }
            if (errorMessage.isNotBlank()) {
                Text(
                    errorMessage,
                    Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
                    Color.Red
                )
            }
        }
    }
}

@Composable
fun TextFieldView(
    placeholder: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = "",
        isError = isError,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
            .fillMaxWidth(),
        placeholder = { Text(placeholder) },
        onValueChange = { onValueChange(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomInputView() {
    CustomInputView() {}
}