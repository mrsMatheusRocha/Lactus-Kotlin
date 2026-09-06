package mrsmatheusrocha.com.github.lactus_kotlin.viewmodel

import androidx.compose.runtime.simulateHotReload
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()


    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
        _errorMessage.value = null
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
        _errorMessage.value = null
    }

    fun validarLogin( onGestorLogin: () -> Unit) {
        if (_email.value.lowercase().contains("gestor")) {
            onGestorLogin()
        } else {
            _errorMessage.value = "Dados incorretos. Verifique seu e-mail e senha."
        }
    }
}