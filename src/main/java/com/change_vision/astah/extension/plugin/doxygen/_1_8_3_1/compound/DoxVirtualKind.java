//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.22 at 11:08:54 AM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_3_1.compound;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxVirtualKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxVirtualKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="non-virtual"/>
 *     &lt;enumeration value="virtual"/>
 *     &lt;enumeration value="pure-virtual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxVirtualKind")
@XmlEnum
public enum DoxVirtualKind {

    @XmlEnumValue("non-virtual")
    NON_VIRTUAL("non-virtual"),
    @XmlEnumValue("virtual")
    VIRTUAL("virtual"),
    @XmlEnumValue("pure-virtual")
    PURE_VIRTUAL("pure-virtual");
    private final String value;

    DoxVirtualKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxVirtualKind fromValue(String v) {
        for (DoxVirtualKind c: DoxVirtualKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
