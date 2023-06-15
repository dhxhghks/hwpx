//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 11:51:35 AM UTC 
//


package kr.co.hancom.hwpml._2011.head;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="breakLatinWord" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="breakNonLatinWord" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="keepLines" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="keepWithNext" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="lineWrap" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="pageBreakBefore" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="widowOrphan" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "breakSetting")
public class BreakSetting {

    @XmlAttribute(name = "breakLatinWord", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String breakLatinWord;
    @XmlAttribute(name = "breakNonLatinWord", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String breakNonLatinWord;
    @XmlAttribute(name = "keepLines", required = true)
    protected BigInteger keepLines;
    @XmlAttribute(name = "keepWithNext", required = true)
    protected BigInteger keepWithNext;
    @XmlAttribute(name = "lineWrap", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String lineWrap;
    @XmlAttribute(name = "pageBreakBefore", required = true)
    protected BigInteger pageBreakBefore;
    @XmlAttribute(name = "widowOrphan", required = true)
    protected BigInteger widowOrphan;

    /**
     * Gets the value of the breakLatinWord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBreakLatinWord() {
        return breakLatinWord;
    }

    /**
     * Sets the value of the breakLatinWord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBreakLatinWord(String value) {
        this.breakLatinWord = value;
    }

    /**
     * Gets the value of the breakNonLatinWord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBreakNonLatinWord() {
        return breakNonLatinWord;
    }

    /**
     * Sets the value of the breakNonLatinWord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBreakNonLatinWord(String value) {
        this.breakNonLatinWord = value;
    }

    /**
     * Gets the value of the keepLines property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getKeepLines() {
        return keepLines;
    }

    /**
     * Sets the value of the keepLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setKeepLines(BigInteger value) {
        this.keepLines = value;
    }

    /**
     * Gets the value of the keepWithNext property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getKeepWithNext() {
        return keepWithNext;
    }

    /**
     * Sets the value of the keepWithNext property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setKeepWithNext(BigInteger value) {
        this.keepWithNext = value;
    }

    /**
     * Gets the value of the lineWrap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineWrap() {
        return lineWrap;
    }

    /**
     * Sets the value of the lineWrap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineWrap(String value) {
        this.lineWrap = value;
    }

    /**
     * Gets the value of the pageBreakBefore property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPageBreakBefore() {
        return pageBreakBefore;
    }

    /**
     * Sets the value of the pageBreakBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPageBreakBefore(BigInteger value) {
        this.pageBreakBefore = value;
    }

    /**
     * Gets the value of the widowOrphan property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWidowOrphan() {
        return widowOrphan;
    }

    /**
     * Sets the value of the widowOrphan property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWidowOrphan(BigInteger value) {
        this.widowOrphan = value;
    }

}
