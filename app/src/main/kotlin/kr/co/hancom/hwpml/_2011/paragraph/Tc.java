//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.04 at 01:47:45 AM UTC 
//


package kr.co.hancom.hwpml._2011.paragraph;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/paragraph}subList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/paragraph}cellAddr"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/paragraph}cellSpan"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/paragraph}cellSz"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/paragraph}cellMargin"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="borderFillIDRef" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="dirty" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="editable" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="hasMargin" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="header" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="protect" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subList",
    "cellAddr",
    "cellSpan",
    "cellSz",
    "cellMargin"
})
@XmlRootElement(name = "tc")
public class Tc {

    protected List<SubList> subList;
    @XmlElement(required = true)
    protected CellAddr cellAddr;
    @XmlElement(required = true)
    protected CellSpan cellSpan;
    @XmlElement(required = true)
    protected CellSz cellSz;
    @XmlElement(required = true)
    protected CellMargin cellMargin;
    @XmlAttribute(name = "borderFillIDRef", required = true)
    protected BigInteger borderFillIDRef;
    @XmlAttribute(name = "dirty", required = true)
    protected BigInteger dirty;
    @XmlAttribute(name = "editable", required = true)
    protected BigInteger editable;
    @XmlAttribute(name = "hasMargin", required = true)
    protected BigInteger hasMargin;
    @XmlAttribute(name = "header", required = true)
    protected BigInteger header;
    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "protect", required = true)
    protected BigInteger protect;

    /**
     * Gets the value of the subList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubList }
     * 
     * 
     */
    public List<SubList> getSubList() {
        if (subList == null) {
            subList = new ArrayList<SubList>();
        }
        return this.subList;
    }

    /**
     * Gets the value of the cellAddr property.
     * 
     * @return
     *     possible object is
     *     {@link CellAddr }
     *     
     */
    public CellAddr getCellAddr() {
        return cellAddr;
    }

    /**
     * Sets the value of the cellAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link CellAddr }
     *     
     */
    public void setCellAddr(CellAddr value) {
        this.cellAddr = value;
    }

    /**
     * Gets the value of the cellSpan property.
     * 
     * @return
     *     possible object is
     *     {@link CellSpan }
     *     
     */
    public CellSpan getCellSpan() {
        return cellSpan;
    }

    /**
     * Sets the value of the cellSpan property.
     * 
     * @param value
     *     allowed object is
     *     {@link CellSpan }
     *     
     */
    public void setCellSpan(CellSpan value) {
        this.cellSpan = value;
    }

    /**
     * Gets the value of the cellSz property.
     * 
     * @return
     *     possible object is
     *     {@link CellSz }
     *     
     */
    public CellSz getCellSz() {
        return cellSz;
    }

    /**
     * Sets the value of the cellSz property.
     * 
     * @param value
     *     allowed object is
     *     {@link CellSz }
     *     
     */
    public void setCellSz(CellSz value) {
        this.cellSz = value;
    }

    /**
     * Gets the value of the cellMargin property.
     * 
     * @return
     *     possible object is
     *     {@link CellMargin }
     *     
     */
    public CellMargin getCellMargin() {
        return cellMargin;
    }

    /**
     * Sets the value of the cellMargin property.
     * 
     * @param value
     *     allowed object is
     *     {@link CellMargin }
     *     
     */
    public void setCellMargin(CellMargin value) {
        this.cellMargin = value;
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
     * Gets the value of the dirty property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDirty() {
        return dirty;
    }

    /**
     * Sets the value of the dirty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDirty(BigInteger value) {
        this.dirty = value;
    }

    /**
     * Gets the value of the editable property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEditable() {
        return editable;
    }

    /**
     * Sets the value of the editable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEditable(BigInteger value) {
        this.editable = value;
    }

    /**
     * Gets the value of the hasMargin property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHasMargin() {
        return hasMargin;
    }

    /**
     * Sets the value of the hasMargin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHasMargin(BigInteger value) {
        this.hasMargin = value;
    }

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHeader(BigInteger value) {
        this.header = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the protect property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProtect() {
        return protect;
    }

    /**
     * Sets the value of the protect property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProtect(BigInteger value) {
        this.protect = value;
    }

}
