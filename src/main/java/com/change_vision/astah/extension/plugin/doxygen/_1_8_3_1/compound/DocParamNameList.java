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
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for docParamNameList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docParamNameList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parametertype" type="{}docParamType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="parametername" type="{}docParamName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docParamNameList", propOrder = {
    "parametertype",
    "parametername"
})
public class DocParamNameList {

    protected List<DocParamType> parametertype;
    protected List<DocParamName> parametername;

    /**
     * Gets the value of the parametertype property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametertype property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametertype().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocParamType }
     * 
     * 
     */
    public List<DocParamType> getParametertype() {
        if (parametertype == null) {
            parametertype = new ArrayList<DocParamType>();
        }
        return this.parametertype;
    }

    /**
     * Gets the value of the parametername property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametername property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametername().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocParamName }
     * 
     * 
     */
    public List<DocParamName> getParametername() {
        if (parametername == null) {
            parametername = new ArrayList<DocParamName>();
        }
        return this.parametername;
    }

}
