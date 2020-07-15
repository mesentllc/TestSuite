package com.mesentllc.transformer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class PackageEvent {

	@XmlElement(name = "ChanlAppId", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String chanlAppId;
	@XmlElement(name = "FedexPkgId", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String fedexPkgId;
	@XmlElement(name = "AlterPkgId", namespace = "http://smartpost.fedex.com/schemas/RodesOutboundSubscriber/FxspRodesPackageEvent")
	private String alterPkgId;
	@XmlElement(name = "AlterPkgIdTypeCd", namespace = "http://smartpost.fedex.com/schemas/RodesOutboundSubscriber/FxspRodesPackageEvent")
	private String alterPkgIdTypeCd;
	@XmlElement(name = "PostalCode", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String postalCode;
	@XmlElement(name = "ContainerId", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String containerId;
	@XmlElement(name = "MailerId", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String mailerId;
	@XmlElement(name = "SpPkgWgt", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private BigDecimal spPkgWgt;
	@XmlElement(name = "SpPkgLength", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private BigDecimal spPkgLength;
	@XmlElement(name = "SpPkgWidth", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private BigDecimal spPkgWidth;
	@XmlElement(name = "SpPkgHgt", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private BigDecimal spPkgHgt;
	@XmlElement(name = "SpWgtSrc", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String spWgtSrc;
	@XmlElement(name = "SpDimSrc", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String spDimSrc;
	@XmlElement(name = "PkgCategoryCd", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String pkgCategoryCd;
	@XmlElement(name = "PkgTypeCd", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String pkgTypeCd;
	@XmlElement(name = "PstlClass", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String pstlClass;
	@XmlElement(name = "EventDate", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String eventDate;
	@XmlElement(name = "HubCd", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String hubCd;
	@XmlElement(name = "FedexCustAcctNbr", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private Integer fedexCustAcctNbr;
	@XmlElement(name = "PkgEventTypeCd", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String pkgEventTypeCd;
	@XmlElement(name = "PkgEventStatusCd", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String pkgEventStatusCd;
	@XmlElement(name = "EventCode", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String EventCode;
	@XmlElement(name = "SavingBadMessageEnable", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private boolean savingBadMessageEnable;
	@XmlElement(name = "SavingErrorMessageEnable", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private boolean savingErrorMessageEnable;
	@XmlElement(name = "Identity", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String identity;
	@XmlElement(name = "MsgValuesForHashId", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String msgValuesForHashId;
	@XmlElement(name = "MessageAccepted", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private boolean messageAccepted;
	@XmlElement(name = "LocationCode", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String locationCode;
	@XmlElement(name = "EventReasonCode", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String eventReasonCode;
	@XmlElement(name = "EventDateValid", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private boolean eventDateValid;
	@XmlElement(name = "TicklePublisherParmName", namespace = "http://smartpost.fedex.com/schemas/RodesRodesOutboundSubscriber/FxspRodesPackageEvent")
	private String ticklePublisherParmName;

	private String originalXmlMessage;
	private String eventHashId;
	private boolean OrderCreateExisted;
	private Long sequence;

	public String getChanlAppId() {
		return chanlAppId;
	}

	public void setChanlAppId(String chanlAppId) {
		this.chanlAppId = chanlAppId;
	}

	public String getFedexPkgId() {
		return fedexPkgId;
	}

	public void setFedexPkgId(String fedexPkgId) {
		this.fedexPkgId = fedexPkgId;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getContainerId() {
		return containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public String getMailerId() {
		return mailerId;
	}

	public void setMailerId(String mailerId) {
		this.mailerId = mailerId;
	}

	public BigDecimal getSpPkgWgt() {
		return spPkgWgt;
	}

	public void setSpPkgWgt(BigDecimal spPkgWgt) {
		this.spPkgWgt = spPkgWgt;
	}

	public BigDecimal getSpPkgLength() {
		return spPkgLength;
	}

	public void setSpPkgLength(BigDecimal spPkgLength) {
		this.spPkgLength = spPkgLength;
	}

	public BigDecimal getSpPkgWidth() {
		return spPkgWidth;
	}

	public void setSpPkgWidth(BigDecimal spPkgWidth) {
		this.spPkgWidth = spPkgWidth;
	}

	public BigDecimal getSpPkgHgt() {
		return spPkgHgt;
	}

	public void setSpPkgHgt(BigDecimal spPkgHgt) {
		this.spPkgHgt = spPkgHgt;
	}

	public String getSpWgtSrc() {
		return spWgtSrc;
	}

	public void setSpWgtSrc(String spWgtSrc) {
		this.spWgtSrc = spWgtSrc;
	}

	public String getSpDimSrc() {
		return spDimSrc;
	}

	public void setSpDimSrc(String spDimSrc) {
		this.spDimSrc = spDimSrc;
	}

	public String getPkgCategoryCd() {
		return pkgCategoryCd;
	}

	public void setPkgCategoryCd(String pkgCategoryCd) {
		this.pkgCategoryCd = pkgCategoryCd;
	}

	public String getPkgTypeCd() {
		return pkgTypeCd;
	}

	public void setPkgTypeCd(String pkgTypeCd) {
		this.pkgTypeCd = pkgTypeCd;
	}

	public String getPstlClass() {
		return pstlClass;
	}

	public void setPstlClass(String pstlClass) {
		this.pstlClass = pstlClass;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getHubCd() {
		return hubCd;
	}

	public void setHubCd(String hubCd) {
		this.hubCd = hubCd;
	}

	public Integer getFedexCustAcctNbr() {
		return fedexCustAcctNbr;
	}

	public void setFedexCustAcctNbr(Integer fedexCustAcctNbr) {
		this.fedexCustAcctNbr = fedexCustAcctNbr;
	}

	public String getPkgEventStatusCd() {
		return pkgEventStatusCd;
	}

	public void setPkgEventStatusCd(String pkgEventStatusCd) {
		this.pkgEventStatusCd = pkgEventStatusCd;
	}

	public void setPkgEventTypeCd(String pkgEventTypeCd) {
		this.pkgEventTypeCd = pkgEventTypeCd;
	}

	public String getPkgEventTypeCd() {
		return pkgEventTypeCd;
	}

	public String getEventCode() {
		return EventCode;
	}

	public void setEventCode(String eventCode) {
		EventCode = eventCode;
	}

	public void setOriginalXmlMessage(String originalXmlMessage) {
		this.originalXmlMessage = originalXmlMessage;
	}

	public String getOriginalXmlMessage() {
		return originalXmlMessage;
	}

	public void setMessageAccepted(boolean messageAccepted) {
		this.messageAccepted = messageAccepted;
	}

	public boolean isMessageAccepted() {
		return messageAccepted;
	}

	public void setSavingBadMessageEnable(boolean savingBadMessageEnable) {
		this.savingBadMessageEnable = savingBadMessageEnable;
	}

	public boolean isSavingBadMessageEnable() {
		return savingBadMessageEnable;
	}

	public void setSavingErrorMessageEnable(boolean savingErrorMessageEnable) {
		this.savingErrorMessageEnable = savingErrorMessageEnable;
	}

	public boolean isSavingErrorMessageEnable() {
		return savingErrorMessageEnable;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setEventReasonCode(String eventReasonCode) {
		this.eventReasonCode = eventReasonCode;
	}

	public String getEventReasonCode() {
		return eventReasonCode;
	}

	public void setOrderCreateExisted(boolean orderCreateExisted) {
		OrderCreateExisted = orderCreateExisted;
	}

	public boolean isOrderCreateExisted() {
		return OrderCreateExisted;
	}

	public void setEventDateValid(boolean eventDateValid) {
		this.eventDateValid = eventDateValid;
	}

	public boolean isEventDateValid() {
		return eventDateValid;
	}

	public void setAlterPkgId(String alterPkgId) {
		this.alterPkgId = alterPkgId;
	}

	public String getAlterPkgId() {
		return alterPkgId;
	}

	public void setAlterPkgIdTypeCd(String alterPkgIdTypeCd) {
		this.alterPkgIdTypeCd = alterPkgIdTypeCd;
	}

	public String getAlterPkgIdTypeCd() {
		return alterPkgIdTypeCd;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public String getMsgValuesForHashId() {
		return msgValuesForHashId;
	}

	public void setMsgValuesForHashId(String msgValuesForHashId) {
		this.msgValuesForHashId = msgValuesForHashId;
	}

	public String getEventHashId() {
		return eventHashId;
	}

	public void setEventHashId(String eventHashId) {
		this.eventHashId = eventHashId;
	}

	public void setTicklePublisherParmName(String ticklePublisherParmName) {
		this.ticklePublisherParmName = ticklePublisherParmName;
	}

	public String getTicklePublisherParmName() {
		return ticklePublisherParmName;
	}
}
