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
 * <p>Java class for childnodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="childnodeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="edgelabel" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="refid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="relation" type="{}DoxGraphRelation" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "childnodeType", propOrder = {
    "edgelabel"
})
public class ChildnodeType {

    protected List<Object> edgelabel;
    @XmlAttribute(name = "refid")
    protected String refid;
    @XmlAttribute(name = "relation")
    protected DoxGraphRelation relation;

    /**
     * Gets the value of the edgelabel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edgelabel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdgelabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getEdgelabel() {
        if (edgelabel == null) {
            edgelabel = new ArrayList<Object>();
        }
        return this.edgelabel;
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
     * Gets the value of the relation property.
     * 
     * @return
     *     possible object is
     *     {@link DoxGraphRelation }
     *     
     */
    public DoxGraphRelation getRelation() {
        return relation;
    }

    /**
     * Sets the value of the relation property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxGraphRelation }
     *     
     */
    public void setRelation(DoxGraphRelation value) {
        this.relation = value;
    }

}
