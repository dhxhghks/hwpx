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
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}fontfaces"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}borderFills"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}charProperties"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}tabProperties"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}numberings"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}paraProperties"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}styles"/&gt;
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
    "fontfaces",
    "borderFills",
    "charProperties",
    "tabProperties",
    "numberings",
    "paraProperties",
    "styles"
})
@XmlRootElement(name = "refList")
public class RefList {

    @XmlElement(required = true)
    protected Fontfaces fontfaces;
    @XmlElement(required = true)
    protected BorderFills borderFills;
    @XmlElement(required = true)
    protected CharProperties charProperties;
    @XmlElement(required = true)
    protected TabProperties tabProperties;
    @XmlElement(required = true)
    protected Numberings numberings;
    @XmlElement(required = true)
    protected ParaProperties paraProperties;
    @XmlElement(required = true)
    protected Styles styles;

    /**
     * Gets the value of the fontfaces property.
     * 
     * @return
     *     possible object is
     *     {@link Fontfaces }
     *     
     */
    public Fontfaces getFontfaces() {
        return fontfaces;
    }

    /**
     * Sets the value of the fontfaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fontfaces }
     *     
     */
    public void setFontfaces(Fontfaces value) {
        this.fontfaces = value;
    }

    /**
     * Gets the value of the borderFills property.
     * 
     * @return
     *     possible object is
     *     {@link BorderFills }
     *     
     */
    public BorderFills getBorderFills() {
        return borderFills;
    }

    /**
     * Sets the value of the borderFills property.
     * 
     * @param value
     *     allowed object is
     *     {@link BorderFills }
     *     
     */
    public void setBorderFills(BorderFills value) {
        this.borderFills = value;
    }

    /**
     * Gets the value of the charProperties property.
     * 
     * @return
     *     possible object is
     *     {@link CharProperties }
     *     
     */
    public CharProperties getCharProperties() {
        return charProperties;
    }

    /**
     * Sets the value of the charProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharProperties }
     *     
     */
    public void setCharProperties(CharProperties value) {
        this.charProperties = value;
    }

    /**
     * Gets the value of the tabProperties property.
     * 
     * @return
     *     possible object is
     *     {@link TabProperties }
     *     
     */
    public TabProperties getTabProperties() {
        return tabProperties;
    }

    /**
     * Sets the value of the tabProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link TabProperties }
     *     
     */
    public void setTabProperties(TabProperties value) {
        this.tabProperties = value;
    }

    /**
     * Gets the value of the numberings property.
     * 
     * @return
     *     possible object is
     *     {@link Numberings }
     *     
     */
    public Numberings getNumberings() {
        return numberings;
    }

    /**
     * Sets the value of the numberings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Numberings }
     *     
     */
    public void setNumberings(Numberings value) {
        this.numberings = value;
    }

    /**
     * Gets the value of the paraProperties property.
     * 
     * @return
     *     possible object is
     *     {@link ParaProperties }
     *     
     */
    public ParaProperties getParaProperties() {
        return paraProperties;
    }

    /**
     * Sets the value of the paraProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParaProperties }
     *     
     */
    public void setParaProperties(ParaProperties value) {
        this.paraProperties = value;
    }

    /**
     * Gets the value of the styles property.
     * 
     * @return
     *     possible object is
     *     {@link Styles }
     *     
     */
    public Styles getStyles() {
        return styles;
    }

    /**
     * Sets the value of the styles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Styles }
     *     
     */
    public void setStyles(Styles value) {
        this.styles = value;
    }

}
