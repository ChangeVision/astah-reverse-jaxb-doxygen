//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.23 at 01:05:21 PM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for docHeadingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="docHeadingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{}docTitleCmdGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "docHeadingType", propOrder = {
    "content"
})
public class DocHeadingType {

    @XmlElementRefs({
        @XmlElementRef(name = "mdash", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lceil", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "aelig", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "omega", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sigmaf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "prop", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "larr", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "szlig", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "formula", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "acute", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "phi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcPhi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "plusmn", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "latexonly", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "subscript", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "iota", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "beta", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cedil", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "xi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "tau", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "mu", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "times", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "epsilon", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcDelta", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "grave", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lsquo", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcPi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "manonly", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rfloor", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "prime", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "trademark", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcXi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcTheta", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "copy", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "htmlonly", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "tilde", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcLambda", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "slash", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "superscript", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "dot", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "computeroutput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sigma", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "delta", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "nu", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rarr", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "le", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lambda", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcUpsilon", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ring", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rtfonly", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ulink", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcOmega", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rdquo", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "prod", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AElig", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "registered", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rceil", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rsquo", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "psi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "asymp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sdot", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "circ", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "alpha", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "center", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "int", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "anchor", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lfloor", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "emphasis", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "small", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "zeta", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "nonbreakablespace", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "xmlonly", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "chi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sum", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "upsilon", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "equiv", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "theta", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sim", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "notin", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcPsi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcGamma", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sect", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "minus", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "kappa", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ge", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ref", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "radic", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ne", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "isin", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcPrime", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ndash", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gamma", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "pi", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "deg", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "part", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "umlaut", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "nabla", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UcSigma", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "eta", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rho", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "infin", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "empty", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ldquo", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bold", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "perp", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "level")
    protected BigInteger level;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocFormulaType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCharType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCharType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCharType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCharType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCharType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCharType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DocURLLink }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCharType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocAnchorType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocRefTextType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocCharType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocMarkupType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocEmptyType }{@code >}
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLevel(BigInteger value) {
        this.level = value;
    }

}
