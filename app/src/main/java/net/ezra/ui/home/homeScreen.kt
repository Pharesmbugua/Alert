package net.ezra.ui.home
import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MIT
import net.ezra.navigation.ROUTE_SERVICES
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_EVENING
import net.ezra.navigation.ROUTE_PRODUCTS
import net.ezra.navigation.ROUTE_SHOP
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import net.ezra.R
import net.ezra.R.*
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_HELP
import net.ezra.navigation.ROUTE_ALERT
import net.ezra.navigation.ROUTE_REPORT
import net.ezra.navigation.ROUTE_SIGNIN
import net.ezra.navigation.ROUTE_START
import net.ezra.navigation.ROUTE_VIEW
import net.ezra.navigation.ROUTE_VIEW_INCIDENT


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(navController: NavHostController) {



    LazyColumn(
        Modifier
            .paint(painterResource(id = R.drawable.back), contentScale = ContentScale.FillBounds)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                val mContext = LocalContext.current
                TopAppBar(
                    title = { Text(text = "Log out", color = Color.White, fontSize = 20.sp) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Transparent),
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "settings",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                navController.navigate(ROUTE_ABOUT) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                } }.size(30.dp)
                        )
                    },
                    actions = {

                        IconButton(onClick = {
                            val settingsIntent = Intent(Settings.ACTION_SETTINGS)
                            mContext.startActivity(settingsIntent)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "settings",
                                tint = Color.White
                            )
                        }

                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                Card (modifier = Modifier
                    .size(250.dp, 150.dp)
                    .background(Color.Transparent),
                  RoundedCornerShape(25),CardDefaults.cardColors(Color.Transparent)
                ){

                    Box(

                        Modifier
                            .paint(
                                painterResource(id = R.drawable.images),
                                contentScale = ContentScale.FillBounds
                            )
                            .size(250.dp, 150.dp)
                            .background(Color.Black), contentAlignment = Alignment.Center

                    )
                    {
                        Column {
                            Text(text = "Welcome to",color = Color.White, fontSize = 20.sp, modifier = Modifier.padding(horizontal = 20.dp))
                            Spacer(modifier = Modifier.height(30.dp))
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Warning,
                                    contentDescription = "settings",
                                    tint = Color.Red,
                                    modifier = Modifier.size(43.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = "Alert",color = Color.White, fontSize = 40.sp)
                            }

                        }




                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
                Card (modifier = Modifier
                    .size(300.dp, 48.dp)
                    .background(Color.Transparent),
                    RoundedCornerShape(60),CardDefaults.cardColors(Color.Transparent)){
                    Box (
                        Modifier
                            .size(350.dp, 80.dp)
                            .background(Color.Black), contentAlignment = Alignment.Center)
                    {
                        OutlinedButton(onClick = {
                            navController.navigate(ROUTE_VIEW) {
                                popUpTo(ROUTE_HOME) { inclusive = true }
                            }
                        }, modifier = Modifier
                            .background(Color.Transparent)
                            .width(300.dp)

                        ) {
                            Text(text = "Updates", fontSize = 25.sp, fontFamily = FontFamily.Cursive,color = Color.White)
                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "updates",
                                tint = Color.Cyan
                            )
                        }



                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Card (modifier = Modifier
                    .size(300.dp, 48.dp)
                    .background(Color.Transparent),
                    RoundedCornerShape(60),CardDefaults.cardColors(Color.Transparent)){
                    Box (
                        Modifier
                            .size(350.dp, 80.dp)
                            .background(Color.Black), contentAlignment = Alignment.Center)
                    {
                        OutlinedButton(onClick = {
                            navController.navigate(ROUTE_REPORT) {
                                popUpTo(ROUTE_HOME) { inclusive = true }
                            }
                        }, modifier = Modifier
                            .background(Color.Transparent)
                            .width(300.dp)

                        ) {
                            Text(text = "Report", fontSize = 25.sp,
                                fontFamily = FontFamily.Cursive,color = Color.White)


                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = "reports",
                                tint = Color.Red
                            )
                        }



                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Card (modifier = Modifier
                    .size(300.dp, 48.dp)
                    .background(Color.Transparent),
                    RoundedCornerShape(60),CardDefaults.cardColors(Color.Transparent)){
                    Box (
                        Modifier
                            .size(350.dp, 80.dp)
                            .background(Color.Black), contentAlignment = Alignment.Center)
                    {
                        OutlinedButton(onClick = {
                            navController.navigate(ROUTE_HELP) {
                                popUpTo(ROUTE_HOME) { inclusive = true }
                            }
                        }, modifier = Modifier
                            .background(Color.Transparent)
                            .width(300.dp)

                        ) {
                            Text(text = "Call for help", fontSize = 25.sp, fontFamily = FontFamily.Cursive,color = Color.White)
                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "help",
                                tint = Color.Green
                            )
                        }



                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Card (modifier = Modifier
                    .size(300.dp, 48.dp)
                    .background(Color.Transparent),
                    RoundedCornerShape(60),CardDefaults.cardColors(Color.Transparent)
                ){
//                    Box (
//                        Modifier
//                            .size(350.dp, 48.dp)
//                            .background(Color.Black), contentAlignment = Alignment.Center)
//                    {
//
//
//
//
//                    }
                }








            }




            }
        }




@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    homeScreen(rememberNavController())
}


