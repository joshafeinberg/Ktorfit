package de.jensklingenberg.ktorfit.reqBuilderExtension

import de.jensklingenberg.ktorfit.model.ParameterData
import de.jensklingenberg.ktorfit.model.annotations.ParameterAnnotation.*
import de.jensklingenberg.ktorfit.utils.surroundIfNotEmpty


fun getFilePartCode(params: List<ParameterData>): String {

    val filePartText = params.filter { it.hasAnnotation<FilePart>() }.joinToString("") { parameterData ->
        val part = parameterData.annotations.filterIsInstance<FilePart>().first()

        """
            append(
                key = "${part.name}",
                value = ${parameterData.name},
                headers = Headers.build {
                    append(HttpHeaders.ContentType, "${part.contentType}")
                    append(HttpHeaders.ContentDisposition, "${part.contentDisposition}")
                },
            )
            
        """.trimIndent()
    }

    return filePartText.surroundIfNotEmpty(
        "val __formData = formData {\n", "}\nsetBody(MultiPartFormDataContent(__formData))\n"
    )
}

