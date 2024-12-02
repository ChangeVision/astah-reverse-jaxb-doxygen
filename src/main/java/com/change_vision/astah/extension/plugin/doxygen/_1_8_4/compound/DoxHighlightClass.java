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
 * <p>Java class for DoxHighlightClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoxHighlightClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="comment"/>
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="preprocessor"/>
 *     &lt;enumeration value="keyword"/>
 *     &lt;enumeration value="keywordtype"/>
 *     &lt;enumeration value="keywordflow"/>
 *     &lt;enumeration value="stringliteral"/>
 *     &lt;enumeration value="charliteral"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoxHighlightClass")
@XmlEnum
public enum DoxHighlightClass {

    @XmlEnumValue("comment")
    COMMENT("comment"),
    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("preprocessor")
    PREPROCESSOR("preprocessor"),
    @XmlEnumValue("keyword")
    KEYWORD("keyword"),
    @XmlEnumValue("keywordtype")
    KEYWORDTYPE("keywordtype"),
    @XmlEnumValue("keywordflow")
    KEYWORDFLOW("keywordflow"),
    @XmlEnumValue("stringliteral")
    STRINGLITERAL("stringliteral"),
    @XmlEnumValue("charliteral")
    CHARLITERAL("charliteral");
    private final String value;

    DoxHighlightClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoxHighlightClass fromValue(String v) {
        for (DoxHighlightClass c: DoxHighlightClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
