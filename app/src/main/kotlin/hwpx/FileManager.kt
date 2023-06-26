package hwpx

import java.io.File
import java.io.FileInputStream
import java.util.zip.ZipInputStream


data class UnzippedFile(val filename: String, val content: ByteArray)
//data class UnzippedFile(val filename: String)

class FileManager {
/*    fun decompress(fileName: String) {
        val zipIS = ZipInputStream(FileInputStream(fileName))
        while(zipIS.hasMoreEntries()) {
            val entry = zipIS.nextEntry()
	    println(entry.getName())

        }
    } */

    fun unzip(file: File): List<UnzippedFile> = ZipInputStream(FileInputStream(file))
        .use { zipInputStream ->
             generateSequence { zipInputStream.nextEntry }
             .filterNot { it.isDirectory }
             .map {
                UnzippedFile(
                    filename = it.name,
                    content = zipInputStream.readBytes()
                )
            }.toList()
    }


}