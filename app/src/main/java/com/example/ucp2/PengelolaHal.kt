@file:OptIn(ExperimentalMaterial3Api::class,ExperimentalMaterial3Api::class)

package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class PengelolaHal {
    Home
}
@Composable
fun UCP2AppBar(
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (bisaNavigasiBack) {
                IconButton(onClick = navigasiUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.btn_next)
                    )
                }
            }
        }
    )
}
@Composable
fun UCP2App(
    viewModel: ViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(

    ) { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHal.Home.name,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(route = PengelolaHal.Home.name) {
                HalamanHome(
                    onNextButtonClicked = { navController.navigate(PengelolaHal.Home.name) })
            }
        }
    }
}