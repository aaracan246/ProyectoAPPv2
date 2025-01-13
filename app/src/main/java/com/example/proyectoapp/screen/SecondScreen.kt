package com.example.proyectoapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectoapp.components.Header
import com.example.proyectoapp.components.PhasmoDivider
import com.example.proyectoapp.navigation.AppScreen
import com.example.proyectoapp.viewmodel.AppViewModel
import com.example.proyectoapp.R

@Composable
fun SecondScreen(navController: NavController, appViewModel: AppViewModel) {
    LoginScreen(navController, appViewModel)
}

@Composable
fun LoginScreen(navController: NavController, appViewModel: AppViewModel) {


    // Credenciales para comprobar el login:
    val validUsername = "Morri"
    val validPassword = "1234"

    // Estados para el ViewModel:
    val username by appViewModel.username.collectAsState()
    val password by appViewModel.password.collectAsState()
    val isChecked by appViewModel.isChecked.collectAsState()
    val isError by appViewModel.isError.collectAsState()


    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(R.color.fondo)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Header()

        Spacer(modifier = Modifier.padding(16.dp))

        PhasmoDivider()

        if (isError){
            ErrorAuthentication()
        }

        OutlinedTextField(
            value = username,
            onValueChange = { appViewModel.usernameUpdate(it) },
            label = { Text("User", modifier = Modifier.background(color = Color.Transparent)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = colorResource(R.color.white),
                focusedLabelColor = Color.White,
                focusedBorderColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedContainerColor = colorResource(R.color.white)
            )
        )

        Spacer(modifier = Modifier.padding(8.dp))



        OutlinedTextField(
            value = password,
            onValueChange = { appViewModel.passwordUpdate(it) },
            label = { Text("Password", modifier = Modifier.background(color = Color.Transparent)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = colorResource(R.color.white),
                focusedLabelColor = Color.White,
                focusedBorderColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedContainerColor = colorResource(R.color.white)


            ),
            visualTransformation = PasswordVisualTransformation()

        )

        Row {
            CheckboxFun(
                text = "Remember me?",
                isChecked = isChecked,
            ) { appViewModel.checkRememberMe() }

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text("¿Forgot your password?", modifier = Modifier
                    .clickable { }
                    .padding(top = 12.dp, end = 12.dp),
                    color = colorResource(R.color.white),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 12.sp)            }
        }
        Button(
            onClick = {
                if (username == validUsername && password == validPassword) {
                    if (!isChecked) {
                        appViewModel.usernameUpdate("")
                        appViewModel.passwordUpdate("")

                    }
                    appViewModel.changeErrorValue(false)
                    navController.navigate(route = AppScreen.ThirdScreen.route)

                } else {
                    appViewModel.usernameUpdate("")
                    appViewModel.passwordUpdate("")
                    appViewModel.changeErrorValue(true)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.white)
            )
        ) {
            Text("Log in", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.padding(top = 16.dp))

        HorizontalDivider(Modifier.padding(8.dp))

        Text(
            "No account yet?",
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 12.dp)
        )

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(1.dp, Color.White, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            )
        ) {
            Text("Sign in")
        }
    }
}


@Composable
fun CheckboxFun(text: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {

    Row(
        verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.White,
                checkedColor = Color.Red,
                checkmarkColor = Color.White
            )
        )
        Text(
            text = text,
            modifier = Modifier
                .padding(start = 6.dp),
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white),
            fontSize = 12.sp)
    }
}

@Composable
fun ErrorAuthentication(){
    Row {
        Text("Los datos de autenticación son erróneos.", color = Color.Red, modifier = Modifier.padding(8.dp))
    }
}