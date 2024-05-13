@file:Suppress("NAME_SHADOWING")

package net.ezra.ui.students



import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.Firebase


import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT

import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_HOME
import java.lang.reflect.Modifier
import java.util.UUID


var progressDialog: ProgressDialog? = null
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(navController: NavHostController) {
    val context = LocalContext.current


    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Report")
                },
                navigationIcon = {
                    IconButton(onClick = {


                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_ADD_STUDENTS) { inclusive = true }
                        }


                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon", tint = Color.White)
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White,

                    )
            )
        }, content = {
            Column(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize()
                    .background(Color.Gray),
//                    .paint(painterResource(id = R.drawable.images7), contentScale = ContentScale.FillBounds),
                verticalArrangement = Arrangement.Center,
            ) {
                LazyColumn {
                    item {
                        Column(







                            horizontalAlignment = Alignment.CenterHorizontally
                        ){

                            Card (


                            ){

                            }

                            Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))


                            var photoUri: Uri? by remember { mutableStateOf(null) }
                            val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                                photoUri = uri
                            }

                            var studentName by rememberSaveable {
                                mutableStateOf("")
                            }

                            var studentClass by rememberSaveable {
                                mutableStateOf("")
                            }

                            var studentEmail by rememberSaveable {
                                mutableStateOf("")
                            }

                            var location by rememberSaveable {
                                mutableStateOf("")
                            }

                            var phone by rememberSaveable {
                                mutableStateOf("")
                            }



                            OutlinedTextField(
                                value = studentName,
                                onValueChange = { studentName = it },
                                label = { Text(text = "Name") },
                                modifier = androidx.compose.ui.Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = phone,
                                onValueChange = { phone = it },
                                label = { Text(text = "Location of incident") },
                                modifier = androidx.compose.ui.Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = location,
                                onValueChange = { location = it },
                                label = { Text(text = "Date of report") },
                                modifier = androidx.compose.ui.Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

//                            OutlinedTextField(
//                                value = studentEmail,
//                                onValueChange = { studentEmail = it },
//                                label = { Text(text = "Email") },
//                                modifier = androidx.compose.ui.Modifier
//                                    .padding(16.dp)
//                                    .fillMaxWidth()
//                            )

//                            OutlinedTextField(
//                                value = studentClass,
//                                onValueChange = { studentClass= it },
//                                label = { Text(text = "Class") },
//                                modifier = androidx.compose.ui.Modifier
//                                    .padding(16.dp)
//                                    .fillMaxWidth()
//                            )





                            if (photoUri != null) {
                                //Use Coil to display the selected image
                                val painter = rememberAsyncImagePainter(
                                    ImageRequest
                                        .Builder(LocalContext.current)
                                        .data(data = photoUri)
                                        .build()
                                )

                                Image(
                                    painter = painter,
                                    contentDescription = null,
                                    modifier = androidx.compose.ui.Modifier
                                        .padding(5.dp)
                                        .width(150.dp)
                                        .height(150.dp)
                                        .border(1.dp, Color.Gray),
                                    contentScale = ContentScale.Crop,

                                    )
                            } else {

                                OutlinedButton(
                                    onClick = {
                                        launcher.launch(
                                            PickVisualMediaRequest(
                                                //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                                                //Or use .VideoOnly if you only want videos.
                                                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                            )
                                        )
                                    }
                                ) {
                                    Text(text = "Upload image",color = Color.Black)
                                }
                            }


                            OutlinedButton(onClick = {

                                if (photoUri != null) {

                                    progressDialog = ProgressDialog(context)
                                    progressDialog?.setMessage("Uploading data...")
                                    progressDialog?.setCancelable(false)
                                    progressDialog?.show()

                                    photoUri?.let {

                                        uploadImageToFirebaseStorage(
                                            it,
                                            studentName,
                                            studentClass,
                                            studentEmail,
                                            location,
                                            phone,
                                            context

                                        )

                                        studentName = ""
                                        studentClass = ""
                                        studentEmail = ""
                                        location = ""
                                        phone = ""
                                        photoUri = null

                                    }
                                } else if (phone == ""){

                                    Toast.makeText(context, "Please enter location", Toast.LENGTH_SHORT).show()
                                }
                                else if (location == ""){
                                    Toast.makeText(context, "Please enter date", Toast.LENGTH_SHORT).show()
                                }
                                else if(studentName == ""){
                                    Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show()
                                }

                                else {
                                    Toast.makeText(context, "Please select an image", Toast.LENGTH_SHORT).show()
                                }



                            }) {

                                Text(text = "Report",color = Color.Black)


                            }











                        }
                    }
                }
            }

        })



}



fun uploadImageToFirebaseStorage(
    imageUri: Uri,
    studentName: String,
    studentClass: String,
    studentEmail: String,
    location: String,
    phone: String,
    context: Context

) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(
                downloadUri.toString(),
                studentName,
                studentClass,
                studentEmail,
                location,
                phone,
                context,


                )

        } else {

            progressDialog?.dismiss()

            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Failed to upload report: ${task.exception?.message}")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked

                }
                .show()


        }
    }
}


fun saveToFirestore(
    imageUrl: String,
    studentName: String,
    studentClass: String,
    studentEmail: String,
    location: String,
    phone: String,
    context: Context,



    ) {


    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "studentName" to studentName,
        "studentClass" to studentClass,
        "studentEmail" to studentEmail,
        "location" to location,
        "phone" to phone



    )


    db.collection("Students")
        .add(imageInfo)
        .addOnSuccessListener { documentReference ->

            progressDialog?.dismiss()

            // Show success dialog
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setTitle("Success")
                .setMessage("Report is submitted!")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked
                }

                .setCancelable(false)

            val alertDialog = dialogBuilder.create()
            alertDialog.show()

            // Customize the dialog style (optional)
            val alertDialogStyle = alertDialog.window?.attributes
            alertDialog.window?.attributes = alertDialogStyle
        }
        .addOnFailureListener {

            progressDialog?.dismiss()


            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Failed to submit report")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked



                }
                .show()


        }
}






@Preview(showBackground = true)
@Composable
fun PreviewLight() {
  UpdateScreen(rememberNavController())
}

annotation class Preview(val showBackground: Boolean)



