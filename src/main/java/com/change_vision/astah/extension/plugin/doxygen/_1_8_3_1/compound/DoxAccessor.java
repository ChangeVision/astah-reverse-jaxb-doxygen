//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.22 at 11:08:54 AM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_3_1.compound;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoxAccessor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxAccessor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="retain"/>
 *     &lt;enumeration value="copy"/>
 *     &lt;enumeration value="assign"/>
 *     &lt;enumeration value="weak"/>
 *     &lt;enumeration value="strong"/>
 *     &lt;enumeration value="unretained"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxAccessor")
@XmlEnum
public enum DoxAccessor {

    @XmlEnumValue("retain")
    RETAIN("retain"),
    @XmlEnumValue("copy")
    COPY("copy"),
    @XmlEnumValue("assign")
    ASSIGN("assign"),
    @XmlEnumValue("weak")
    WEAK("weak"),
    @XmlEnumValue("strong")
    STRONG("strong"),
    @XmlEnumValue("unretained")
    UNRETAINED("unretained");
    private final String value;

    DoxAccessor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxAccessor fromValue(String v) {
        for (DoxAccessor c: DoxAccessor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
