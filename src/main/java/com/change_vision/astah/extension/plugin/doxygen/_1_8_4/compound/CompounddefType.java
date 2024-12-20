//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.23 at 01:05:21 PM JST 
//


package com.change_vision.astah.extension.plugin.doxygen._1_8_4.compound;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for compounddefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="compounddefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="compoundname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basecompoundref" type="{}compoundRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="derivedcompoundref" type="{}compoundRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="includes" type="{}incType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="includedby" type="{}incType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="incdepgraph" type="{}graphType" minOccurs="0"/>
 *         &lt;element name="invincdepgraph" type="{}graphType" minOccurs="0"/>
 *         &lt;element name="innerdir" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innerfile" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innerclass" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innernamespace" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innerpage" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="innergroup" type="{}refType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="templateparamlist" type="{}templateparamlistType" minOccurs="0"/>
 *         &lt;element name="sectiondef" type="{}sectiondefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="briefdescription" type="{}descriptionType" minOccurs="0"/>
 *         &lt;element name="detaileddescription" type="{}descriptionType" minOccurs="0"/>
 *         &lt;element name="inheritancegraph" type="{}graphType" minOccurs="0"/>
 *         &lt;element name="collaborationgraph" type="{}graphType" minOccurs="0"/>
 *         &lt;element name="programlisting" type="{}listingType" minOccurs="0"/>
 *         &lt;element name="location" type="{}locationType" minOccurs="0"/>
 *         &lt;element name="listofallmembers" type="{}listofallmembersType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="kind" type="{}DoxCompoundKind" />
 *       &lt;attribute name="prot" type="{}DoxProtectionKind" />
 *       &lt;attribute name="final" type="{}DoxBool" />
 *       &lt;attribute name="sealed" type="{}DoxBool" />
 *       &lt;attribute name="abstract" type="{}DoxBool" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compounddefType", propOrder = {
    "compoundname",
    "title",
    "basecompoundref",
    "derivedcompoundref",
    "includes",
    "includedby",
    "incdepgraph",
    "invincdepgraph",
    "innerdir",
    "innerfile",
    "innerclass",
    "innernamespace",
    "innerpage",
    "innergroup",
    "templateparamlist",
    "sectiondef",
    "briefdescription",
    "detaileddescription",
    "inheritancegraph",
    "collaborationgraph",
    "programlisting",
    "location",
    "listofallmembers"
})
public class CompounddefType {

