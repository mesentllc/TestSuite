package com.mesentllc.transformer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UnmanifestedPackageEvent", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
public class UnmanifestedPackageEvent extends PackageEvent {

	@XmlElement(name = "UnmanifestedStatus", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private String unmanifestedStatus;
	@XmlElement(name = "PostageAmount", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private BigDecimal postageAmount;
	@XmlElement(name = "ClientName", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private String clientName;
	@XmlElement(name = "PTSTransmissionDate", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private String ptsTransmissionDate;
	@XmlElement(name = "ScanDate", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private String scanDate;
	@XmlElement(name = "ScanFacilityPostalCode", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private String scanFacilityPostalCode;
	@XmlElement(name = "ReleaseTypeCode", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private String releaseTypeCode;
	@XmlElement(name = "UnmanifestMailClass", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private String unmanifestPstlClass;
	@XmlElement(name = "StoreOrderCreateEventEnable", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private boolean storeOrderCreateEventEnable;
	@XmlElement(name = "StoreUnmanifestEventEnableIfNoStatusExistsInTable", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private boolean storeUnmanifestEventEnableIfNoStatusExistsInTable;
	@XmlElement(name = "StoreUnmanifestEventEnableIfStatusIsUPinTable", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private boolean storeUnmanifestEventEnableIfStatusIsUPinTable;
	@XmlElement(name = "StorePackageEventEnable", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private boolean storePackageEventEnable;
	@XmlElement(name = "CheckPkgIdInBpTableEnable", namespace = "http://smartpost.fedex.com/schemas/RodesRodesPkgEventProcSubscriber/FxspRodesUnmanifestedPackageEvent")
	private boolean checkPkgIdInBpTableEnable;

	public BigDecimal getPostageAmount() {
		return postageAmount;
	}

	public void setPostageAmount(BigDecimal value) {
		this.postageAmount = value;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String value) {
		this.clientName = value;
	}

	public String getPTSTransmissionDate() {
		return ptsTransmissionDate;
	}

	public void setPTSTransmissionDate(String value) {
		this.ptsTransmissionDate = value;
	}

	public void setUnmanifestedStatus(String unmanifestedStatus) {
		this.unmanifestedStatus = unmanifestedStatus;
	}

	public String getUnmanifestedStatus() {
		return unmanifestedStatus;
	}

	public void setScanFacilityPostalCode(String scanFacilityPostalCode) {
		this.scanFacilityPostalCode = scanFacilityPostalCode;
	}

	public String getScanFacilityPostalCode() {
		return scanFacilityPostalCode;
	}

	public void setReleaseTypeCode(String releaseTypeCode) {
		this.releaseTypeCode = releaseTypeCode;
	}

	public String getReleaseTypeCode() {
		return releaseTypeCode;
	}

	public void setStoreOrderCreateEventEnable(boolean storeOrderCreateEventEnable) {
		this.storeOrderCreateEventEnable = storeOrderCreateEventEnable;
	}

	public boolean isStoreOrderCreateEventEnable() {
		return storeOrderCreateEventEnable;
	}

	public void setUnmanifestPstlClass(String unmanifestPstlClass) {
		this.unmanifestPstlClass = unmanifestPstlClass;
	}

	public String getUnmanifestPstlClass() {
		return unmanifestPstlClass;
	}

	public void setStorePackageEventEnable(boolean storePackageEventEnable) {
		this.storePackageEventEnable = storePackageEventEnable;
	}

	public boolean isStorePackageEventEnable() {
		return storePackageEventEnable;
	}

	public void setStoreUnmanifestEventEnableIfStatusIsUPinTable(
		boolean storeUnmanifestEventEnableIfStatusIsUPinTable) {
		this.storeUnmanifestEventEnableIfStatusIsUPinTable = storeUnmanifestEventEnableIfStatusIsUPinTable;
	}

	public boolean isStoreUnmanifestEventEnableIfStatusIsUPinTable() {
		return storeUnmanifestEventEnableIfStatusIsUPinTable;
	}

	public void setStoreUnmanifestEventEnableIfNoStatusExistsInTable(
		boolean storeUnmanifestEventEnableIfNoStatusExistsInTable) {
		this.storeUnmanifestEventEnableIfNoStatusExistsInTable = storeUnmanifestEventEnableIfNoStatusExistsInTable;
	}

	public boolean isStoreUnmanifestEventEnableIfNoStatusExistsInTable() {
		return storeUnmanifestEventEnableIfNoStatusExistsInTable;
	}

	public void setCheckPkgIdInBpTableEnable(
		boolean checkPkgIdInBpTableEnable) {
		this.checkPkgIdInBpTableEnable = checkPkgIdInBpTableEnable;
	}

	public boolean isCheckPkgIdInBpTableEnable() {
		return checkPkgIdInBpTableEnable;
	}

	public void setScanDate(String scanDate) {
		this.scanDate = scanDate;
	}

	public String getScanDate() {
		return scanDate;
	}
}
