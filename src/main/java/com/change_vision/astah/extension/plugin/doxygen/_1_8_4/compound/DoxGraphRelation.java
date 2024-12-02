//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.23 at 01:05:21 PM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxGraphRelation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxGraphRelation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="include"/>
 *     &lt;enumeration value="usage"/>
 *     &lt;enumeration value="template-instance"/>
 *     &lt;enumeration value="public-inheritance"/>
 *     &lt;enumeration value="protected-inheritance"/>
 *     &lt;enumeration value="private-inheritance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxGraphRelation")
@XmlEnum
public enum DoxGraphRelation {

    @XmlEnumValue("include")
    INCLUDE("include"),
    @XmlEnumValue("usage")
    USAGE("usage"),
    @XmlEnumValue("template-instance")
    TEMPLATE_INSTANCE("template-instance"),
    @XmlEnumValue("public-inheritance")
    PUBLIC_INHERITANCE("public-inheritance"),
    @XmlEnumValue("protected-inheritance")
    PROTECTED_INHERITANCE("protected-inheritance"),
    @XmlEnumValue("private-inheritance")
    PRIVATE_INHERITANCE("private-inheritance");
    private final String value;

    DoxGraphRelation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxGraphRelation fromValue(String v) {
        for (DoxGraphRelation c: DoxGraphRelation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
