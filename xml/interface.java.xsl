<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:lst="http://deneblingvo.org/xsd/transformator/list/1.0"
                xmlns:dst="http://deneblingvo.org/xsd/transformator/destination/1.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
            	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:java="http://deneblingvo.org/xsd/java/1.0"
				exclude-result-prefixes="#all">

	<xsl:template name="interface">
		<xsl:param name="name" />
		<xsl:param name="documentation" />
		<xsl:param name="content" />package org.deneblingvo.geneticist.settings;

/**
 * @author Алексей Кляузер &lt;drum@pisem.net&gt; 
 * <xsl:value-of select="$documentation" />
 */
<xsl:if test="$content/xsd:complexType/xsd:sequence[@minOccurs]/xsd:element">
import java.util.Vector;
</xsl:if>
public interface <xsl:value-of select="$name" /> {
<xsl:for-each select="$content/xsd:complexType/xsd:attribute">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public <xsl:value-of select="dst:type-name(@type,'')" /> get<xsl:value-of select="dst:upper-first(@name)" />();
</xsl:for-each>
<xsl:for-each select="xsd:sequence[not(@minOccurs)]/xsd:element">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public <xsl:value-of select="dst:type-name(@type,'')" /> get<xsl:value-of select="dst:upper-first(@name)" />();
</xsl:for-each>
<xsl:for-each select="xsd:sequence[@minOccurs]/xsd:element">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public Vector&lt;<xsl:value-of select="dst:type-name(@type,'')" />&gt; get<xsl:value-of select="dst:upper-first(@name)" />();
</xsl:for-each>

}</xsl:template>
</xsl:stylesheet>