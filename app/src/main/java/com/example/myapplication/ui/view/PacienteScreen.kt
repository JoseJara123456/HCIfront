package com.example.myapplication.ui.view



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.navigation.AppScreen
import com.example.myapplication.data.UserSession


import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PacienteScreen(navController: NavController) {
    val nombre = UserSession.nombre ?: "User"

    val (expanded, setExpanded) = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Bienvenida $nombre",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = { setExpanded(true) }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { setExpanded(false) }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Logout") },
                            onClick = {
                                navController.navigate(AppScreen.HomeScreen.route)
                                setExpanded(false)
                            }
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF085394))
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = " ",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        // Acción del primer botón
                    },
                    modifier = Modifier.weight(1f).padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF085394))
                ) {
                    Text("Realizar Cita")
                }

                Button(
                    onClick = {
                        // Acción del segundo botón
                    },
                    modifier = Modifier.weight(1f).padding(start = 8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF085394))
                ) {
                    Text("Mis Citas")
                }
            }


            Spacer(modifier = Modifier.height(50.dp))


            Button(
                onClick = {
                    // Acción del tercer botón
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF085394)),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Historial Clínico")
            }
        }
    }
}


@Preview
@Composable
fun PacienteScreenPreview() {
    MyApplicationTheme {
        val navController = rememberNavController()
        PacienteScreen(navController = navController)
    }
}