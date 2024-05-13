package net.ezra.ui.about

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HELP
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_MIT
import net.ezra.navigation.ROUTE_REGISTER
import net.ezra.navigation.ROUTE_SIGNIN
import net.ezra.navigation.ROUTE_SIGNUP
import net.ezra.navigation.ROUTE_START
import net.ezra.ui.theme.AppTheme



@Composable
fun AboutScreen(navController: NavHostController) {
    LazyColumn (
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .paint(painterResource(id = R.drawable.logo1), contentScale = ContentScale.FillBounds)
    ){
        item {
            Column (Modifier.padding(horizontal = 20.dp, vertical = 20.dp)){
                Text(text = "As a result of the frequent accidents occurring on our roads,this application was designed to help curb this ",
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Cursive,
                color = Color.White)
                Spacer(modifier = Modifier.height(470.dp))
                Row (Modifier.padding(horizontal = 20.dp)){
                        OutlinedButton(onClick = {
                            navController.navigate(ROUTE_SIGNIN) {
                                popUpTo(ROUTE_START) { inclusive = true }
                            }
                        }, modifier = Modifier
                            .background(Color.Transparent)
                            .width(300.dp)

                        ) {
                            Text(text = "Sign In", fontSize = 25.sp, fontFamily = FontFamily.Cursive,color= Color.White)
                        }
//                    Spacer(modifier = Modifier.width(10.dp))
//                    OutlinedButton(onClick = {
//                        navController.navigate(ROUTE_HELP) {
//                            popUpTo(ROUTE_START) { inclusive = true }
//                        }
//                    }, modifier = Modifier
//                        .background(Color.Transparent)
//                        .width(150.dp)
//
//                    ) {
//                        Text(text = "Exit", fontSize = 25.sp, fontFamily = FontFamily.Cursive,color = Color.White)
//                        Spacer(modifier = Modifier.width(10.dp))
//                        Icon(
//                            imageVector = Icons.Default.ExitToApp,
//                            contentDescription = "settings",
//                            tint = Color.White
//                        )
//                    }


                }
                Spacer(modifier = Modifier.height(9.dp))
                Column(Modifier.padding(horizontal = 90.dp)) {
                    Text(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(ROUTE_ABOUT) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },
                        text = "Forgot password?", fontSize = 15.sp,color= Color.Cyan)
                }
                Spacer(modifier = Modifier.height(9.dp))
                    Row (Modifier.padding(horizontal = 50.dp)){
                        Text(text = "Don't have any account?", fontSize = 15.sp,color = Color.White)
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(ROUTE_SIGNUP) {
                                        popUpTo(ROUTE_ABOUT) { inclusive = true }
                                    }
                                },
                            text = "Sign up", fontSize = 15.sp,color = Color.Cyan
                        )
                    }
                }
            }
        }
    }








@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AboutScreen(rememberNavController())
}

