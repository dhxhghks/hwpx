//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.15 at 05:28:26 AM UTC 
//


package kr.co.hancom.hwpml._2011.head;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}fontRef"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}ratio"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}spacing"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}relSz"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}offset"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="borderFillIDRef" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="height" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="shadeColor" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="symMark" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="textColor" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="useFontSpace" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="useKerning" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fontRef",
    "ratio",
    "spacing",
    "relSz",
    "offset"
})
@XmlRootElement(name = "charPr")
public class CharPr {

    @XmlElement(required = true)
    protected FontRef fontRef;
    @XmlElement(required = true)
    protected Ratio ratio;
    @XmlElement(required = true)
    protected Spacing spacing;
    @XmlElement(required = true)
    protected RelSz relSz;
    @XmlElement(required = true)
    protected Offset offset;
    @XmlAttribute(name = "borderFillIDRef", required = true)
    protected BigInteger borderFillIDRef;
    @XmlAttribute(name = "height", required = true)
    protected BigInteger height;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;
    @XmlAttribute(name = "shadeColor", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shadeColor;
    @XmlAttribute(name = "symMark", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String symMark;
    @XmlAttribute(name = "textColor", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String textColor;
    @XmlAttribute(name = "useFontSpace", required = true)
    protected BigInteger useFontSpace;
    @XmlAttribute(name = "useKerning", required = true)
    protected BigInteger useKerning;

    /**
     * Gets the value of the fontRef property.
     * 
     * @return
     *     possible object is
     *     {@link FontRef }
     *     
     */
    public FontRef getFontRef() {
        return fontRef;
    }

    /**
     * Sets the value of the fontRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontRef }
     *     
     */
    public void setFontRef(FontRef value) {
        this.fontRef = value;
    }

    /**
     * Gets the value of the ratio property.
     * 
     * @return
     *     possible object is
     *     {@link Ratio }
     *     
     */
    public Ratio getRatio() {
        return ratio;
    }

    /**
     * Sets the value of the ratio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ratio }
     *     
     */
    public void setRatio(Ratio value) {
        this.ratio = value;
    }

    /**
     * Gets the value of the spacing property.
     * 
     * @return
     *     possible object is
     *     {@link Spacing }
     *     
     */
    public Spacing getSpacing() {
        return spacing;
    }

    /**
     * Sets the value of the spacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Spacing }
     *     
     */
    public void setSpacing(Spacing value) {
        this.spacing = value;
    }

    /**
     * Gets the value of the relSz property.
     * 
     * @return
     *     possible object is
     *     {@link RelSz }
     *     
     */
    public RelSz getRelSz() {
        return relSz;
    }

    /**
     * Sets the value of the relSz property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelSz }
     *     
     */
    public void setRelSz(RelSz value) {
        this.relSz = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link Offset }
     *     
     */
    public Offset getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Offset }
     *     
     */
    public void setOffset(Offset value) {
        this.offset = value;
    }

    /**
     * Gets the value of the borderFillIDRef property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBorderFillIDRef() {
        return borderFillIDRef;
    }

    /**
     * Sets the value of the borderFillIDRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBorderFillIDRef(BigInteger value) {
        this.borderFillIDRef = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHeight(BigInteger value) {
        this.height = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the shadeColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShadeColor() {
        return shadeColor;
    }

    /**
     * Sets the value of the shadeColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShadeColor(String value) {
        this.shadeColor = value;
    }

    /**
     * Gets the value of the symMark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymMark() {
        return symMark;
    }

    /**
     * Sets the value of the symMark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymMark(String value) {
        this.symMark = value;
    }

    /**
     * Gets the value of the textColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextColor() {
        return textColor;
    }

    /**
     * Sets the value of the textColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextColor(String value) {
        this.textColor = value;
    }

    /**
     * Gets the value of the useFontSpace property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUseFontSpace() {
        return useFontSpace;
    }

    /**
     * Sets the value of the useFontSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUseFontSpace(BigInteger value) {
        this.useFontSpace = value;
    }

    /**
     * Gets the value of the useKerning property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUseKerning() {
        return useKerning;
    }

    /**
     * Sets the value of the useKerning property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUseKerning(BigInteger value) {
        this.useKerning = value;
    }

}