    @XmlElement(required = true)
    protected String compoundname;
    protected String title;
    protected List<CompoundRefType> basecompoundref;
    protected List<CompoundRefType> derivedcompoundref;
    protected List<IncType> includes;
    protected List<IncType> includedby;
    protected GraphType incdepgraph;
    protected GraphType invincdepgraph;
    protected List<RefType> innerdir;
    protected List<RefType> innerfile;
    protected List<RefType> innerclass;
    protected List<RefType> innernamespace;
    protected List<RefType> innerpage;
    protected List<RefType> innergroup;
    protected TemplateparamlistType templateparamlist;
    protected List<SectiondefType> sectiondef;
    protected DescriptionType briefdescription;
    protected DescriptionType detaileddescription;
    protected GraphType inheritancegraph;
    protected GraphType collaborationgraph;
    protected ListingType programlisting;
    protected LocationType location;
    protected ListofallmembersType listofallmembers;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "kind")
    protected DoxCompoundKind kind;
    @XmlAttribute(name = "prot")
    protected DoxProtectionKind prot;
    @XmlAttribute(name = "final")
    protected DoxBool _final;
    @XmlAttribute(name = "sealed")
    protected DoxBool sealed;
    @XmlAttribute(name = "abstract")
    protected DoxBool _abstract;

    /**
     * Gets the value of the compoundname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompoundname() {
        return compoundname;
    }

    /**
     * Sets the value of the compoundname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompoundname(String value) {
        this.compoundname = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the basecompoundref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the basecompoundref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBasecompoundref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompoundRefType }
     * 
     * 
     */
    public List<CompoundRefType> getBasecompoundref() {
        if (basecompoundref == null) {
            basecompoundref = new ArrayList<CompoundRefType>();
        }
        return this.basecompoundref;
    }

    /**
     * Gets the value of the derivedcompoundref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derivedcompoundref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerivedcompoundref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompoundRefType }
     * 
     * 
     */
    public List<CompoundRefType> getDerivedcompoundref() {
        if (derivedcompoundref == null) {
            derivedcompoundref = new ArrayList<CompoundRefType>();
        }
        return this.derivedcompoundref;
    }

    /**
     * Gets the value of the includes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncType }
     * 
     * 
     */
    public List<IncType> getIncludes() {
        if (includes == null) {
            includes = new ArrayList<IncType>();
        }
        return this.includes;
    }

    /**
     * Gets the value of the includedby property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedby property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedby().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncType }
     * 
     * 
     */
    public List<IncType> getIncludedby() {
        if (includedby == null) {
            includedby = new ArrayList<IncType>();
        }
        return this.includedby;
    }

    /**
     * Gets the value of the incdepgraph property.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    public GraphType getIncdepgraph() {
        return incdepgraph;
    }

    /**
     * Sets the value of the incdepgraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    public void setIncdepgraph(GraphType value) {
        this.incdepgraph = value;
    }

    /**
     * Gets the value of the invincdepgraph property.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    public GraphType getInvincdepgraph() {
        return invincdepgraph;
    }

    /**
     * Sets the value of the invincdepgraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    public void setInvincdepgraph(GraphType value) {
        this.invincdepgraph = value;
    }

    /**
     * Gets the value of the innerdir property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerdir property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerdir().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    public List<RefType> getInnerdir() {
        if (innerdir == null) {
            innerdir = new ArrayList<RefType>();
        }
        return this.innerdir;
    }

    /**
     * Gets the value of the innerfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    public List<RefType> getInnerfile() {
        if (innerfile == null) {
            innerfile = new ArrayList<RefType>();
        }
        return this.innerfile;
    }

    /**
     * Gets the value of the innerclass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerclass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerclass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    public List<RefType> getInnerclass() {
        if (innerclass == null) {
            innerclass = new ArrayList<RefType>();
        }
        return this.innerclass;
    }

    /**
     * Gets the value of the innernamespace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innernamespace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnernamespace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    public List<RefType> getInnernamespace() {
        if (innernamespace == null) {
            innernamespace = new ArrayList<RefType>();
        }
        return this.innernamespace;
    }

    /**
     * Gets the value of the innerpage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innerpage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnerpage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    public List<RefType> getInnerpage() {
        if (innerpage == null) {
            innerpage = new ArrayList<RefType>();
        }
        return this.innerpage;
    }

    /**
     * Gets the value of the innergroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the innergroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInnergroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefType }
     * 
     * 
     */
    public List<RefType> getInnergroup() {
        if (innergroup == null) {
            innergroup = new ArrayList<RefType>();
        }
        return this.innergroup;
    }

    /**
     * Gets the value of the templateparamlist property.
     * 
     * @return
     *     possible object is
     *     {@link TemplateparamlistType }
     *     
     */
    public TemplateparamlistType getTemplateparamlist() {
        return templateparamlist;
    }

    /**
     * Sets the value of the templateparamlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateparamlistType }
     *     
     */
    public void setTemplateparamlist(TemplateparamlistType value) {
        this.templateparamlist = value;
    }

    /**
     * Gets the value of the sectiondef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sectiondef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSectiondef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SectiondefType }
     * 
     * 
     */
    public List<SectiondefType> getSectiondef() {
        if (sectiondef == null) {
            sectiondef = new ArrayList<SectiondefType>();
        }
        return this.sectiondef;
    }

    /**
     * Gets the value of the briefdescription property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    public DescriptionType getBriefdescription() {
        return briefdescription;
    }

    /**
     * Sets the value of the briefdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    public void setBriefdescription(DescriptionType value) {
        this.briefdescription = value;
    }

    /**
     * Gets the value of the detaileddescription property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    public DescriptionType getDetaileddescription() {
        return detaileddescription;
    }

    /**
     * Sets the value of the detaileddescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    public void setDetaileddescription(DescriptionType value) {
        this.detaileddescription = value;
    }

    /**
     * Gets the value of the inheritancegraph property.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    public GraphType getInheritancegraph() {
        return inheritancegraph;
    }

    /**
     * Sets the value of the inheritancegraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    public void setInheritancegraph(GraphType value) {
        this.inheritancegraph = value;
    }

    /**
     * Gets the value of the collaborationgraph property.
     * 
     * @return
     *     possible object is
     *     {@link GraphType }
     *     
     */
    public GraphType getCollaborationgraph() {
        return collaborationgraph;
    }

    /**
     * Sets the value of the collaborationgraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphType }
     *     
     */
    public void setCollaborationgraph(GraphType value) {
        this.collaborationgraph = value;
    }

    /**
     * Gets the value of the programlisting property.
     * 
     * @return
     *     possible object is
     *     {@link ListingType }
     *     
     */
    public ListingType getProgramlisting() {
        return programlisting;
    }

    /**
     * Sets the value of the programlisting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListingType }
     *     
     */
    public void setProgramlisting(ListingType value) {
        this.programlisting = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLocation(LocationType value) {
        this.location = value;
    }

    /**
     * Gets the value of the listofallmembers property.
     * 
     * @return
     *     possible object is
     *     {@link ListofallmembersType }
     *     
     */
    public ListofallmembersType getListofallmembers() {
        return listofallmembers;
    }

    /**
     * Sets the value of the listofallmembers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListofallmembersType }
     *     
     */
    public void setListofallmembers(ListofallmembersType value) {
        this.listofallmembers = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link DoxCompoundKind }
     *     
     */
    public DoxCompoundKind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxCompoundKind }
     *     
     */
    public void setKind(DoxCompoundKind value) {
        this.kind = value;
    }

    /**
     * Gets the value of the prot property.
     * 
     * @return
     *     possible object is
     *     {@link DoxProtectionKind }
     *     
     */
    public DoxProtectionKind getProt() {
        return prot;
    }

    /**
     * Sets the value of the prot property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxProtectionKind }
     *     
     */
    public void setProt(DoxProtectionKind value) {
        this.prot = value;
    }

    /**
     * Gets the value of the final property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    public DoxBool getFinal() {
        return _final;
    }

    /**
     * Sets the value of the final property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    public void setFinal(DoxBool value) {
        this._final = value;
    }

    /**
     * Gets the value of the sealed property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    public DoxBool getSealed() {
        return sealed;
    }

    /**
     * Sets the value of the sealed property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    public void setSealed(DoxBool value) {
        this.sealed = value;
    }

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link DoxBool }
     *     
     */
    public DoxBool getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoxBool }
     *     
     */
    public void setAbstract(DoxBool value) {
        this._abstract = value;
    }

}
