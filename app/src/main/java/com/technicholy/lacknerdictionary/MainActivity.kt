package com.technicholy.lacknerdictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.technicholy.lacknerdictionary.feature_dictionary.presentation.WordInfoItem
import com.technicholy.lacknerdictionary.feature_dictionary.presentation.WordInfoViewModel
import com.technicholy.lacknerdictionary.ui.theme.LacknerDictionaryTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LacknerDictionaryTheme {
                val viewModel: WordInfoViewModel = hiltViewModel()
                val state = viewModel.state.value
                val scaffoldState = rememberScaffoldState()

                LaunchedEffect(key1 = true, block = {
                    viewModel.eventFlow.collectLatest {
                        when (it) {
                            is WordInfoViewModel.UIEvent.ShowSnackbar -> {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = it.message
                                )
                            }
                        }
                    }
                })
                Scaffold(
                    scaffoldState = scaffoldState
                ) {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            TextField(
                                value = viewModel.searchQuery.value,
                                onValueChange = viewModel::onSearch,
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Search...")
                                }
                            )
                            Spacer(Modifier.height(16.dp))
                            LazyColumn(modifier = Modifier.fillMaxSize()){
                                items(state.wordInfoItems.size){ i ->
                                    val wordInfo = state.wordInfoItems[i]
                                    if(i>0){
                                        Spacer(
                                            Modifier.height(8.dp)
                                        )
                                    }
                                    WordInfoItem( wordInfoItem = wordInfo)
                                    if (i < state.wordInfoItems.size -1){
                                        Divider()
                                    }

                                }
                            }
                        }

                        }
                    }

                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        LacknerDictionaryTheme {
            Greeting("Clay")
        }
    }