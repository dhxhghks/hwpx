//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 11:51:35 AM UTC 
//


package kr.co.hancom.hwpml._2011.head;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}beginNum"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}refList"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}compatibleDocument"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}docOption"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}trackchageConfig"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="secCnt" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "beginNum",
    "refList",
    "compatibleDocument",
    "docOption",
    "trackchageConfig"
})
@XmlRootElement(name = "head")
public class Head {

    @XmlElement(required = true)
    protected BeginNum beginNum;
    @XmlElement(required = true)
    protected RefList refList;
    @XmlElement(required = true)
    protected CompatibleDocument compatibleDocument;
    @XmlElement(required = true)
    protected DocOption docOption;
    @XmlElement(required = true)
    protected TrackchageConfig trackchageConfig;
    @XmlAttribute(name = "secCnt", required = true)
    protected BigInteger secCnt;
    @XmlAttribute(name = "version", required = true)
    protected BigDecimal version;

    /**
     * Gets the value of the beginNum property.
     * 
     * @return
     *     possible object is
     *     {@link BeginNum }
     *     
     */
    public BeginNum getBeginNum() {
        return beginNum;
    }

    /**
     * Sets the value of the beginNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeginNum }
     *     
     */
    public void setBeginNum(BeginNum value) {
        this.beginNum = value;
    }

    /**
     * Gets the value of the refList property.
     * 
     * @return
     *     possible object is
     *     {@link RefList }
     *     
     */
    public RefList getRefList() {
        return refList;
    }

    /**
     * Sets the value of the refList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefList }
     *     
     */
    public void setRefList(RefList value) {
        this.refList = value;
    }

    /**
     * Gets the value of the compatibleDocument property.
     * 
     * @return
     *     possible object is
     *     {@link CompatibleDocument }
     *     
     */
    public CompatibleDocument getCompatibleDocument() {
        return compatibleDocument;
    }

    /**
     * Sets the value of the compatibleDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompatibleDocument }
     *     
     */
    public void setCompatibleDocument(CompatibleDocument value) {
        this.compatibleDocument = value;
    }

    /**
     * Gets the value of the docOption property.
     * 
     * @return
     *     possible object is
     *     {@link DocOption }
     *     
     */
    public DocOption getDocOption() {
        return docOption;
    }

    /**
     * Sets the value of the docOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocOption }
     *     
     */
    public void setDocOption(DocOption value) {
        this.docOption = value;
    }

    /**
     * Gets the value of the trackchageConfig property.
     * 
     * @return
     *     possible object is
     *     {@link TrackchageConfig }
     *     
     */
    public TrackchageConfig getTrackchageConfig() {
        return trackchageConfig;
    }

    /**
     * Sets the value of the trackchageConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackchageConfig }
     *     
     */
    public void setTrackchageConfig(TrackchageConfig value) {
        this.trackchageConfig = value;
    }

    /**
     * Gets the value of the secCnt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSecCnt() {
        return secCnt;
    }

    /**
     * Sets the value of the secCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSecCnt(BigInteger value) {
        this.secCnt = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVersion(BigDecimal value) {
        this.version = value;
    }

}
