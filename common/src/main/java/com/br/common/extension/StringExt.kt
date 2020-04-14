package br.com.rba.common.extension

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.toLocalDate(): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return LocalDate.parse(this, formatter)
}