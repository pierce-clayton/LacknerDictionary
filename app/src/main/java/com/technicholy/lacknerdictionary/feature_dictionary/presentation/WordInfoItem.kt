package com.technicholy.lacknerdictionary.feature_dictionary.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.technicholy.lacknerdictionary.feature_dictionary.domain.models.WordInfo

@Composable
fun WordInfoItem(
    wordInfoItem: WordInfo,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = wordInfoItem.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = wordInfoItem.phonetic,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = wordInfoItem.origin
        )
        wordInfoItem.meanings.forEach { meaning ->
            Text(text = meaning.partOfSpeech, fontWeight = FontWeight.Bold)
            meaning.definitions.forEachIndexed { index, definition ->
                Text(
                    text = "${index + 1}. ${definition.definition}"
                )
                Spacer(modifier = Modifier.height(8.dp))
                definition.example?.let {
                    Text(text = "Example: $it")
                }
                Spacer(modifier = Modifier.height(8.dp))

            }
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}