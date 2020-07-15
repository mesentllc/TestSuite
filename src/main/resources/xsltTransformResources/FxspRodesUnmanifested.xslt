<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ns2="http://smartpost.fedex.com/schemas/common/postal"
                xmlns:ns3="http://smartpost.fedex.com/schemas/common/postal/parcel"
                xmlns:rus="http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent"
                xmlns:ros="http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent">

    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

    <xsl:variable name="eventDate" select="substring(/ns3:UspsPostage/Unmanifested/EventDate,1,19)"/>
    <xsl:variable name="channelApplicatonId" select="substring(/ns3:UspsPostage/ApplId,1,2)"/>
    <xsl:variable name="packageId" select="substring(/ns3:UspsPostage/PackageId,1,50)"/>
    <xsl:variable name="weight">
        <xsl:call-template name="checkDecimalValue">
            <xsl:with-param name="decimalValue" select="/ns3:UspsPostage/Weight"/>
            <xsl:with-param name="precisionWidth">5</xsl:with-param>
        </xsl:call-template>
    </xsl:variable>
    <xsl:variable name="unmanifestStatus">
        <xsl:value-of select="substring(/ns3:UspsPostage/Unmanifested/Status,1,2)"/>
    </xsl:variable>

    <xsl:variable name="PKG_EVENT_TYPE_CD">UNMANIFESTED</xsl:variable>
    <xsl:variable name="LESS_THAN">&lt;</xsl:variable>
    <xsl:variable name="GREATER_THAN">&gt;</xsl:variable>
    <xsl:variable name="OVERSIZE">O</xsl:variable>
    <xsl:variable name="BALLOON">B</xsl:variable>
    <xsl:variable name="NORMAL">N</xsl:variable>
    <xsl:variable name="SA">SA</xsl:variable>
    <xsl:variable name="BP">BP</xsl:variable>
    <xsl:variable name="TRUE">true</xsl:variable>
    <xsl:variable name="FALSE">false</xsl:variable>
    <xsl:variable name="US">US</xsl:variable>
    <xsl:variable name="UP">UP</xsl:variable>
    <xsl:variable name="TU">TU</xsl:variable>
    <xsl:variable name="DATE_REG_EXP_IN">0123456789Z-\</xsl:variable>

    <xsl:template match="/ns3:UspsPostage">
        <rus:UnmanifestedPackageEvent>
            <ros:FedexPkgId>
                <xsl:value-of select="$packageId"/>
            </ros:FedexPkgId>
            <ros:ChanlAppId>
                <xsl:value-of select="$channelApplicatonId"/>
            </ros:ChanlAppId>
            <ros:MailerId>
                <xsl:value-of select="substring(Unmanifested/MailerId,1,9)"/>
            </ros:MailerId>
            <ros:SpPkgWgt>
                <xsl:value-of select="$weight"/>
            </ros:SpPkgWgt>
            <ros:EventDate>
                <xsl:call-template name="convertEventDateToTimeStamp"/>
            </ros:EventDate>
            <ros:SpPkgLength>
                <xsl:call-template name="checkDecimalValue">
                    <xsl:with-param name="decimalValue" select="Length"/>
                    <xsl:with-param name="precisionWidth">5</xsl:with-param>
                </xsl:call-template>
            </ros:SpPkgLength>
            <ros:SpPkgWidth>
                <xsl:call-template name="checkDecimalValue">
                    <xsl:with-param name="decimalValue" select="Width"/>
                    <xsl:with-param name="precisionWidth">5</xsl:with-param>
                </xsl:call-template>
            </ros:SpPkgWidth>
            <ros:SpPkgHgt>
                <xsl:call-template name="checkDecimalValue">
                    <xsl:with-param name="decimalValue" select="Height"/>
                    <xsl:with-param name="precisionWidth">5</xsl:with-param>
                </xsl:call-template>
            </ros:SpPkgHgt>
            <ros:DestinationSortCode>
                <xsl:value-of select="substring(DestinationSortCode,1,13)"/>
            </ros:DestinationSortCode>
            <ros:HubCd>
                <xsl:value-of select="substring(ns2:HubId,1,4)"/>
            </ros:HubCd>
            <ros:PstlClass>
                <xsl:call-template name="changeMailClassBasedOnWeight">
                    <xsl:with-param name="mailClassValue" select="substring(UspsMailClass,1,2)"/>
                </xsl:call-template>
            </ros:PstlClass>
            <ros:PkgCategoryCd>
                <xsl:value-of select="translate(substring(UspsProcessingCategory,1,1),'345','MII')"/>
            </ros:PkgCategoryCd>
            <ros:PkgTypeCd>
                <xsl:call-template name="translatePkgTypeCd">
                    <xsl:with-param name="balloonValue" select="Balloon"/>
                    <xsl:with-param name="oversizeValue" select="Oversize"/>
                </xsl:call-template>
            </ros:PkgTypeCd>
            <ros:PostalCode>
                <xsl:value-of select="substring(DestinationSortCode,1,13)"/>
            </ros:PostalCode>
            <ros:MsgValuesForHashId>
                <xsl:value-of select="concat($LESS_THAN,'PkgEventTypeCd',$GREATER_THAN)"/><xsl:value-of select="$PKG_EVENT_TYPE_CD"/><xsl:value-of
                    select="concat($LESS_THAN,'/PkgEventTypeCd',$GREATER_THAN)"/>
                <xsl:value-of select="concat($LESS_THAN,'EventDate',$GREATER_THAN)"/><xsl:value-of select="$eventDate"/><xsl:value-of
                    select="concat($LESS_THAN,'/EventDate',$GREATER_THAN)"/>
                <xsl:value-of select="concat($LESS_THAN,'FedexPkgId',$GREATER_THAN)"/><xsl:value-of select="$packageId"/><xsl:value-of
                    select="concat($LESS_THAN,'/FedexPkgId',$GREATER_THAN)"/>
            </ros:MsgValuesForHashId>

            <rus:ScanFacilityPostalCode>NA</rus:ScanFacilityPostalCode>
            <rus:ReleaseTypeCode>
                <xsl:value-of select="substring(ReleaseTypeCode,1,1)"/>
            </rus:ReleaseTypeCode>
            <rus:UnmanifestedStatus>
                <xsl:value-of select="$unmanifestStatus"/>
            </rus:UnmanifestedStatus>
            <rus:PostageAmount>
                <xsl:call-template name="checkDecimalValue">
                    <xsl:with-param name="decimalValue" select="Unmanifested/PostageAmount"/>
                    <xsl:with-param name="precisionWidth">3</xsl:with-param>
                </xsl:call-template>
            </rus:PostageAmount>
            <rus:ClientName>
                <xsl:call-template name="validateClientName">
                    <xsl:with-param name="clientName" select="substring(Unmanifested/ClientName,1,50)"/>
                </xsl:call-template>
            </rus:ClientName>
            <rus:PTSTransmissionDate>
                <xsl:call-template name="convertDateToOracleDate">
                    <xsl:with-param name="dateInput" select="substring(Unmanifested/PTSTransmissionDate,1,30)"/>
                </xsl:call-template>
            </rus:PTSTransmissionDate>
            <rus:ScanDate>
                <xsl:call-template name="convertDateToOracleDate">
                    <xsl:with-param name="dateInput" select="$eventDate"/>
                </xsl:call-template>
            </rus:ScanDate>
            <rus:UnmanifestMailClass>
                <xsl:value-of select="substring(Unmanifested/MailClass,1,2)"/>
            </rus:UnmanifestMailClass>

            <rus:StoreOrderCreateEventEnable>
                <xsl:call-template name="checkWhetherToStoreOrderCreateEvent"/>
            </rus:StoreOrderCreateEventEnable>
            <rus:StoreUnmanifestEventEnableIfNoStatusExistsInTable>
                <xsl:call-template name="checkWhetherToStoreUnmanifestEventIfNoStatusExistsInTable"/>
            </rus:StoreUnmanifestEventEnableIfNoStatusExistsInTable>
            <rus:StoreUnmanifestEventEnableIfStatusIsUPinTable>
                <xsl:call-template name="checkWhetherToStoreUnmanifestEventIfStatusIsUPinTable"/>
            </rus:StoreUnmanifestEventEnableIfStatusIsUPinTable>
            <rus:StorePackageEventEnable>
                <xsl:call-template name="checkWhetherToStorePackageEvent"/>
            </rus:StorePackageEventEnable>
            <rus:CheckPkgIdInBpTableEnable>
                <xsl:call-template name="checkWhetherToCheckPkgIdInBpAndBphTables"/>
            </rus:CheckPkgIdInBpTableEnable>

            <ros:PkgEventTypeCd>
                <xsl:value-of select="$PKG_EVENT_TYPE_CD"/>
            </ros:PkgEventTypeCd>
            <ros:SavingErrorMessageEnable>true</ros:SavingErrorMessageEnable>
            <ros:SavingBadMessageEnable>true</ros:SavingBadMessageEnable>
            <ros:MessageAccepted>
                <xsl:call-template name="checkWhetherMessageIsAccepted"/>
            </ros:MessageAccepted>
            <ros:PkgEventStatusCd>NEW</ros:PkgEventStatusCd>
            <ros:Identity>RODES-UNMAN-</ros:Identity>
            <ros:TicklePublisherParmName>Unmanifested.TicklePublisherEnable</ros:TicklePublisherParmName>
        </rus:UnmanifestedPackageEvent>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="checkWhetherToCheckPkgIdInBpAndBphTables">
        <xsl:choose>
            <xsl:when test="$unmanifestStatus = 'UP'">
                <xsl:value-of select="$TRUE"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$FALSE"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="checkWhetherToStorePackageEvent">
        <xsl:choose>
            <xsl:when test="$unmanifestStatus = 'US'">
                <xsl:value-of select="$TRUE"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$FALSE"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="checkWhetherMessageIsAccepted">
        <xsl:choose>
            <xsl:when test="$unmanifestStatus = 'TU' or $unmanifestStatus = 'US' or $unmanifestStatus = 'UP'">
                <xsl:value-of select="$TRUE"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$FALSE"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="checkWhetherToStoreUnmanifestEventIfStatusIsUPinTable">
        <xsl:choose>
            <xsl:when test="$unmanifestStatus = 'TU' or $unmanifestStatus = 'US'">
                <xsl:value-of select="$TRUE"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$FALSE"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="checkWhetherToStoreUnmanifestEventIfNoStatusExistsInTable">
        <xsl:choose>
            <xsl:when test="$unmanifestStatus = 'UP' or $unmanifestStatus = 'TU' or $unmanifestStatus = 'US'">
                <xsl:value-of select="$TRUE"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$FALSE"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="checkWhetherToStoreOrderCreateEvent">
        <xsl:choose>
            <xsl:when test="$unmanifestStatus = 'UP' or $unmanifestStatus = 'TU'">
                <xsl:value-of select="$TRUE"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$FALSE"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="validateClientName">
        <xsl:param name="clientName"/>
        <xsl:variable name="REG_EXP_IN">0123456789 abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.&amp;#/-\</xsl:variable>
        <xsl:variable name="clientNameTrimmed" select="normalize-space($clientName)"/>
        <xsl:choose>
            <xsl:when test="$clientNameTrimmed != ''">
                <xsl:variable name="clientNameResult" select="translate($clientNameTrimmed, $REG_EXP_IN,'')"/>
                <xsl:choose>
                    <xsl:when test="string-length($clientNameResult) = 0">
                        <xsl:value-of select="$clientNameTrimmed"/>
                    </xsl:when>
                </xsl:choose>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="checkDecimalValue">
        <xsl:param name="decimalValue"/>
        <xsl:param name="precisionWidth"/>
        <xsl:variable name="decimalValueTrimmed" select="normalize-space($decimalValue)"/>
        <xsl:variable name="ZERO">0.0</xsl:variable>
        <xsl:choose>
            <xsl:when test="$decimalValueTrimmed != '' and number($decimalValueTrimmed) > 0">
                <xsl:value-of select="number($decimalValue)"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$ZERO"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="translatePkgTypeCd">
        <xsl:param name="balloonValue"/>
        <xsl:param name="oversizeValue"/>
        <xsl:variable name="balloonTrimmed" select="normalize-space($balloonValue)"/>
        <xsl:variable name="oversizeTrimmed" select="normalize-space($oversizeValue)"/>
        <xsl:choose>
            <xsl:when test="$oversizeTrimmed != '' and $oversizeTrimmed = 'true'">
                <xsl:value-of select="$OVERSIZE"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:choose>
                    <xsl:when test="$balloonTrimmed != '' and $balloonTrimmed = 'true'">
                        <xsl:value-of select="$BALLOON"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="$NORMAL"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="changeMailClassBasedOnWeight">
        <xsl:param name="mailClassValue"/>
        <xsl:variable name="mailClassTrimmed" select="normalize-space(substring($mailClassValue,1,2))"/>
        <xsl:choose>
            <xsl:when test="$mailClassTrimmed != ''">
                <xsl:choose>
                    <xsl:when
                            test="($mailClassTrimmed = 'BP' or $mailClassTrimmed = 'LW' or $mailClassTrimmed = 'SA') and number($weight) > 0 and 1 > number($weight)">
                        <xsl:value-of select="$SA"/>
                    </xsl:when>
                    <xsl:when test="($mailClassTrimmed = 'AP' or $mailClassTrimmed = 'LW' or $mailClassTrimmed = 'SA') and number($weight) >= 1">
                        <xsl:value-of select="$BP"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="$mailClassTrimmed"/>
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$BP"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="convertEventDateToTimeStamp">
        <xsl:variable name="eventDateTrimmed" select="normalize-space($eventDate)"/>
        <xsl:choose>
            <xsl:when test="$eventDateTrimmed != '' and translate($eventDateTrimmed, $DATE_REG_EXP_IN,'') = ''">
                <xsl:value-of select="concat(substring-before($eventDateTrimmed, 'Z'), 'T')"/>
            </xsl:when>
            <xsl:when test="$eventDateTrimmed != ''">
                <xsl:value-of select="$eventDateTrimmed"/>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
    <xsl:template name="convertDateToOracleDate">
        <xsl:param name="dateInput"/>
        <xsl:variable name="dateTrimmed" select="normalize-space($dateInput)"/>
        <xsl:choose>
            <xsl:when test="$dateTrimmed != '' and translate($dateTrimmed, $DATE_REG_EXP_IN,'') = ''">
                <xsl:value-of select="substring-before($dateTrimmed, 'Z')"/>
            </xsl:when>
            <xsl:when test="$dateTrimmed != ''">
                <xsl:value-of select="$dateTrimmed"/>
            </xsl:when>
        </xsl:choose>
    </xsl:template>
    <!-- ======================================= -->
</xsl:stylesheet>