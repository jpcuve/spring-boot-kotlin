package com.messio.demo

data class FirebaseSignInValue(val uid: String = "", val isAnonymous: Boolean = true, val email: String?, val displayName: String?)
data class ProfileValue(val identified: Boolean = false, val name: String = "<anonymous>", val roles: List<String> = listOf())
data class TokenValue(val token: String = "")