//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.22 at 11:08:54 AM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_3_1.compound;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for docIndexEntryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docIndexEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primaryie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secondaryie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docIndexEntryType", propOrder = {
    "primaryie",
    "secondaryie"
})
public class DocIndexEntryType {

    @XmlElement(required = true)
    protected String primaryie;
    @XmlElement(required = true)
    protected String secondaryie;

    /**
     * Gets the value of the primaryie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryie() {
        return primaryie;
    }

    /**
     * Sets the value of the primaryie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryie(String value) {
        this.primaryie = value;
    }

    /**
     * Gets the value of the secondaryie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryie() {
        return secondaryie;
    }

    /**
     * Sets the value of the secondaryie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryie(String value) {
        this.secondaryie = value;
    }

}
