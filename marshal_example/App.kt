import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Unmarshaller
import javax.xml.bind.Marshaller

import java.io.StringReader
import java.io.StringWriter
import java.io.File

import org.idpf._2007.opf.Package

import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.StringWriter

fun prettyPrintXml(xml: String): String {
    val document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(StringReader(xml))
    val stringWriter = StringWriter()
    TransformerFactory.newInstance().newTransformer().transform(Source(document), Result(stringWriter))
    return stringWriter.toString()
}

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

    var f = File(args[0])
    var str:String = f.readBytes().toString(Charsets.UTF_8)
    println(str)

    var p: Package = unmarshalPackage(str)

    //println("title : ${up.metadata.title}")

/*     for(meta in p.metadata.getMeta()) {
        println(meta.getName())
    }
*/

    //p.metadata.title = "Title2"

    var str2 = marshalPackage(p)

    println(str2)
}