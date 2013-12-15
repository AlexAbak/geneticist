<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:lst="http://deneblingvo.org/xsd/transformator/list/1.0"
                xmlns:dst="http://deneblingvo.org/xsd/transformator/destination/1.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
            	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:java="http://deneblingvo.org/xsd/java/1.0"
				exclude-result-prefixes="#all">

	<xsl:template name="package-info">
		<xsl:param name="name" />
		<xsl:param name="documentation" />/**
 * @author Алексей Кляузер &lt;drum@pisem.net&gt; 
 * <xsl:value-of select="$documentation" />
 */
package <xsl:value-of select="$name" />;</xsl:template>
</xsl:stylesheet>