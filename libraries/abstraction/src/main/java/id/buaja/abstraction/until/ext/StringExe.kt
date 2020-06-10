package id.buaja.abstraction.until.ext

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Julsapargi Nursam on 6/10/20.
 */

fun String.toDate(dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timeZone: TimeZone = TimeZone.getTimeZone("UTC")): Date {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.parse(this)!!
}

fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
    val locale = Locale("in", "ID")
    val formatter = SimpleDateFormat(dateFormat, locale)
    formatter.timeZone = timeZone
    return formatter.format(this)
}

fun String.formatRupiah(): String {
    val locale = Locale("in", "ID")
    val formatRupiah = NumberFormat.getCurrencyInstance(locale)
    return formatRupiah.format(this.toDouble()).replace(",00", "")
}