package ua.nuop.elkamali.repo

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import ua.nuop.elkamali.data.fireauth.FirebaseAuthClient
import ua.nuop.elkamali.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepo @Inject constructor(private val firebaseAuth: FirebaseAuthClient) {
    suspend fun googleLogin(authCredential: AuthCredential): Flow<Resource<AuthResult>> {
        return firebaseAuth.login(authCredential)
    }

    fun getCurrentUser() = firebaseAuth.getCurrentUser()
}