//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.22 at 11:08:54 AM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_3_1.compound;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for docCopyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docCopyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="para" type="{}docParaType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sect1" type="{}docSect1Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="internal" type="{}docInternalType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docCopyType", propOrder = {
    "para",
    "sect1",
    "internal"
})
public class DocCopyType {

    protected List<DocParaType> para;
    protected List<DocSect1Type> sect1;
    protected DocInternalType internal;
    @XmlAttribute(name = "link")
    protected String link;

    /**
     * Gets the value of the para property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the para property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPara().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocParaType }
     * 
     * 
     */
    public List<DocParaType> getPara() {
        if (para == null) {
            para = new ArrayList<DocParaType>();
        }
        return this.para;
    }

    /**
     * Gets the value of the sect1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sect1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSect1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocSect1Type }
     * 
     * 
     */
    public List<DocSect1Type> getSect1() {
        if (sect1 == null) {
            sect1 = new ArrayList<DocSect1Type>();
        }
        return this.sect1;
    }

    /**
     * Gets the value of the internal property.
     * 
     * @return
     *     possible object is
     *     {@link DocInternalType }
     *     
     */
    public DocInternalType getInternal() {
        return internal;
    }

    /**
     * Sets the value of the internal property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocInternalType }
     *     
     */
    public void setInternal(DocInternalType value) {
        this.internal = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

}
