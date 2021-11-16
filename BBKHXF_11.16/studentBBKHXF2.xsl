<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Hallgatok apply-template</h2>
                    <xsl:for-each select="class/student">
                        <div>ID: <xsl:value-of select = "@id"/></div>
                        <div style="color:green">Vezetéknév:<xsl:apply-templates select="firstname"/></div>
                        <div style="color:brown">Keresztnév: <xsl:apply-templates select="Lastname"/></div>
                        <div style="color:blue">Becenév: <xsl:apply-templates select="nickname"/></div>
                        <div style="color:orange">Kor: <xsl:apply-templates select="age"/></div>
                        <div style="color:red">Fizetés: <xsl:apply-templates select="salary"/></div>
                        <br/>
                    </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>