package playground.kotlin

import java.util.*

class UserInfo(val uuid: String = UUID.randomUUID().toString(),
               val name: String,
               val hasAccess: Boolean = true,
               val isAdmin: Boolean = false,
               val notes: String = "")