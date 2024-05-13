package net.ezra.ui.getstarted


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MIT
import net.ezra.navigation.ROUTE_START
import net.ezra.ui.theme.AppTheme



@Composable
fun StartScreen(navController: NavHostController) {

    Box() {
//        Image(
//            painter = painterResource(id = R.drawable.back2),
//            contentDescription = "Background"
//        )
        LazyRow(
            Modifier
                .fillMaxSize()
                .padding(top = 100.dp, start = 30.dp)) {
            item {
                Column (Modifier.fillMaxSize()){
                Text(text = "Welcome to Alert", fontSize = 45.sp, fontFamily = FontFamily.Cursive)
                Spacer(modifier = Modifier.height(480.dp))
                Row (verticalAlignment = Alignment.Bottom){
                    OutlinedButton(onClick = {
                        navController.navigate(ROUTE_ABOUT) {
                            popUpTo(ROUTE_START) { inclusive = true }
                        }
                    }, modifier = Modifier
                        
                        .width(300.dp)

                    ) {
                                Text(text = "Get started", fontSize = 25.sp, fontFamily = FontFamily.Cursive)
                    }

                }

                }
            }
        }

    }








}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    StartScreen(rememberNavController())
}


