package com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.activity

import android.accounts.AccountManager
import android.app.Activity
import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.diegojosuepachecorosas.gdwnewarchitecture.R
import com.example.diegojosuepachecorosas.gdwnewarchitecture.core.platform.BaseActivity
import com.example.diegojosuepachecorosas.gdwnewarchitecture.di.activity.ActivityBuilderModule_ProvidesFileActivity
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.adapter.RVFilesAdapter
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.model.FilesViewState
import com.example.diegojosuepachecorosas.gdwnewarchitecture.features.manageFiles.presentation.viewmodel.FilesViewModel
import com.google.android.gms.auth.api.credentials.Credential
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.drive.Drive
import com.google.android.gms.drive.DriveClient
import com.google.android.gms.drive.DriveResourceClient
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class FilesActivity : BaseActivity() {

    companion object {
        fun newInstance(context: Context) = Intent(context,FilesActivity::class.java)
    }

    val TAG: String = "google-drive"
    var mDriveClient: DriveClient? = null
    var mDriveResourceClient: DriveResourceClient? = null

    // STATIC VARIABLES
    val REQUEST_CODE_SIGN_IN = 0

    val credential = GoogleAccountCredential.usingOAuth2(this, Arrays.asList("https://www.googleapis.com/auth/drive"))
    private val viewModel by lazy {
        getViewModel() as FilesViewModel
    }

    private lateinit var adapter: RVFilesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapter = RVFilesAdapter()
        rvFiles.adapter = adapter

        btnGoogleDrive.setOnClickListener {
            val googleSignInClient: GoogleSignInClient = buildGoogleSignInClient()

            startActivityForResult(googleSignInClient.signInIntent, REQUEST_CODE_SIGN_IN)
        }

        viewModel.state.observe(this, Observer {
            it?.run {
                when(this){
                    FilesViewState.Loading ->{
                        adapter.isLoading = true
                    }
                    is FilesViewState.Error ->{
                        adapter.isLoading = false
                    }
                    is FilesViewState.Success ->{
                        adapter.addListFiles(files)
                        adapter.isLoading = false
                    }
                }
            }
        })
    }

    fun buildGoogleSignInClient(): GoogleSignInClient {
        val signInOptions: GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                //Cuando la aplicación necesita acceso a los datos del usuario, le pide a Google un alcance de acceso particular.
                .requestScopes(Drive.SCOPE_FILE)
                .requestId()
                .build()
        return GoogleSignIn.getClient(this, signInOptions)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_SIGN_IN ->
                if (resultCode == Activity.RESULT_OK) {
                    Log.i(TAG, "Sign in succesfully")
                    val name = data?.getStringExtra(AccountManager.KEY_ACCOUNT_NAME)
                    if(name != null){
                        credential?.selectedAccountName = name
                        mDriveClient = Drive.getDriveClient(this, GoogleSignIn.getLastSignedInAccount(this)!!)
                        mDriveResourceClient = Drive.getDriveResourceClient(this, GoogleSignIn.getLastSignedInAccount(this)!!)
                        viewModel.loadFiles()

                    }


                }
//                i(TAG,"Sign in request Code")
        }
    }
}