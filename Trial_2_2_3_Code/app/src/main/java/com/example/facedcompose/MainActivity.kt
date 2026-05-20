package com.example.facedcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.facedcompose.ui.AiDemoScreen
import com.example.facedcompose.ui.theme.FacedComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FacedComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AiDemoScreen(padding = innerPadding.calculateTopPadding())
                }
            }
        }
    }
}
