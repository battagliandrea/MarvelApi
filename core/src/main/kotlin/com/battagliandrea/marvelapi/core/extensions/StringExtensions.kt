package com.battagliandrea.marvelapi.core.extensions

import java.math.BigInteger
import java.security.MessageDigest

/**
 * Encrypt string with MD5 message-digest algorithm
 */
fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}
