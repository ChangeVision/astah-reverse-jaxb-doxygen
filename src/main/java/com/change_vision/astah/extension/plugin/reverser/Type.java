package com.change_vision.astah.extension.plugin.reverser;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.change_vision.astah.extension.plugin.common.NamespaceClass;

public class Type {
	private NamespaceClass namespaceClass;
	private String typeModifier = "";
	private String initialValue = "";
	private String visiblity = "";
	private boolean isStatic;
	private String definition = "";
	private String multiplicity = "";
	private String templates = "";
	private boolean isConst;

	private boolean isExplicit;
	private boolean isInline;
	private String virt;
	private boolean isFriend;

	private boolean isMutable;
	private boolean isVolatile;

	private String name = "";

	private String refId;

	public String getTemplateParameter() {
		return String.format("%s<%s>", namespaceClass.getFullName(), templates);
	}

	public NamespaceClass getNamespaceClass() {
		return namespaceClass;
	}

	public void setNamespaceClass(NamespaceClass namespaceClass) {
		this.namespaceClass = namespaceClass;
	}

	public String getTypeModifier() {
		return typeModifier;
	}

	public void setTypeModifier(String typeModifier) {
		this.typeModifier = typeModifier;
	}

	public String getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}

	public String getVisiblity() {
		return visiblity;
	}

	public void setVisiblity(String visiblity) {
		this.visiblity = visiblity;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(String multiplicity) {
		this.multiplicity = multiplicity;
	}

	public String getTemplates() {
		return templates;
	}

	public void setTemplates(String templates) {
		this.templates = templates;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public boolean isConst() {
		return isConst;
	}

	public void setConst(boolean isConst) {
		this.isConst = isConst;
	}

	public boolean isExplicit() {
		return isExplicit;
	}

	public void setExplicit(boolean isExplicit) {
		this.isExplicit = isExplicit;
	}

	public boolean isInline() {
		return isInline;
	}

	public void setInline(boolean isInline) {
		this.isInline = isInline;
	}

	public String getVirt() {
		return virt;
	}

	public void setVirt(String virt) {
		this.virt = virt;
	}

	public boolean isFriend() {
		return isFriend;
	}

	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}

	public boolean isMutable() {
		return isMutable;
	}

	public void setMutable(boolean isMutable) {
		this.isMutable = isMutable;
	}

	public boolean isVolatile() {
		return isVolatile;
	}

	public void setVolatile(boolean isVolatile) {
		this.isVolatile = isVolatile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
