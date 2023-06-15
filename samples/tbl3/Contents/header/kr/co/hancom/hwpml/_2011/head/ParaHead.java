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
import javax.xml.bind.annotation.XmlValue;
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
 *       &lt;attribute name="align" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="autoIndent" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="charPrIDRef" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="checkable" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="level" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="numFormat" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="textOffset" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="textOffsetType" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="useInstWidth" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="widthAdjust" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "paraHead")
public class ParaHead {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "align", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String align;
    @XmlAttribute(name = "autoIndent", required = true)
    protected BigInteger autoIndent;
    @XmlAttribute(name = "charPrIDRef", required = true)
    protected BigInteger charPrIDRef;
    @XmlAttribute(name = "checkable", required = true)
    protected BigInteger checkable;
    @XmlAttribute(name = "level", required = true)
    protected BigInteger level;
    @XmlAttribute(name = "numFormat", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String numFormat;
    @XmlAttribute(name = "start")
    protected BigInteger start;
    @XmlAttribute(name = "textOffset", required = true)
    protected BigInteger textOffset;
    @XmlAttribute(name = "textOffsetType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String textOffsetType;
    @XmlAttribute(name = "useInstWidth", required = true)
    protected BigInteger useInstWidth;
    @XmlAttribute(name = "widthAdjust", required = true)
    protected BigInteger widthAdjust;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the align property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlign() {
        return align;
    }

    /**
     * Sets the value of the align property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlign(String value) {
        this.align = value;
    }

    /**
     * Gets the value of the autoIndent property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAutoIndent() {
        return autoIndent;
    }

    /**
     * Sets the value of the autoIndent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAutoIndent(BigInteger value) {
        this.autoIndent = value;
    }

    /**
     * Gets the value of the charPrIDRef property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCharPrIDRef() {
        return charPrIDRef;
    }

    /**
     * Sets the value of the charPrIDRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCharPrIDRef(BigInteger value) {
        this.charPrIDRef = value;
    }

    /**
     * Gets the value of the checkable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCheckable() {
        return checkable;
    }

    /**
     * Sets the value of the checkable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCheckable(BigInteger value) {
        this.checkable = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLevel(BigInteger value) {
        this.level = value;
    }

    /**
     * Gets the value of the numFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumFormat() {
        return numFormat;
    }

    /**
     * Sets the value of the numFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumFormat(String value) {
        this.numFormat = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStart(BigInteger value) {
        this.start = value;
    }

    /**
     * Gets the value of the textOffset property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTextOffset() {
        return textOffset;
    }

    /**
     * Sets the value of the textOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTextOffset(BigInteger value) {
        this.textOffset = value;
    }

    /**
     * Gets the value of the textOffsetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextOffsetType() {
        return textOffsetType;
    }

    /**
     * Sets the value of the textOffsetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextOffsetType(String value) {
        this.textOffsetType = value;
    }

    /**
     * Gets the value of the useInstWidth property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUseInstWidth() {
        return useInstWidth;
    }

    /**
     * Sets the value of the useInstWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUseInstWidth(BigInteger value) {
        this.useInstWidth = value;
    }

    /**
     * Gets the value of the widthAdjust property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWidthAdjust() {
        return widthAdjust;
    }

    /**
     * Sets the value of the widthAdjust property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWidthAdjust(BigInteger value) {
        this.widthAdjust = value;
    }

}
