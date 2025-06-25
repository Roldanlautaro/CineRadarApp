package com.lautarodev.cineradar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.lautarodev.cineradar.shows.Usuario
import com.lautarodev.cineradar.shows.local.ShowsDataBase
import com.lautarodev.cineradar.shows.local.ShowsDataBaseProvider
import com.lautarodev.cineradar.ui.screens.NavigationStack
import com.lautarodev.cineradar.ui.screens.Screens
import com.lautarodev.cineradar.ui.screens.splash.SplashScreen
import com.lautarodev.cineradar.ui.theme.CineRadarTheme




class MainActivity : ComponentActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var navController: NavHostController


    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener { authResult ->
                    if (authResult.isSuccessful) {
                        val email = authResult.result.user!!.email.toString()
                        Log.d("mail", email)
                        val db = FirebaseFirestore.getInstance()

                        val docRef = db.collection("Usuarios").document(email)
                        docRef.get().addOnSuccessListener { document ->
                            if (!document.exists()) {
                                docRef.set(Usuario(email))
                            }
                        }

                        navController.navigate(Screens.ShowsList.route) {
                            popUpTo(Screens.Login.route) { inclusive = true }
                        }
                    }
                }
        } catch (e: ApiException) {
            Log.e("AUTH", "Error en Google Sign-In", e)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        ShowsDataBaseProvider.createDataBase(this)

        googleSignInClient = GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        )

        setContent {

            navController= rememberNavController()

            CineRadarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationStack(onGoogleSignInClick = {
                        launcher.launch(googleSignInClient.signInIntent)
                    },
                        onLogout = {
                            FirebaseAuth.getInstance().signOut()
                            googleSignInClient.signOut()
                            navController.navigate(Screens.Splash.route) {
                                popUpTo("Perfil_Screen") { inclusive = true }
                                popUpTo("Shows_List_Screen") { inclusive = true }
                            }
                        },
                        navController = navController

                    )
                }
            }
        }
    }
}