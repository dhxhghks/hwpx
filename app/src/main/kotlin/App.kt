/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */

/* import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Marshaller
import jakarta.xml.bind.Unmarshaller */

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Unmarshaller
import javax.xml.bind.Marshaller

import kotlinx.serialization.*
import kotlinx.serialization.xml.*

import java.io.StringReader
import java.io.StringWriter
import java.io.File

import org.idpf._2007.opf.ObjectFactory
import org.idpf._2007.opf.Package
import org.idpf._2007.opf.Metadata
import org.idpf._2007.opf.Meta

import hwpx.FileManager
import hwpx.UnzippedFile


fun marshalPackage(p: Package): String {
    val context = JAXBContext.newInstance(Package::class.java)
    val marshaller = context.createMarshaller()
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)

    val writer = StringWriter()
    marshaller.marshal(p, writer)

    return writer.toString()
}

fun unmarshalPackage(xml: String): Package {
    val context = JAXBContext.newInstance(Package::class.java)
    val unmarshaller = context.createUnmarshaller()
    val reader = StringReader(xml)

    return unmarshaller.unmarshal(reader) as Package
}

fun main(args: Array<String>) {
    if(args.size < 1) {
        println("Usage: java -jar ~/lib/App.jar <zipfile>")
    }
    val fileName = args[0]
    
    var fm = FileManager()
    var list: List<UnzippedFile> = fm.unzip(File(fileName))
    list.forEach{
//	println(it.filename)
//	println(it.content.toString(Charsets.UTF_8))
	var orig = it.content.toString(Charsets.UTF_8)
	val xml = XML { indentString = "    " }
	val xmlElement = xml.parseXmlElement(xml)
	val pretty = xml.stringify(xmlElement)

	println(pretty)

	if(it.filename.equals("Contents/content.hpf")) {
	    println(it.content.toString(Charsets.UTF_8))
	    var p: Package = unmarshalPackage(it.content.toString(Charsets.UTF_8))
//	    p.getMetadata().setTitle("Test")
//	    p.getMetadata().setLanguage("ko")
	    println(marshalPackage(p))
	}
    }
}

//fun main(args: Array<String>) {
/*
    var of: ObjectFactory = ObjectFactory()
    var p: Package = of.createPackage()
    p.setMetadata(of.createMetadata())
    p.getMetadata().setTitle("Test")
    p.getMetadata().setLanguage("ko")

    var m = of.createMeta()
    m.setName("creator")
    m.setContent("MSS")

    var m2 = of.createMeta()
    m2.setName("subject")
    m2.setContent("subject")

    var list = p.getMetadata().getMeta()
//    p.getMetadata().getMeta().add(m)
//    p.getMetadata().getMeta().add(m2)
    list.add(m)
    list.add(m2)

    var str = marshalPackage(p)

    print(str)  

    var up: Package = unmarshalPackage(str)
    println("title : ${up.metadata.title}")

    up.metadata.title = "Title2"

    var str2 = marshalPackage(up)

    print(str2)
*/
    
//}
