package net.ezra.ui.help

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MIT
import net.ezra.navigation.ROUTE_SERVICES
import net.ezra.R
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HELP
import net.ezra.navigation.ROUTE_PRODUCTS
import net.ezra.navigation.ROUTE_SHOP
import net.ezra.navigation.ROUTE_SIGNIN
import net.ezra.navigation.ROUTE_START

@Composable
fun HelpScreen(navController: NavHostController) {
Box(Modifier.size(800.dp,900.dp)) {
    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = "shop",contentScale = ContentScale.FillBounds, modifier = Modifier.size(900.dp,800.dp)
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
//            .wrapContentHeight()
//            .padding(10.dp)
            .padding(top = 1.dp)
            .background(Color.White)
            .paint(painterResource(id = R.drawable.images7), contentScale = ContentScale.FillBounds)

    ){
        val mContext = LocalContext.current
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "GET HELP", textAlign = TextAlign.Center, fontSize = 25.sp, fontFamily = FontFamily.Cursive,color = Color.White)
        }

       Spacer(modifier = Modifier.height(25.dp))

        Row {
            Column {

                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.firedep),
                            contentDescription ="koda",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(20.dp)
                                .clip(CircleShape)
                                .size(40.dp)
                        )
                        Column {
                            Button(onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0202222181".toUri()
                                mContext.startActivity(callIntent)
                            },
                                modifier = Modifier
                                    .size(width = 380.dp, height = 70.dp)
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp, top = 10.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(Color.LightGray)
                            ) {
                                Text(text = "NAIROBI FIRE FIGHTERS",color = Color.Black)
                                Spacer(modifier = Modifier.width(10.dp))
                                Icon(
                                    imageVector = Icons.Default.Call,
                                    contentDescription = "settings",
                                    tint = Color.Green
                                )
                            }

                        }

                    }

            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Column {

                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.redcross),
                            contentDescription ="koda",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(20.dp)
                                .clip(CircleShape)
                                .size(40.dp)
                        )
                        Column {
                            Button(onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:1199".toUri()
                                mContext.startActivity(callIntent)
                            },
                                modifier = Modifier
                                    .size(width = 380.dp, height = 70.dp)
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(Color.LightGray)
                            ) {
                                Text(text = "INFORM RED CROSS",color = Color.Black)
                                Spacer(modifier = Modifier.width(20.dp))
                                Icon(
                                    imageVector = Icons.Default.Call,
                                    contentDescription = "settings",
                                    tint = Color.Green
                                )
                            }

                        }

                    }

            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Column {

                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ambulance),
                            contentDescription ="koda",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(20.dp)
                                .clip(CircleShape)
                                .size(40.dp)
                        )
                        Column {
                            Button(onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0713582224".toUri()
                                mContext.startActivity(callIntent)
                            },
                                modifier = Modifier
                                    .size(width = 380.dp, height = 70.dp)
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(Color.LightGray)
                            ) {
                                Text(text = "CALL AN AMBULANCE",color= Color.Black)
                                Spacer(modifier = Modifier.width(10.dp))
                                Icon(
                                    imageVector = Icons.Default.Call,
                                    contentDescription = "settings",
                                    tint = Color.Green
                                )
                            }

                        }

                    }

            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Column {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.police),
                            contentDescription ="koda",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(20.dp)
                                .clip(CircleShape)
                                .size(40.dp)
                        )
                        Column {
                            OutlinedButton(onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:112".toUri()
                                mContext.startActivity(callIntent)
                            },
                                modifier = Modifier
                                    .size(width = 380.dp, height = 70.dp)
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(Color.LightGray)
                            ) {
                                Text(text = "INFORM POLICE", color = Color.Black, fontSize = 15.sp)
                                Spacer(modifier = Modifier.width(40.dp))
                                Icon(
                                    imageVector = Icons.Default.Call,
                                    contentDescription = "settings",
                                    tint = Color.Green
                                )

                            }

                        }

                    }

            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Column {


                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.amrefdoctors),
                            contentDescription ="koda",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(20.dp)
                                .clip(CircleShape)
                                .size(40.dp)
                        )
                        Column {
                            OutlinedButton(onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0730811811".toUri()
                                mContext.startActivity(callIntent)
                            },
                                modifier = Modifier
                                    .size(width = 380.dp, height = 70.dp)
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(Color.LightGray)
                            ) {
                                Text(text = "AMREF FLYING DOCTORS",color = Color.Black, fontSize = 13.sp)
                                Spacer(modifier = Modifier.width(10.dp))
                                Icon(
                                    imageVector = Icons.Default.Call,
                                    contentDescription = "settings",
                                    tint = Color.Green
                                )
                            }

                        }
                    }

            }
        }

        Spacer(modifier = Modifier.height(40.dp))


        Row(Modifier.padding(horizontal = 30.dp)) {
            OutlinedButton(onClick = {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_HELP) { inclusive = true }
                }
            }, modifier = Modifier
                .background(Color.Transparent)
                .width(300.dp)
                .padding(horizontal = 0.dp)


            ) {

                Text(text = "Home", fontSize = 30.sp, fontFamily = FontFamily.Cursive, color = Color.White)
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "settings",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )

            }
        }

















    }
}

}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HelpScreen(rememberNavController())
}

