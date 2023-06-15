//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.15 at 05:28:26 AM UTC 
//


package kr.co.hancom.hwpml._2011.head;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/head}tabPr" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="itemCnt" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tabPr"
})
@XmlRootElement(name = "tabProperties")
public class TabProperties {

    @XmlElement(required = true)
    protected List<TabPr> tabPr;
    @XmlAttribute(name = "itemCnt", required = true)
    protected BigInteger itemCnt;

    /**
     * Gets the value of the tabPr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tabPr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTabPr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TabPr }
     * 
     * 
     */
    public List<TabPr> getTabPr() {
        if (tabPr == null) {
            tabPr = new ArrayList<TabPr>();
        }
        return this.tabPr;
    }

    /**
     * Gets the value of the itemCnt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getItemCnt() {
        return itemCnt;
    }

    /**
     * Sets the value of the itemCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setItemCnt(BigInteger value) {
        this.itemCnt = value;
    }

}
