//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.22 at 11:08:54 AM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_3_1.compound;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for refTextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="refTextType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="refid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="kindref" type="{}DoxRefKind" />
 *       &lt;attribute name="external" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tooltip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refTextType", propOrder = {
    "value"
})
public class RefTextType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "refid")
    protected String refid;
    @XmlAttribute(name = "kindref")
    protected DoxRefKind kindref;
    @XmlAttribute(name = "external")
    protected String external;
    @XmlAttribute(name = "tooltip")
    protected String tooltip;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the refid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefid() {
        return refid;
    }

    /**
     * Sets the value of the refid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefid(String value) {
        this.refid = value;
    }

    /**
     * Gets the value of the kindref property.
     * 
     * @return
     *     possible object is
     *     {@link DoxRefKind }
     *     
     */
    public DoxRefKind getKindref() {
        return kindref;
    }

    /**
     * Sets the value of the kindref property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxRefKind }
     *     
     */
    public void setKindref(DoxRefKind value) {
        this.kindref = value;
    }

    /**
     * Gets the value of the external property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternal() {
        return external;
    }

    /**
     * Sets the value of the external property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternal(String value) {
        this.external = value;
    }

    /**
     * Gets the value of the tooltip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * Sets the value of the tooltip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTooltip(String value) {
        this.tooltip = value;
    }

}
