import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

fun main(args: Array<String>) {
  val inputFile = File("input.txt")
  val outputFile = File("output.gz")

  // Compress the input file
  val gzipOutputStream = GZIPOutputStream(FileOutputStream(outputFile))
  gzipOutputStream.write(inputFile.readBytes())
  gzipOutputStream.close()

  // Decompress the output file
  val gzipInputStream = GZIPInputStream(FileInputStream(outputFile))
  val outputBytes = gzipInputStream.readBytes()
  gzipInputStream.close()
  var outputString = outputBytes.toString()

  // Write the decompressed bytes to a new file
  val outputFile2 = File("output2.txt")
  outputFile2.writeBytes(outputBytes)
}