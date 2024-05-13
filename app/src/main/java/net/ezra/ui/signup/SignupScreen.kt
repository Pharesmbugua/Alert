package net.ezra.ui.signup
import android.content.res.Configuration
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MIT
import net.ezra.navigation.ROUTE_REPORT
import net.ezra.navigation.ROUTE_START
import net.ezra.ui.theme.AppTheme
import java.util.jar.Attributes.Name


@Composable
fun SignupScreen(navController: NavHostController) {



    LazyColumn (
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .paint(painterResource(id = R.drawable.images), contentScale = ContentScale.FillBounds)
        , horizontalAlignment = Alignment.CenterHorizontally){
        item {
            Column (Modifier.padding()){
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(text = "Register with us", fontSize = 35.sp, fontFamily = FontFamily.Cursive, textAlign = TextAlign.Center,color = Color.White)
                }
                Spacer(modifier = Modifier.height(10.dp))
                var Name by remember {
                    mutableStateOf(TextFieldValue(""))
                }
                OutlinedTextField(
                    value = Name, onValueChange = { Name = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = "Enter your name") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Black,
                        focusedLeadingIconColor = Color.White,
                        unfocusedLeadingIconColor = Color.Black,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.White,
                        unfocusedPlaceholderColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black

                    )


                )
                Spacer(modifier = Modifier.height(20.dp))

                var Email by remember {
                    mutableStateOf(TextFieldValue(""))
                }
                OutlinedTextField(
                    value = Email, onValueChange = { Email = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = "Enter your Email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Black,
                        focusedLeadingIconColor = Color.White,
                        unfocusedLeadingIconColor = Color.Black,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.White,
                        unfocusedPlaceholderColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black

                    )


                )
                Spacer(modifier = Modifier.height(20.dp))

                var Phone by remember {
                    mutableStateOf(TextFieldValue(""))
                }
                OutlinedTextField(
                    value = Phone, onValueChange = { Phone = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = "Enter your Phone number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Black,
                        focusedLeadingIconColor = Color.White,
                        unfocusedLeadingIconColor = Color.Black,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.White,
                        unfocusedPlaceholderColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black

                    )


                )
                Spacer(modifier = Modifier.height(20.dp))

                var Password by remember {
                    mutableStateOf(TextFieldValue(""))
                }
                OutlinedTextField(
                    value = Password, onValueChange = { Password = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = "Choose your password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.Black,
                        focusedLeadingIconColor = Color.White,
                        unfocusedLeadingIconColor = Color.Black,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.Black,
                        focusedPlaceholderColor = Color.White,
                        unfocusedPlaceholderColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.Black

                    )


                )
                Spacer(modifier = Modifier.height(80.dp))
                OutlinedButton(onClick = {
                    navController.navigate(ROUTE_HOME) {
                        popUpTo(ROUTE_START) { inclusive = true }
                    }
                }, modifier = Modifier

                    .width(300.dp)

                ) {
                    Text(text = "Submit", fontSize = 35.sp, fontFamily = FontFamily.Cursive,color = Color.White)
                }



            }
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    SignupScreen(rememberNavController())
}
