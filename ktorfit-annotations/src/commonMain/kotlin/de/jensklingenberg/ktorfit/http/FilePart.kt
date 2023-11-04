package de.jensklingenberg.ktorfit.http

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class FilePart(val name: String = "", val contentType: String = "", val contentDisposition: String = "")
