//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.22 at 11:08:54 AM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_3_1.compound;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for locationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="locationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="file" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="line" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="bodyfile" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bodystart" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="bodyend" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "locationType")
public class LocationType {

    @XmlAttribute(name = "file")
    protected String file;
    @XmlAttribute(name = "line")
    protected BigInteger line;
    @XmlAttribute(name = "bodyfile")
    protected String bodyfile;
    @XmlAttribute(name = "bodystart")
    protected BigInteger bodystart;
    @XmlAttribute(name = "bodyend")
    protected BigInteger bodyend;

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFile(String value) {
        this.file = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLine(BigInteger value) {
        this.line = value;
    }

    /**
     * Gets the value of the bodyfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodyfile() {
        return bodyfile;
    }

    /**
     * Sets the value of the bodyfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodyfile(String value) {
        this.bodyfile = value;
    }

    /**
     * Gets the value of the bodystart property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBodystart() {
        return bodystart;
    }

    /**
     * Sets the value of the bodystart property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBodystart(BigInteger value) {
        this.bodystart = value;
    }

    /**
     * Gets the value of the bodyend property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBodyend() {
        return bodyend;
    }

    /**
     * Sets the value of the bodyend property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBodyend(BigInteger value) {
        this.bodyend = value;
    }

}
