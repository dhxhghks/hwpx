//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.15 at 05:28:26 AM UTC 
//


package kr.co.hancom.hwpml._2011.head;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}linkinfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "linkinfo"
})
@XmlRootElement(name = "docOption")
public class DocOption {

    @XmlElement(required = true)
    protected Linkinfo linkinfo;

    /**
     * Gets the value of the linkinfo property.
     * 
     * @return
     *     possible object is
     *     {@link Linkinfo }
     *     
     */
    public Linkinfo getLinkinfo() {
        return linkinfo;
    }

    /**
     * Sets the value of the linkinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Linkinfo }
     *     
     */
    public void setLinkinfo(Linkinfo value) {
        this.linkinfo = value;
    }

}