//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 11:51:35 AM UTC 
//


package kr.co.hancom.hwpml._2011.head;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import kr.co.hancom.hwpml._2011.core.Intent;
import kr.co.hancom.hwpml._2011.core.Left;
import kr.co.hancom.hwpml._2011.core.Next;
import kr.co.hancom.hwpml._2011.core.Prev;
import kr.co.hancom.hwpml._2011.core.Right;


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
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/core}intent"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/core}left"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/core}right"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/core}prev"/&gt;
 *         &lt;element ref="{http://www.hancom.co.kr/hwpml/2011/core}next"/&gt;
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
    "intent",
    "left",
    "right",
    "prev",
    "next"
})
@XmlRootElement(name = "margin")
public class Margin {

    @XmlElement(namespace = "http://www.hancom.co.kr/hwpml/2011/core", required = true)
    protected Intent intent;
    @XmlElement(namespace = "http://www.hancom.co.kr/hwpml/2011/core", required = true)
    protected Left left;
    @XmlElement(namespace = "http://www.hancom.co.kr/hwpml/2011/core", required = true)
    protected Right right;
    @XmlElement(namespace = "http://www.hancom.co.kr/hwpml/2011/core", required = true)
    protected Prev prev;
    @XmlElement(namespace = "http://www.hancom.co.kr/hwpml/2011/core", required = true)
    protected Next next;

    /**
     * Gets the value of the intent property.
     * 
     * @return
     *     possible object is
     *     {@link Intent }
     *     
     */
    public Intent getIntent() {
        return intent;
    }

    /**
     * Sets the value of the intent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Intent }
     *     
     */
    public void setIntent(Intent value) {
        this.intent = value;
    }

    /**
     * Gets the value of the left property.
     * 
     * @return
     *     possible object is
     *     {@link Left }
     *     
     */
    public Left getLeft() {
        return left;
    }

    /**
     * Sets the value of the left property.
     * 
     * @param value
     *     allowed object is
     *     {@link Left }
     *     
     */
    public void setLeft(Left value) {
        this.left = value;
    }

    /**
     * Gets the value of the right property.
     * 
     * @return
     *     possible object is
     *     {@link Right }
     *     
     */
    public Right getRight() {
        return right;
    }

    /**
     * Sets the value of the right property.
     * 
     * @param value
     *     allowed object is
     *     {@link Right }
     *     
     */
    public void setRight(Right value) {
        this.right = value;
    }

    /**
     * Gets the value of the prev property.
     * 
     * @return
     *     possible object is
     *     {@link Prev }
     *     
     */
    public Prev getPrev() {
        return prev;
    }

    /**
     * Sets the value of the prev property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prev }
     *     
     */
    public void setPrev(Prev value) {
        this.prev = value;
    }

    /**
     * Gets the value of the next property.
     * 
     * @return
     *     possible object is
     *     {@link Next }
     *     
     */
    public Next getNext() {
        return next;
    }

    /**
     * Sets the value of the next property.
     * 
     * @param value
     *     allowed object is
     *     {@link Next }
     *     
     */
    public void setNext(Next value) {
        this.next = value;
    }

}