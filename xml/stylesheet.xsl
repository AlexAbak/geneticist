<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:lst="http://deneblingvo.org/xsd/transformator/list/1.0"
                xmlns:dst="http://deneblingvo.org/xsd/transformator/destination/1.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
            	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:java="http://deneblingvo.org/xsd/java/1.0"
				exclude-result-prefixes="#all">

	<xsl:output method="xml" 
	            version="1.0"
	            indent="yes"
	            encoding="UTF-8"
	            undeclare-prefixes="no" />

	<xsl:namespace-alias result-prefix="#default" stylesheet-prefix="#default"/>

	<xsl:function name="dst:upper-first">
		<xsl:param name="sentence" as="xsd:string"/>
		<xsl:sequence select="concat(upper-case(substring($sentence,1,1)),substring($sentence,2))"/>
	</xsl:function>

	<xsl:function name="dst:type-name">
		<xsl:param name="sentence" as="xsd:string"/>
		<xsl:sequence select="dst:upper-first(substring-after($sentence,':'))"/>
	</xsl:function>

	<xsl:template match="/">
		<xsl:element
			name="dst:destination"
			namespace="http://deneblingvo.org/xsd/transformator/destination/1.0">
			<xsl:element
				name="dst:file"
				namespace="http://deneblingvo.org/xsd/transformator/destination/1.0">
				<xsl:attribute name="href">../package/src/org/deneblingvo/geneticist/settings/package-info.java</xsl:attribute>
				<xsl:attribute name="text">true</xsl:attribute>
/**
 * @author Алексей Кляузер &lt;drum@pisem.net&gt; 
 * <xsl:value-of select="lst:list/xsd:schema/xsd:element/xsd:annotation/xsd:documentation" />
 */
package org.deneblingvo.geneticist.settings;
			</xsl:element>
			<xsl:for-each select="lst:list/xsd:schema/xsd:complexType">
				<xsl:element
					name="dst:file"
					namespace="http://deneblingvo.org/xsd/transformator/destination/1.0">
					<xsl:attribute name="href">../package/src/org/deneblingvo/geneticist/settings/<xsl:value-of select="dst:upper-first(@name)" />.java</xsl:attribute>
					<xsl:attribute name="text">true</xsl:attribute>
package org.deneblingvo.geneticist.settings;
					<xsl:if test="xsd:sequence[@minOccurs]/xsd:element">
import java.util.Vector;
					</xsl:if>
/**
 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
 * @author Алексей Кляузер &lt;drum@pisem.net&gt;
 */
public interface <xsl:value-of select="dst:upper-first(@name)" /> {
					<xsl:for-each select="xsd:attribute">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public <xsl:value-of select="dst:type-name(@type)" /> get<xsl:value-of select="dst:upper-first(@name)" />();
					</xsl:for-each>
					<xsl:for-each select="xsd:sequence[not(@minOccurs)]/xsd:element">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public <xsl:value-of select="dst:type-name(@type)" /> get<xsl:value-of select="dst:upper-first(@name)" />();
					</xsl:for-each>
					<xsl:for-each select="xsd:sequence[@minOccurs]/xsd:element">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public Vector&lt;<xsl:value-of select="dst:type-name(@type)" />&gt; get<xsl:value-of select="dst:upper-first(@name)" />();
					</xsl:for-each>
}
				</xsl:element>
			</xsl:for-each>
			<xsl:element
				name="dst:file"
				namespace="http://deneblingvo.org/xsd/transformator/destination/1.0">
				<xsl:attribute name="href">../package/src/org/deneblingvo/geneticist/settings/xml/package-info.java</xsl:attribute>
				<xsl:attribute name="text">true</xsl:attribute>
/**
 * @author Алексей Кляузер &lt;drum@pisem.net&gt; 
 * <xsl:value-of select="lst:list/xsd:schema/xsd:element/xsd:annotation/xsd:documentation" />
 */
package org.deneblingvo.geneticist.settings.xml;
			</xsl:element>
			<xsl:for-each select="lst:list/xsd:schema/xsd:complexType">
				<xsl:element
					name="dst:file"
					namespace="http://deneblingvo.org/xsd/transformator/destination/1.0">
					<xsl:attribute name="href">../package/src/org/deneblingvo/geneticist/settings/xml/<xsl:value-of select="dst:upper-first(@name)" />Xml.java</xsl:attribute>
					<xsl:attribute name="text">true</xsl:attribute>
package org.deneblingvo.geneticist.settings.xml;
					<xsl:if test="xsd:sequence[@minOccurs]/xsd:element">
import java.util.Vector;
					</xsl:if>
import org.deneblingvo.geneticist.settings.*;
/**
 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
 * @author Алексей Кляузер &lt;drum@pisem.net&gt;
 */
public class <xsl:value-of select="dst:upper-first(@name)" />Xml implements <xsl:value-of select="dst:upper-first(@name)" /> {
					<xsl:for-each select="xsd:attribute">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public <xsl:value-of select="dst:type-name(@type)" /> get<xsl:value-of select="dst:upper-first(@name)" />();
					</xsl:for-each>
					<xsl:for-each select="xsd:sequence[not(@minOccurs)]/xsd:element">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public <xsl:value-of select="dst:type-name(@type)" /> get<xsl:value-of select="dst:upper-first(@name)" />();
					</xsl:for-each>
					<xsl:for-each select="xsd:sequence[@minOccurs]/xsd:element">
	/**
	 * <xsl:value-of select="xsd:annotation/xsd:documentation" />
	 */
	public Vector&lt;<xsl:value-of select="dst:type-name(@type)" />&gt; get<xsl:value-of select="dst:upper-first(@name)" />();
					</xsl:for-each>
}
				</xsl:element>
			</xsl:for-each>
		</xsl:element>
	</xsl:template>

</xsl:stylesheet>