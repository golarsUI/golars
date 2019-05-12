package com.golars.bean;

public class Account {
	private String Id;
	private String name;
	private String fid;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	private String facilityOperatorPOA;
	private String propertyOwnerPOA;
	private String ustOwnerPOA;
	private String operatorAffidevitOfLease;
	private String ownerAffidevitOfLease;
	private String sosStatus;
	private String notificationDueDate;
	private String notificationFormSubmitted;
	private String propertyDeedLandContract;
	private String taxIDInformation;
	private String letterOfNetworthCertification;
	private String operatorLeaseAgreement;
	private String lineAndLeakDetector;
	private String isLnlDetrTstRequrd;
	private String cathodicProtection;
	private String isCprequired;
	private String operatorAcertificate;
	private String operatorBcertificate;
	private String operatorCcertificate;
	private String tankTestingReport;
	private String repairDocuments;
	private String isTankTestingReportRequired;
	private String isRepairDocumentRequired;
	private String releaseDetectionReport;
	private String isReleaseDetectionReportRequired;
	private String internalLiningInspection;
	private String isInternalLiningInspectionRequired;
	private String operator_c;
	private String accountType;
	private String facilityBrand;
	private String complaint;
	private String doNotTriggerEmail;
	private String parentName;
	private String billingAddress;
	private String email;
	private String phone;
	private String isActive;
	private String companyContact;
	private String clientContact;
	private String dueDate;
	private String vendorType;
	private String gtProjectManagerPhone;
	private String gtProjectManager;
	private String missingInformationNotes;
	private String isATGRepairRequired;
	private String isATGTestRequired;
	private String isDeedOrLCRequired;
	private String isDropTubeRepairRequired;
	private String isGTCompliant;
	private String isMonthlyWalkThroughInspection;
	private String isNFCompliant;
	private String isOLARequired;
	private String isPropertyForSale;
	private String isSirRequired;
	private String isSpillBucketRepairRequired;
	private String isSumpMaintenanceRequired;
	private String osTankInformationAvailable;
	private String isUDCMaintenanceRequired;
	private String lastFormalEnforcement;
	private String lastInformalEnforcement;
	private String lastInspectionDate;
	private String lastSiteClosure;
	private String lastPenaltyAmount;
	private String lastPenaltyDate;
	private String latitude;
	private String leaseDocumentURl;
	private String leaseEndDate;
	private String leaseStartDate;
	private String leaseType;
	private String lldTestReimbursement;
	private String longitude;
	private String lonOrCOIExpiryDate;
	private String lustIncidentNumber;
	private String lustDocumentLink;
	private String lustLastUpdate;
	private String lustProjectManager;
	private String lustReleaseDate;
	private String MgtCompany;
	private String mgt;
	private String mgtEndDate;
	private String mgtStartDate;
	private String mobile;
	private String monthlyBaseRent;
	private String monthlyCam;
	private String monthlyInsurance;
	private String monthlyOthers;
	private String monthlySignPylon;
	private String monthlyTaxes;
	private String monthlyWalkThroughReport;
	private String ncQuarters;
	private String ofELTFClaims;
	private String noOfTanks;
	private String notificationForm;
	private String notificationFormApproved;
	private String operatingAreas;
	private String ustOwnerBusinessRegistration;
	private String isPipingCPRequired;
	private String pipingCathodicProtection;
	private String dropTubeRepairDocument;
	private String isTankInterstitialMonitoringRequired;
	private String tankInterstitialMonitoring;
	private String isPipeInterstitialMontoringRequired;
	private String pipinginterstitialMonitoring;
	private String atgTestReport;
	private String atgRepairReport;
	private String ustOwnerTaxId;
	private String isUSTOwnerTaxId;
	private String propertyOwnerTaxId;
	private String isPropertyOwnerTaxId;
	private String operatorOwnerTaxId;
	private String isOperatorOwnerTaxId;
	private String deedOrLandContract;
	private String typeOfNotificationFormRequired;
	private String financialResponsibility;
	private String isFinancialResponsibility;
	private String operatorLeaseAgreementNew;
	private String isOperatorLeaseAgreement;
	private String isOwnerBusinessRegistration;
	private String propertyOwnerBusinessRegistration;
	private String isPropertyOwnerBusinessRegistration;
	private String operatorBusinessRegistration;
	private String isOperatorBusinessRegistration;
	private String tankMonitorStaticIP;
	private String isTankMonitorStaticIP;
	private String sirReport;
	private String udcMaintenanceDocument;
	private String sumpMaintenanceDocument;
	private String spillBucketRepairDocument;
	private String spillBucketTestingDocument;
	private String isSpillBucketTestingDocument;
	private String documentLink;
	private String facilitySiteMap;
	private String isFacilitySiteMap;
	private String cofaLink;

	// notificationForm fields
	private boolean operatorBusinessEnable = false;
	private boolean propertyOwnerBusinessEnable = false;
	private boolean ustOwnerBusinessEnable = false;
	private boolean operatorOwnerEnable = false;
	private boolean propertyOwnerTaxIDEnable = false;
	private boolean ustOwnerEnable = false;
	private boolean operatorLeaseAgreementEnable = false;
	private boolean financialResponsibilityEnable = false;
	private boolean propertyDeedLandContractEnable = false;
	private boolean facilitySiteMapEnable = false;
	private boolean cofaLinkEnable = false;

	private boolean operatorBusinessSubmitted = false;
	private boolean propertyOwnerBusinessSubmitted = false;
	private boolean ustOwnerBusinessSubmitted = false;
	private boolean operatorOwnerSubmitted = false;
	private boolean propertyOwnerTaxIDSubmitted = false;
	private boolean ustOwnerSubmitted = false;
	private boolean operatorLeaseAgreementSubmitted = false;
	private boolean financialResponsibilitySubmitted = false;
	private boolean propertyDeedLandContractSubmitted = false;
	private boolean facilitySiteMapSubmitted = false;
	private boolean cofaLinkSubmitted = false;

	private String operatorBusinessURL;
	private String propertyOwnerBusinessURL;
	private String ustOwnerBusinessURL;
	private String operatorOwnerURL;
	private String propertyOwnerTaxIDURL;
	private String ustOwnerURL;
	private String operatorLeaseAgreementURL;
	private String financialResponsibilityURL;
	private String propertyDeedLandContractURL;
	private String facilitySiteMapURL;

	// compilance section
	private boolean releaseDetectionReportEnable = false;
	private boolean repairDocumentsEnable = false;
	private boolean lineAndLeakDetectorEnable = false;
	private boolean tankTestingReportEnable = false;
	private boolean cathodicProtectionEnable = false;
	private boolean internalLiningInspectionEnable = false;
	private boolean pipingCathodicProtectionEnable = false;
	private boolean dropTubeRepairDocumentEnable = false;
	private boolean tankInterstitialMonitoringEnable = false;
	private boolean pipinginterstitialMonitoringEnable = false;
	private boolean atgTestReportEnable = false;
	private boolean atgRepairReportEnable = false;
	private boolean spillBucketTestingDocumentEnable = false;
	private boolean spillBucketRepairDocumentEnable = false;
	private boolean sumpMaintenanceDocumentEnable = false;
	private boolean udcMaintenanceDocumentEnable = false;
	private boolean sirReportEnable = false;
	private boolean monthlyWalkThroughReportEnable = false;
	private boolean tankMonitorStaticIPEnable = false;

	private boolean releaseDetectionReportSubmitted = false;
	private boolean repairDocumentsSubmitted = false;
	private boolean lineAndLeakDetectorSubmitted = false;
	private boolean tankTestingReportSubmitted = false;
	private boolean cathodicProtectionSubmitted = false;
	private boolean internalLiningInspectionSubmitted = false;
	private boolean pipingCathodicProtectionSubmitted = false;
	private boolean dropTubeRepairDocumentSubmitted = false;
	private boolean tankInterstitialMonitoringSubmitted = false;
	private boolean pipinginterstitialMonitoringSubmitted = false;
	private boolean atgTestReportSubmitted = false;
	private boolean atgRepairReportSubmitted = false;
	private boolean spillBucketTestingDocumentSubmitted = false;
	private boolean spillBucketRepairDocumentSubmitted = false;
	private boolean sumpMaintenanceDocumentSubmitted = false;
	private boolean udcMaintenanceDocumentSubmitted = false;
	private boolean sirReportSubmitted = false;
	private boolean monthlyWalkThroughReportSubmitted = false;
	private boolean tankMonitorStaticIPSubmitted = false;

	private String releaseDetectionReportURL;
	private String repairDocumentsURL;
	private String lineAndLeakDetectorURL;
	private String tankTestingReportURL;
	private String cathodicProtectionURL;
	private String internalLiningInspectionURL;
	private String pipingCathodicProtectionURL;
	private String dropTubeRepairDocumentURL;
	private String tankInterstitialMonitoringURL;
	private String pipinginterstitialMonitoringURL;
	private String atgTestReportURL;
	private String atgRepairReportURL;
	private String spillBucketTestingDocumentURL;
	private String spillBucketRepairDocumentURL;
	private String sumpMaintenanceDocumentURL;
	private String udcMaintenanceDocumentURL;
	private String sirReportURL;
	private String monthlyWalkThroughReportURL;
	private String tankMonitorStaticIPURL;

	// certificate section
	private boolean operatorAcertificateEnable = false;
	private boolean operatorBcertificateEnable = false;
	private boolean operatorCcertificateEnable = false;

	private boolean operatorAcertificateSubmitted = false;
	private boolean operatorBcertificateSubmitted = false;
	private boolean operatorCcertificateSubmitted = false;

	private String operatorAcertificateURL;
	private String operatorBcertificateURL;
	private String operatorCcertificateURL;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getFacilityOperatorPOA() {
		return facilityOperatorPOA;
	}

	public void setFacilityOperatorPOA(String facilityOperatorPOA) {
		this.facilityOperatorPOA = facilityOperatorPOA;
	}

	public String getPropertyOwnerPOA() {
		return propertyOwnerPOA;
	}

	public void setPropertyOwnerPOA(String propertyOwnerPOA) {
		this.propertyOwnerPOA = propertyOwnerPOA;
	}

	public String getUstOwnerPOA() {
		return ustOwnerPOA;
	}

	public void setUstOwnerPOA(String ustOwnerPOA) {
		this.ustOwnerPOA = ustOwnerPOA;
	}

	public String getOperatorAffidevitOfLease() {
		return operatorAffidevitOfLease;
	}

	public void setOperatorAffidevitOfLease(String operatorAffidevitOfLease) {
		this.operatorAffidevitOfLease = operatorAffidevitOfLease;
	}

	public String getOwnerAffidevitOfLease() {
		return ownerAffidevitOfLease;
	}

	public void setOwnerAffidevitOfLease(String ownerAffidevitOfLease) {
		this.ownerAffidevitOfLease = ownerAffidevitOfLease;
	}

	public String getSosStatus() {
		return sosStatus;
	}

	public void setSosStatus(String sosStatus) {
		this.sosStatus = sosStatus;
	}

	public String getNotificationDueDate() {
		return notificationDueDate;
	}

	public void setNotificationDueDate(String notificationDueDate) {
		this.notificationDueDate = notificationDueDate;
	}

	public String getNotificationFormSubmitted() {
		return notificationFormSubmitted;
	}

	public void setNotificationFormSubmitted(String notificationFormSubmitted) {
		this.notificationFormSubmitted = notificationFormSubmitted;
	}

	public String getPropertyDeedLandContract() {
		return propertyDeedLandContract;
	}

	public void setPropertyDeedLandContract(String propertyDeedLandContract) {
		this.propertyDeedLandContract = propertyDeedLandContract;
	}

	public String getTaxIDInformation() {
		return taxIDInformation;
	}

	public void setTaxIDInformation(String taxIDInformation) {
		this.taxIDInformation = taxIDInformation;
	}

	public String getLetterOfNetworthCertification() {
		return letterOfNetworthCertification;
	}

	public void setLetterOfNetworthCertification(String letterOfNetworthCertification) {
		this.letterOfNetworthCertification = letterOfNetworthCertification;
	}

	public String getOperatorLeaseAgreement() {
		return operatorLeaseAgreement;
	}

	public void setOperatorLeaseAgreement(String operatorLeaseAgreement) {
		this.operatorLeaseAgreement = operatorLeaseAgreement;
	}

	public String getLineAndLeakDetector() {
		return lineAndLeakDetector;
	}

	public void setLineAndLeakDetector(String lineAndLeakDetector) {
		this.lineAndLeakDetector = lineAndLeakDetector;
	}

	public String getIsLnlDetrTstRequrd() {
		return isLnlDetrTstRequrd;
	}
	public void setIsLnlDetrTstRequrd(String isLnlDetrTstRequrd) {
		this.isLnlDetrTstRequrd = isLnlDetrTstRequrd;
	}

	public String getCathodicProtection() {
		return cathodicProtection;
	}

	public void setCathodicProtection(String cathodicProtection) {
		this.cathodicProtection = cathodicProtection;
	}

	public String getIsCprequired() {
		return isCprequired;
	}
	public void setIsCprequired(String isCprequired) {
		this.isCprequired = isCprequired;
	}

	public String getOperatorAcertificate() {
		return operatorAcertificate;
	}

	public void setOperatorAcertificate(String operatorAcertificate) {
		this.operatorAcertificate = operatorAcertificate;
	}

	public String getOperatorBcertificate() {
		return operatorBcertificate;
	}

	public void setOperatorBcertificate(String operatorBcertificate) {
		this.operatorBcertificate = operatorBcertificate;
	}

	public String getOperatorCcertificate() {
		return operatorCcertificate;
	}

	public void setOperatorCcertificate(String operatorCcertificate) {
		this.operatorCcertificate = operatorCcertificate;
	}

	public String getTankTestingReport() {
		return tankTestingReport;
	}

	public void setTankTestingReport(String tankTestingReport) {
		this.tankTestingReport = tankTestingReport;
	}

	public String getRepairDocuments() {
		return repairDocuments;
	}

	public void setRepairDocuments(String repairDocuments) {
		this.repairDocuments = repairDocuments;
	}

	public String getIsTankTestingReportRequired() {
		return isTankTestingReportRequired;
	}
	
	public void setIsTankTestingReportRequired(String isTankTestingReportRequired) {
		this.isTankTestingReportRequired = isTankTestingReportRequired;
	}

	public String getIsRepairDocumentRequired() {
		return isRepairDocumentRequired;
	}
	public void setIsRepairDocumentRequired(String isRepairDocumentRequired) {
		this.isRepairDocumentRequired = isRepairDocumentRequired;
	}

	public String getReleaseDetectionReport() {
		return releaseDetectionReport;
	}

	public void setReleaseDetectionReport(String releaseDetectionReport) {
		this.releaseDetectionReport = releaseDetectionReport;
	}

	public String getIsReleaseDetectionReportRequired() {
		return isReleaseDetectionReportRequired;
	}

	public void setIsReleaseDetectionReportRequired(String isReleaseDetectionReportRequired) {
		this.isReleaseDetectionReportRequired = isReleaseDetectionReportRequired;
	}

	public String getInternalLiningInspection() {
		return internalLiningInspection;
	}

	public void setInternalLiningInspection(String internalLiningInspection) {
		this.internalLiningInspection = internalLiningInspection;
	}

	public String getIsInternalLiningInspectionRequired() {
		return isInternalLiningInspectionRequired;
	}

	public void setIsInternalLiningInspectionRequired(String isInternalLiningInspectionRequired) {
		this.isInternalLiningInspectionRequired = isInternalLiningInspectionRequired;
	}

	public String getOperator_c() {
		return operator_c;
	}

	public void setOperator_c(String operator_c) {
		this.operator_c = operator_c;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getFacilityBrand() {
		return facilityBrand;
	}

	public void setFacilityBrand(String facilityBrand) {
		this.facilityBrand = facilityBrand;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getDoNotTriggerEmail() {
		return doNotTriggerEmail;
	}

	public void setDoNotTriggerEmail(String doNotTriggerEmail) {
		this.doNotTriggerEmail = doNotTriggerEmail;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getClientContact() {
		return clientContact;
	}

	public void setClientContact(String clientContact) {
		this.clientContact = clientContact;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getGtProjectManagerPhone() {
		return gtProjectManagerPhone;
	}

	public void setGtProjectManagerPhone(String gtProjectManagerPhone) {
		this.gtProjectManagerPhone = gtProjectManagerPhone;
	}

	public String getGtProjectManager() {
		return gtProjectManager;
	}

	public void setGtProjectManager(String gtProjectManager) {
		this.gtProjectManager = gtProjectManager;
	}

	public String getMissingInformationNotes() {
		return missingInformationNotes;
	}

	public void setMissingInformationNotes(String missingInformationNotes) {
		this.missingInformationNotes = missingInformationNotes;
	}

	public String getIsATGRepairRequired() {
		return isATGRepairRequired;
	}

	public void setIsATGRepairRequired(String isATGRepairRequired) {
		this.isATGRepairRequired = isATGRepairRequired;
	}

	public String getIsATGTestRequired() {
		return isATGTestRequired;
	}

	public void setIsATGTestRequired(String isATGTestRequired) {
		this.isATGTestRequired = isATGTestRequired;
	}

	public String getIsDeedOrLCRequired() {
		return isDeedOrLCRequired;
	}

	public void setIsDeedOrLCRequired(String isDeedOrLCRequired) {
		this.isDeedOrLCRequired = isDeedOrLCRequired;
	}

	public String getIsDropTubeRepairRequired() {
		return isDropTubeRepairRequired;
	}

	public void setIsDropTubeRepairRequired(String isDropTubeRepairRequired) {
		this.isDropTubeRepairRequired = isDropTubeRepairRequired;
	}

	public String getIsGTCompliant() {
		return isGTCompliant;
	}

	public void setIsGTCompliant(String isGTCompliant) {
		this.isGTCompliant = isGTCompliant;
	}

	public String getIsMonthlyWalkThroughInspection() {
		return isMonthlyWalkThroughInspection;
	}

	public void setIsMonthlyWalkThroughInspection(String isMonthlyWalkThroughInspection) {
		this.isMonthlyWalkThroughInspection = isMonthlyWalkThroughInspection;
	}

	public String getIsNFCompliant() {
		return isNFCompliant;
	}

	public void setIsNFCompliant(String isNFCompliant) {
		this.isNFCompliant = isNFCompliant;
	}

	public String getIsOLARequired() {
		return isOLARequired;
	}

	public void setIsOLARequired(String isOLARequired) {
		this.isOLARequired = isOLARequired;
	}

	public String getIsPropertyForSale() {
		return isPropertyForSale;
	}

	public void setIsPropertyForSale(String isPropertyForSale) {
		this.isPropertyForSale = isPropertyForSale;
	}

	public String getIsSirRequired() {
		return isSirRequired;
	}

	public void setIsSirRequired(String isSirRequired) {
		this.isSirRequired = isSirRequired;
	}

	public String getIsSpillBucketRepairRequired() {
		return isSpillBucketRepairRequired;
	}

	public void setIsSpillBucketRepairRequired(String isSpillBucketRepairRequired) {
		this.isSpillBucketRepairRequired = isSpillBucketRepairRequired;
	}

	public String getIsSumpMaintenanceRequired() {
		return isSumpMaintenanceRequired;
	}

	public void setIsSumpMaintenanceRequired(String isSumpMaintenanceRequired) {
		this.isSumpMaintenanceRequired = isSumpMaintenanceRequired;
	}

	public String getOsTankInformationAvailable() {
		return osTankInformationAvailable;
	}

	public void setOsTankInformationAvailable(String osTankInformationAvailable) {
		this.osTankInformationAvailable = osTankInformationAvailable;
	}

	public String getIsUDCMaintenanceRequired() {
		return isUDCMaintenanceRequired;
	}

	public void setIsUDCMaintenanceRequired(String isUDCMaintenanceRequired) {
		this.isUDCMaintenanceRequired = isUDCMaintenanceRequired;
	}

	public String getLastFormalEnforcement() {
		return lastFormalEnforcement;
	}

	public void setLastFormalEnforcement(String lastFormalEnforcement) {
		this.lastFormalEnforcement = lastFormalEnforcement;
	}

	public String getLastInformalEnforcement() {
		return lastInformalEnforcement;
	}

	public void setLastInformalEnforcement(String lastInformalEnforcement) {
		this.lastInformalEnforcement = lastInformalEnforcement;
	}

	public String getLastInspectionDate() {
		return lastInspectionDate;
	}

	public void setLastInspectionDate(String lastInspectionDate) {
		this.lastInspectionDate = lastInspectionDate;
	}

	public String getLastSiteClosure() {
		return lastSiteClosure;
	}

	public void setLastSiteClosure(String lastSiteClosure) {
		this.lastSiteClosure = lastSiteClosure;
	}

	public String getLastPenaltyAmount() {
		return lastPenaltyAmount;
	}

	public void setLastPenaltyAmount(String lastPenaltyAmount) {
		this.lastPenaltyAmount = lastPenaltyAmount;
	}

	public String getLastPenaltyDate() {
		return lastPenaltyDate;
	}

	public void setLastPenaltyDate(String lastPenaltyDate) {
		this.lastPenaltyDate = lastPenaltyDate;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLeaseDocumentURl() {
		return leaseDocumentURl;
	}

	public void setLeaseDocumentURl(String leaseDocumentURl) {
		this.leaseDocumentURl = leaseDocumentURl;
	}

	public String getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(String leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public String getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(String leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public String getLeaseType() {
		return leaseType;
	}

	public void setLeaseType(String leaseType) {
		this.leaseType = leaseType;
	}

	public String getLldTestReimbursement() {
		return lldTestReimbursement;
	}

	public void setLldTestReimbursement(String lldTestReimbursement) {
		this.lldTestReimbursement = lldTestReimbursement;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLonOrCOIExpiryDate() {
		return lonOrCOIExpiryDate;
	}

	public void setLonOrCOIExpiryDate(String lonOrCOIExpiryDate) {
		this.lonOrCOIExpiryDate = lonOrCOIExpiryDate;
	}

	public String getLustIncidentNumber() {
		return lustIncidentNumber;
	}

	public void setLustIncidentNumber(String lustIncidentNumber) {
		this.lustIncidentNumber = lustIncidentNumber;
	}

	public String getLustDocumentLink() {
		return lustDocumentLink;
	}

	public void setLustDocumentLink(String lustDocumentLink) {
		this.lustDocumentLink = lustDocumentLink;
	}

	public String getLustLastUpdate() {
		return lustLastUpdate;
	}

	public void setLustLastUpdate(String lustLastUpdate) {
		this.lustLastUpdate = lustLastUpdate;
	}

	public String getLustProjectManager() {
		return lustProjectManager;
	}

	public void setLustProjectManager(String lustProjectManager) {
		this.lustProjectManager = lustProjectManager;
	}

	public String getLustReleaseDate() {
		return lustReleaseDate;
	}

	public void setLustReleaseDate(String lustReleaseDate) {
		this.lustReleaseDate = lustReleaseDate;
	}

	public String getMgtCompany() {
		return MgtCompany;
	}

	public void setMgtCompany(String mgtCompany) {
		MgtCompany = mgtCompany;
	}

	public String getMgt() {
		return mgt;
	}

	public void setMgt(String mgt) {
		this.mgt = mgt;
	}

	public String getMgtEndDate() {
		return mgtEndDate;
	}

	public void setMgtEndDate(String mgtEndDate) {
		this.mgtEndDate = mgtEndDate;
	}

	public String getMgtStartDate() {
		return mgtStartDate;
	}

	public void setMgtStartDate(String mgtStartDate) {
		this.mgtStartDate = mgtStartDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMonthlyBaseRent() {
		return monthlyBaseRent;
	}

	public void setMonthlyBaseRent(String monthlyBaseRent) {
		this.monthlyBaseRent = monthlyBaseRent;
	}

	public String getMonthlyCam() {
		return monthlyCam;
	}

	public void setMonthlyCam(String monthlyCam) {
		this.monthlyCam = monthlyCam;
	}

	public String getMonthlyInsurance() {
		return monthlyInsurance;
	}

	public void setMonthlyInsurance(String monthlyInsurance) {
		this.monthlyInsurance = monthlyInsurance;
	}

	public String getMonthlyOthers() {
		return monthlyOthers;
	}

	public void setMonthlyOthers(String monthlyOthers) {
		this.monthlyOthers = monthlyOthers;
	}

	public String getMonthlySignPylon() {
		return monthlySignPylon;
	}

	public void setMonthlySignPylon(String monthlySignPylon) {
		this.monthlySignPylon = monthlySignPylon;
	}

	public String getMonthlyTaxes() {
		return monthlyTaxes;
	}

	public void setMonthlyTaxes(String monthlyTaxes) {
		this.monthlyTaxes = monthlyTaxes;
	}

	public String getMonthlyWalkThroughReport() {
		return monthlyWalkThroughReport;
	}

	public void setMonthlyWalkThroughReport(String monthlyWalkThroughReport) {
		this.monthlyWalkThroughReport = monthlyWalkThroughReport;
	}

	public String getNcQuarters() {
		return ncQuarters;
	}

	public void setNcQuarters(String ncQuarters) {
		this.ncQuarters = ncQuarters;
	}

	public String getOfELTFClaims() {
		return ofELTFClaims;
	}

	public void setOfELTFClaims(String ofELTFClaims) {
		this.ofELTFClaims = ofELTFClaims;
	}

	public String getNoOfTanks() {
		return noOfTanks;
	}

	public void setNoOfTanks(String noOfTanks) {
		this.noOfTanks = noOfTanks;
	}

	public String getNotificationForm() {
		return notificationForm;
	}

	public void setNotificationForm(String notificationForm) {
		this.notificationForm = notificationForm;
	}

	public String getNotificationFormApproved() {
		return notificationFormApproved;
	}

	public void setNotificationFormApproved(String notificationFormApproved) {
		this.notificationFormApproved = notificationFormApproved;
	}

	public String getOperatingAreas() {
		return operatingAreas;
	}

	public void setOperatingAreas(String operatingAreas) {
		this.operatingAreas = operatingAreas;
	}

	public String getUstOwnerBusinessRegistration() {
		return ustOwnerBusinessRegistration;
	}

	public void setUstOwnerBusinessRegistration(String ustOwnerBusinessRegistration) {
		this.ustOwnerBusinessRegistration = ustOwnerBusinessRegistration;
	}

	public String getIsPipingCPRequired() {
		return isPipingCPRequired;
	}

	public void setIsPipingCPRequired(String isPipingCPRequired) {
		this.isPipingCPRequired = isPipingCPRequired;
	}

	public String getPipingCathodicProtection() {
		return pipingCathodicProtection;
	}

	public void setPipingCathodicProtection(String pipingCathodicProtection) {
		this.pipingCathodicProtection = pipingCathodicProtection;
	}

	public String getDropTubeRepairDocument() {
		return dropTubeRepairDocument;
	}

	public void setDropTubeRepairDocument(String dropTubeRepairDocument) {
		this.dropTubeRepairDocument = dropTubeRepairDocument;
	}

	public String getIsTankInterstitialMonitoringRequired() {
		return isTankInterstitialMonitoringRequired;
	}

	public void setIsTankInterstitialMonitoringRequired(String isTankInterstitialMonitoringRequired) {
		this.isTankInterstitialMonitoringRequired = isTankInterstitialMonitoringRequired;
	}

	public String getTankInterstitialMonitoring() {
		return tankInterstitialMonitoring;
	}

	public void setTankInterstitialMonitoring(String tankInterstitialMonitoring) {
		this.tankInterstitialMonitoring = tankInterstitialMonitoring;
	}

	public String getIsPipeInterstitialMontoringRequired() {
		return isPipeInterstitialMontoringRequired;
	}

	public void setIsPipeInterstitialMontoringRequired(String isPipeInterstitialMontoringRequired) {
		this.isPipeInterstitialMontoringRequired = isPipeInterstitialMontoringRequired;
	}

	public String getPipinginterstitialMonitoring() {
		return pipinginterstitialMonitoring;
	}

	public void setPipinginterstitialMonitoring(String pipinginterstitialMonitoring) {
		this.pipinginterstitialMonitoring = pipinginterstitialMonitoring;
	}

	public String getAtgTestReport() {
		return atgTestReport;
	}

	public void setAtgTestReport(String atgTestReport) {
		this.atgTestReport = atgTestReport;
	}

	public String getAtgRepairReport() {
		return atgRepairReport;
	}

	public void setAtgRepairReport(String atgRepairReport) {
		this.atgRepairReport = atgRepairReport;
	}

	public String getUstOwnerTaxId() {
		return ustOwnerTaxId;
	}

	public void setUstOwnerTaxId(String ustOwnerTaxId) {
		this.ustOwnerTaxId = ustOwnerTaxId;
	}

	public String getIsUSTOwnerTaxId() {
		return isUSTOwnerTaxId;
	}

	public void setIsUSTOwnerTaxId(String isUSTOwnerTaxId) {
		this.isUSTOwnerTaxId = isUSTOwnerTaxId;
	}

	public String getPropertyOwnerTaxId() {
		return propertyOwnerTaxId;
	}

	public void setPropertyOwnerTaxId(String propertyOwnerTaxId) {
		this.propertyOwnerTaxId = propertyOwnerTaxId;
	}

	public String getIsPropertyOwnerTaxId() {
		return isPropertyOwnerTaxId;
	}

	public void setIsPropertyOwnerTaxId(String isPropertyOwnerTaxId) {
		this.isPropertyOwnerTaxId = isPropertyOwnerTaxId;
	}

	public String getOperatorOwnerTaxId() {
		return operatorOwnerTaxId;
	}

	public void setOperatorOwnerTaxId(String operatorOwnerTaxId) {
		this.operatorOwnerTaxId = operatorOwnerTaxId;
	}

	public String getIsOperatorOwnerTaxId() {
		return isOperatorOwnerTaxId;
	}

	public void setIsOperatorOwnerTaxId(String isOperatorOwnerTaxId) {
		this.isOperatorOwnerTaxId = isOperatorOwnerTaxId;
	}

	public String getDeedOrLandContract() {
		return deedOrLandContract;
	}

	public void setDeedOrLandContract(String deedOrLandContract) {
		this.deedOrLandContract = deedOrLandContract;
	}

	public String getTypeOfNotificationFormRequired() {
		return typeOfNotificationFormRequired;
	}

	public void setTypeOfNotificationFormRequired(String typeOfNotificationFormRequired) {
		this.typeOfNotificationFormRequired = typeOfNotificationFormRequired;
	}

	public String getFinancialResponsibility() {
		return financialResponsibility;
	}

	public void setFinancialResponsibility(String financialResponsibility) {
		this.financialResponsibility = financialResponsibility;
	}

	public String getIsFinancialResponsibility() {
		return isFinancialResponsibility;
	}

	public void setIsFinancialResponsibility(String isFinancialResponsibility) {
		this.isFinancialResponsibility = isFinancialResponsibility;
	}

	public String getOperatorLeaseAgreementNew() {
		return operatorLeaseAgreementNew;
	}

	public void setOperatorLeaseAgreementNew(String operatorLeaseAgreementNew) {
		this.operatorLeaseAgreementNew = operatorLeaseAgreementNew;
	}

	public String getIsOperatorLeaseAgreement() {
		return isOperatorLeaseAgreement;
	}

	public void setIsOperatorLeaseAgreement(String isOperatorLeaseAgreement) {
		this.isOperatorLeaseAgreement = isOperatorLeaseAgreement;
	}

	public String getIsOwnerBusinessRegistration() {
		return isOwnerBusinessRegistration;
	}

	public void setIsOwnerBusinessRegistration(String isOwnerBusinessRegistration) {
		this.isOwnerBusinessRegistration = isOwnerBusinessRegistration;
	}

	public String getPropertyOwnerBusinessRegistration() {
		return propertyOwnerBusinessRegistration;
	}

	public void setPropertyOwnerBusinessRegistration(String propertyOwnerBusinessRegistration) {
		this.propertyOwnerBusinessRegistration = propertyOwnerBusinessRegistration;
	}

	public String getIsPropertyOwnerBusinessRegistration() {
		return isPropertyOwnerBusinessRegistration;
	}

	public void setIsPropertyOwnerBusinessRegistration(String isPropertyOwnerBusinessRegistration) {
		this.isPropertyOwnerBusinessRegistration = isPropertyOwnerBusinessRegistration;
	}

	public String getOperatorBusinessRegistration() {
		return operatorBusinessRegistration;
	}

	public void setOperatorBusinessRegistration(String operatorBusinessRegistration) {
		this.operatorBusinessRegistration = operatorBusinessRegistration;
	}

	public String getIsOperatorBusinessRegistration() {
		return isOperatorBusinessRegistration;
	}

	public void setIsOperatorBusinessRegistration(String isOperatorBusinessRegistration) {
		this.isOperatorBusinessRegistration = isOperatorBusinessRegistration;
	}

	public String getTankMonitorStaticIP() {
		return tankMonitorStaticIP;
	}

	public void setTankMonitorStaticIP(String tankMonitorStaticIP) {
		this.tankMonitorStaticIP = tankMonitorStaticIP;
	}

	public String getIsTankMonitorStaticIP() {
		return isTankMonitorStaticIP;
	}

	public void setIsTankMonitorStaticIP(String isTankMonitorStaticIP) {
		this.isTankMonitorStaticIP = isTankMonitorStaticIP;
	}

	public String getSirReport() {
		return sirReport;
	}

	public void setSirReport(String sirReport) {
		this.sirReport = sirReport;
	}

	public String getUdcMaintenanceDocument() {
		return udcMaintenanceDocument;
	}

	public void setUdcMaintenanceDocument(String udcMaintenanceDocument) {
		this.udcMaintenanceDocument = udcMaintenanceDocument;
	}

	public String getSumpMaintenanceDocument() {
		return sumpMaintenanceDocument;
	}

	public void setSumpMaintenanceDocument(String sumpMaintenanceDocument) {
		this.sumpMaintenanceDocument = sumpMaintenanceDocument;
	}

	public String getSpillBucketRepairDocument() {
		return spillBucketRepairDocument;
	}

	public void setSpillBucketRepairDocument(String spillBucketRepairDocument) {
		this.spillBucketRepairDocument = spillBucketRepairDocument;
	}

	public String getSpillBucketTestingDocument() {
		return spillBucketTestingDocument;
	}
	public String getIsSpillBucketTestingDocument() {
		return isSpillBucketTestingDocument;
	}
	public void setIsSpillBucketTestingDocument(String isSpillBucketTestingDocument) {
		this.isSpillBucketTestingDocument = isSpillBucketTestingDocument;
	}

	public void setSpillBucketTestingDocument(String spillBucketTestingDocument) {
		this.spillBucketTestingDocument = spillBucketTestingDocument;
	}

	public String getDocumentLink() {
		return documentLink;
	}

	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
	}

	public String getFacilitySiteMap() {
		return facilitySiteMap;
	}

	public void setFacilitySiteMap(String facilitySiteMap) {
		this.facilitySiteMap = facilitySiteMap;
	}

	public String getIsFacilitySiteMap() {
		return isFacilitySiteMap;
	}

	public void setIsFacilitySiteMap(String isFacilitySiteMap) {
		this.isFacilitySiteMap = isFacilitySiteMap;
	}

	public boolean isOperatorBusinessEnable() {
		return operatorBusinessEnable;
	}

	public void setOperatorBusinessEnable(boolean operatorBusinessEnable) {
		this.operatorBusinessEnable = operatorBusinessEnable;
	}

	public boolean isPropertyOwnerBusinessEnable() {
		return propertyOwnerBusinessEnable;
	}

	public void setPropertyOwnerBusinessEnable(boolean propertyOwnerBusinessEnable) {
		this.propertyOwnerBusinessEnable = propertyOwnerBusinessEnable;
	}

	public boolean isUstOwnerBusinessEnable() {
		return ustOwnerBusinessEnable;
	}

	public void setUstOwnerBusinessEnable(boolean ustOwnerBusinessEnable) {
		this.ustOwnerBusinessEnable = ustOwnerBusinessEnable;
	}

	public boolean isOperatorOwnerEnable() {
		return operatorOwnerEnable;
	}

	public void setOperatorOwnerEnable(boolean operatorOwnerEnable) {
		this.operatorOwnerEnable = operatorOwnerEnable;
	}

	public boolean isPropertyOwnerTaxIDEnable() {
		return propertyOwnerTaxIDEnable;
	}

	public void setPropertyOwnerTaxIDEnable(boolean propertyOwnerTaxIDEnable) {
		this.propertyOwnerTaxIDEnable = propertyOwnerTaxIDEnable;
	}

	public boolean isUstOwnerEnable() {
		return ustOwnerEnable;
	}

	public void setUstOwnerEnable(boolean ustOwnerEnable) {
		this.ustOwnerEnable = ustOwnerEnable;
	}

	public boolean isOperatorLeaseAgreementEnable() {
		return operatorLeaseAgreementEnable;
	}

	public void setOperatorLeaseAgreementEnable(boolean operatorLeaseAgreementEnable) {
		this.operatorLeaseAgreementEnable = operatorLeaseAgreementEnable;
	}

	public boolean isFinancialResponsibilityEnable() {
		return financialResponsibilityEnable;
	}

	public void setFinancialResponsibilityEnable(boolean financialResponsibilityEnable) {
		this.financialResponsibilityEnable = financialResponsibilityEnable;
	}

	public boolean isPropertyDeedLandContractEnable() {
		return propertyDeedLandContractEnable;
	}

	public void setPropertyDeedLandContractEnable(boolean propertyDeedLandContractEnable) {
		this.propertyDeedLandContractEnable = propertyDeedLandContractEnable;
	}

	public boolean isFacilitySiteMapEnable() {
		return facilitySiteMapEnable;
	}

	public void setFacilitySiteMapEnable(boolean facilitySiteMapEnable) {
		this.facilitySiteMapEnable = facilitySiteMapEnable;
	}

	public String getOperatorBusinessURL() {
		return operatorBusinessURL;
	}

	public void setOperatorBusinessURL(String operatorBusinessURL) {
		this.operatorBusinessURL = operatorBusinessURL;
	}

	public String getPropertyOwnerBusinessURL() {
		return propertyOwnerBusinessURL;
	}

	public void setPropertyOwnerBusinessURL(String propertyOwnerBusinessURL) {
		this.propertyOwnerBusinessURL = propertyOwnerBusinessURL;
	}

	public String getUstOwnerBusinessURL() {
		return ustOwnerBusinessURL;
	}

	public void setUstOwnerBusinessURL(String ustOwnerBusinessURL) {
		this.ustOwnerBusinessURL = ustOwnerBusinessURL;
	}

	public String getOperatorOwnerURL() {
		return operatorOwnerURL;
	}

	public void setOperatorOwnerURL(String operatorOwnerURL) {
		this.operatorOwnerURL = operatorOwnerURL;
	}

	public String getPropertyOwnerTaxIDURL() {
		return propertyOwnerTaxIDURL;
	}

	public void setPropertyOwnerTaxIDURL(String propertyOwnerTaxIDURL) {
		this.propertyOwnerTaxIDURL = propertyOwnerTaxIDURL;
	}

	public String getUstOwnerURL() {
		return ustOwnerURL;
	}

	public void setUstOwnerURL(String ustOwnerURL) {
		this.ustOwnerURL = ustOwnerURL;
	}

	public String getOperatorLeaseAgreementURL() {
		return operatorLeaseAgreementURL;
	}

	public void setOperatorLeaseAgreementURL(String operatorLeaseAgreementURL) {
		this.operatorLeaseAgreementURL = operatorLeaseAgreementURL;
	}

	public String getFinancialResponsibilityURL() {
		return financialResponsibilityURL;
	}

	public void setFinancialResponsibilityURL(String financialResponsibilityURL) {
		this.financialResponsibilityURL = financialResponsibilityURL;
	}

	public String getPropertyDeedLandContractURL() {
		return propertyDeedLandContractURL;
	}

	public void setPropertyDeedLandContractURL(String propertyDeedLandContractURL) {
		this.propertyDeedLandContractURL = propertyDeedLandContractURL;
	}

	public String getFacilitySiteMapURL() {
		return facilitySiteMapURL;
	}

	public void setFacilitySiteMapURL(String facilitySiteMapURL) {
		this.facilitySiteMapURL = facilitySiteMapURL;
	}

	public boolean isOperatorBusinessSubmitted() {
		return operatorBusinessSubmitted;
	}

	public void setOperatorBusinessSubmitted(boolean operatorBusinessSubmitted) {
		this.operatorBusinessSubmitted = operatorBusinessSubmitted;
	}

	public boolean isPropertyOwnerBusinessSubmitted() {
		return propertyOwnerBusinessSubmitted;
	}

	public void setPropertyOwnerBusinessSubmitted(boolean propertyOwnerBusinessSubmitted) {
		this.propertyOwnerBusinessSubmitted = propertyOwnerBusinessSubmitted;
	}

	public boolean isUstOwnerBusinessSubmitted() {
		return ustOwnerBusinessSubmitted;
	}

	public void setUstOwnerBusinessSubmitted(boolean ustOwnerBusinessSubmitted) {
		this.ustOwnerBusinessSubmitted = ustOwnerBusinessSubmitted;
	}

	public boolean isOperatorOwnerSubmitted() {
		return operatorOwnerSubmitted;
	}

	public void setOperatorOwnerSubmitted(boolean operatorOwnerSubmitted) {
		this.operatorOwnerSubmitted = operatorOwnerSubmitted;
	}

	public boolean isPropertyOwnerTaxIDSubmitted() {
		return propertyOwnerTaxIDSubmitted;
	}

	public void setPropertyOwnerTaxIDSubmitted(boolean propertyOwnerTaxIDSubmitted) {
		this.propertyOwnerTaxIDSubmitted = propertyOwnerTaxIDSubmitted;
	}

	public boolean isUstOwnerSubmitted() {
		return ustOwnerSubmitted;
	}

	public void setUstOwnerSubmitted(boolean ustOwnerSubmitted) {
		this.ustOwnerSubmitted = ustOwnerSubmitted;
	}

	public boolean isOperatorLeaseAgreementSubmitted() {
		return operatorLeaseAgreementSubmitted;
	}

	public void setOperatorLeaseAgreementSubmitted(boolean operatorLeaseAgreementSubmitted) {
		this.operatorLeaseAgreementSubmitted = operatorLeaseAgreementSubmitted;
	}

	public boolean isFinancialResponsibilitySubmitted() {
		return financialResponsibilitySubmitted;
	}

	public void setFinancialResponsibilitySubmitted(boolean financialResponsibilitySubmitted) {
		this.financialResponsibilitySubmitted = financialResponsibilitySubmitted;
	}

	public boolean isPropertyDeedLandContractSubmitted() {
		return propertyDeedLandContractSubmitted;
	}

	public void setPropertyDeedLandContractSubmitted(boolean propertyDeedLandContractSubmitted) {
		this.propertyDeedLandContractSubmitted = propertyDeedLandContractSubmitted;
	}

	public boolean isFacilitySiteMapSubmitted() {
		return facilitySiteMapSubmitted;
	}

	public void setFacilitySiteMapSubmitted(boolean facilitySiteMapSubmitted) {
		this.facilitySiteMapSubmitted = facilitySiteMapSubmitted;
	}

	public boolean isOperatorAcertificateSubmitted() {
		return operatorAcertificateSubmitted;
	}

	public void setOperatorAcertificateSubmitted(boolean operatorAcertificateSubmitted) {
		this.operatorAcertificateSubmitted = operatorAcertificateSubmitted;
	}

	public boolean isOperatorBcertificateSubmitted() {
		return operatorBcertificateSubmitted;
	}

	public void setOperatorBcertificateSubmitted(boolean operatorBcertificateSubmitted) {
		this.operatorBcertificateSubmitted = operatorBcertificateSubmitted;
	}

	public boolean isOperatorCcertificateSubmitted() {
		return operatorCcertificateSubmitted;
	}

	public void setOperatorCcertificateSubmitted(boolean operatorCcertificateSubmitted) {
		this.operatorCcertificateSubmitted = operatorCcertificateSubmitted;
	}

	public String getOperatorAcertificateURL() {
		return operatorAcertificateURL;
	}

	public void setOperatorAcertificateURL(String operatorAcertificateURL) {
		this.operatorAcertificateURL = operatorAcertificateURL;
	}

	public String getOperatorBcertificateURL() {
		return operatorBcertificateURL;
	}

	public void setOperatorBcertificateURL(String operatorBcertificateURL) {
		this.operatorBcertificateURL = operatorBcertificateURL;
	}

	public String getOperatorCcertificateURL() {
		return operatorCcertificateURL;
	}

	public void setOperatorCcertificateURL(String operatorCcertificateURL) {
		this.operatorCcertificateURL = operatorCcertificateURL;
	}

	public boolean isOperatorAcertificateEnable() {
		return operatorAcertificateEnable;
	}

	public void setOperatorAcertificateEnable(boolean operatorAcertificateEnable) {
		this.operatorAcertificateEnable = operatorAcertificateEnable;
	}

	public boolean isOperatorBcertificateEnable() {
		return operatorBcertificateEnable;
	}

	public void setOperatorBcertificateEnable(boolean operatorBcertificateEnable) {
		this.operatorBcertificateEnable = operatorBcertificateEnable;
	}

	public boolean isOperatorCcertificateEnable() {
		return operatorCcertificateEnable;
	}

	public void setOperatorCcertificateEnable(boolean operatorCcertificateEnable) {
		this.operatorCcertificateEnable = operatorCcertificateEnable;
	}

	public boolean isReleaseDetectionReportEnable() {
		return releaseDetectionReportEnable;
	}

	public void setReleaseDetectionReportEnable(boolean releaseDetectionReportEnable) {
		this.releaseDetectionReportEnable = releaseDetectionReportEnable;
	}

	public boolean isRepairDocumentsEnable() {
		return repairDocumentsEnable;
	}

	public void setRepairDocumentsEnable(boolean repairDocumentsEnable) {
		this.repairDocumentsEnable = repairDocumentsEnable;
	}

	public boolean isLineAndLeakDetectorEnable() {
		return lineAndLeakDetectorEnable;
	}

	public void setLineAndLeakDetectorEnable(boolean lineAndLeakDetectorEnable) {
		this.lineAndLeakDetectorEnable = lineAndLeakDetectorEnable;
	}

	public boolean isTankTestingReportEnable() {
		return tankTestingReportEnable;
	}

	public void setTankTestingReportEnable(boolean tankTestingReportEnable) {
		this.tankTestingReportEnable = tankTestingReportEnable;
	}

	public boolean isCathodicProtectionEnable() {
		return cathodicProtectionEnable;
	}

	public void setCathodicProtectionEnable(boolean cathodicProtectionEnable) {
		this.cathodicProtectionEnable = cathodicProtectionEnable;
	}

	public boolean isInternalLiningInspectionEnable() {
		return internalLiningInspectionEnable;
	}

	public void setInternalLiningInspectionEnable(boolean internalLiningInspectionEnable) {
		this.internalLiningInspectionEnable = internalLiningInspectionEnable;
	}

	public boolean isPipingCathodicProtectionEnable() {
		return pipingCathodicProtectionEnable;
	}

	public void setPipingCathodicProtectionEnable(boolean pipingCathodicProtectionEnable) {
		this.pipingCathodicProtectionEnable = pipingCathodicProtectionEnable;
	}

	public boolean isDropTubeRepairDocumentEnable() {
		return dropTubeRepairDocumentEnable;
	}

	public void setDropTubeRepairDocumentEnable(boolean dropTubeRepairDocumentEnable) {
		this.dropTubeRepairDocumentEnable = dropTubeRepairDocumentEnable;
	}

	public boolean isTankInterstitialMonitoringEnable() {
		return tankInterstitialMonitoringEnable;
	}

	public void setTankInterstitialMonitoringEnable(boolean tankInterstitialMonitoringEnable) {
		this.tankInterstitialMonitoringEnable = tankInterstitialMonitoringEnable;
	}

	public boolean isPipinginterstitialMonitoringEnable() {
		return pipinginterstitialMonitoringEnable;
	}

	public void setPipinginterstitialMonitoringEnable(boolean pipinginterstitialMonitoringEnable) {
		this.pipinginterstitialMonitoringEnable = pipinginterstitialMonitoringEnable;
	}

	public boolean isAtgTestReportEnable() {
		return atgTestReportEnable;
	}

	public void setAtgTestReportEnable(boolean atgTestReportEnable) {
		this.atgTestReportEnable = atgTestReportEnable;
	}

	public boolean isAtgRepairReportEnable() {
		return atgRepairReportEnable;
	}

	public void setAtgRepairReportEnable(boolean atgRepairReportEnable) {
		this.atgRepairReportEnable = atgRepairReportEnable;
	}

	public boolean isSpillBucketTestingDocumentEnable() {
		return spillBucketTestingDocumentEnable;
	}

	public void setSpillBucketTestingDocumentEnable(boolean spillBucketTestingDocumentEnable) {
		this.spillBucketTestingDocumentEnable = spillBucketTestingDocumentEnable;
	}

	public boolean isSpillBucketRepairDocumentEnable() {
		return spillBucketRepairDocumentEnable;
	}

	public void setSpillBucketRepairDocumentEnable(boolean spillBucketRepairDocumentEnable) {
		this.spillBucketRepairDocumentEnable = spillBucketRepairDocumentEnable;
	}

	public boolean isSumpMaintenanceDocumentEnable() {
		return sumpMaintenanceDocumentEnable;
	}

	public void setSumpMaintenanceDocumentEnable(boolean sumpMaintenanceDocumentEnable) {
		this.sumpMaintenanceDocumentEnable = sumpMaintenanceDocumentEnable;
	}

	public boolean isUdcMaintenanceDocumentEnable() {
		return udcMaintenanceDocumentEnable;
	}

	public void setUdcMaintenanceDocumentEnable(boolean udcMaintenanceDocumentEnable) {
		this.udcMaintenanceDocumentEnable = udcMaintenanceDocumentEnable;
	}

	public boolean isSirReportEnable() {
		return sirReportEnable;
	}

	public void setSirReportEnable(boolean sirReportEnable) {
		this.sirReportEnable = sirReportEnable;
	}

	public boolean isMonthlyWalkThroughReportEnable() {
		return monthlyWalkThroughReportEnable;
	}

	public void setMonthlyWalkThroughReportEnable(boolean monthlyWalkThroughReportEnable) {
		this.monthlyWalkThroughReportEnable = monthlyWalkThroughReportEnable;
	}

	public boolean isTankMonitorStaticIPEnable() {
		return tankMonitorStaticIPEnable;
	}

	public void setTankMonitorStaticIPEnable(boolean tankMonitorStaticIPEnable) {
		this.tankMonitorStaticIPEnable = tankMonitorStaticIPEnable;
	}

	public boolean isReleaseDetectionReportSubmitted() {
		return releaseDetectionReportSubmitted;
	}

	public void setReleaseDetectionReportSubmitted(boolean releaseDetectionReportSubmitted) {
		this.releaseDetectionReportSubmitted = releaseDetectionReportSubmitted;
	}

	public boolean isRepairDocumentsSubmitted() {
		return repairDocumentsSubmitted;
	}

	public void setRepairDocumentsSubmitted(boolean repairDocumentsSubmitted) {
		this.repairDocumentsSubmitted = repairDocumentsSubmitted;
	}

	public boolean isLineAndLeakDetectorSubmitted() {
		return lineAndLeakDetectorSubmitted;
	}

	public void setLineAndLeakDetectorSubmitted(boolean lineAndLeakDetectorSubmitted) {
		this.lineAndLeakDetectorSubmitted = lineAndLeakDetectorSubmitted;
	}

	public boolean isTankTestingReportSubmitted() {
		return tankTestingReportSubmitted;
	}

	public void setTankTestingReportSubmitted(boolean tankTestingReportSubmitted) {
		this.tankTestingReportSubmitted = tankTestingReportSubmitted;
	}

	public boolean isCathodicProtectionSubmitted() {
		return cathodicProtectionSubmitted;
	}

	public void setCathodicProtectionSubmitted(boolean cathodicProtectionSubmitted) {
		this.cathodicProtectionSubmitted = cathodicProtectionSubmitted;
	}

	public boolean isInternalLiningInspectionSubmitted() {
		return internalLiningInspectionSubmitted;
	}

	public void setInternalLiningInspectionSubmitted(boolean internalLiningInspectionSubmitted) {
		this.internalLiningInspectionSubmitted = internalLiningInspectionSubmitted;
	}

	public boolean isPipingCathodicProtectionSubmitted() {
		return pipingCathodicProtectionSubmitted;
	}

	public void setPipingCathodicProtectionSubmitted(boolean pipingCathodicProtectionSubmitted) {
		this.pipingCathodicProtectionSubmitted = pipingCathodicProtectionSubmitted;
	}

	public boolean isDropTubeRepairDocumentSubmitted() {
		return dropTubeRepairDocumentSubmitted;
	}

	public void setDropTubeRepairDocumentSubmitted(boolean dropTubeRepairDocumentSubmitted) {
		this.dropTubeRepairDocumentSubmitted = dropTubeRepairDocumentSubmitted;
	}

	public boolean isTankInterstitialMonitoringSubmitted() {
		return tankInterstitialMonitoringSubmitted;
	}

	public void setTankInterstitialMonitoringSubmitted(boolean tankInterstitialMonitoringSubmitted) {
		this.tankInterstitialMonitoringSubmitted = tankInterstitialMonitoringSubmitted;
	}

	public boolean isPipinginterstitialMonitoringSubmitted() {
		return pipinginterstitialMonitoringSubmitted;
	}

	public void setPipinginterstitialMonitoringSubmitted(boolean pipinginterstitialMonitoringSubmitted) {
		this.pipinginterstitialMonitoringSubmitted = pipinginterstitialMonitoringSubmitted;
	}

	public boolean isAtgTestReportSubmitted() {
		return atgTestReportSubmitted;
	}

	public void setAtgTestReportSubmitted(boolean atgTestReportSubmitted) {
		this.atgTestReportSubmitted = atgTestReportSubmitted;
	}

	public boolean isAtgRepairReportSubmitted() {
		return atgRepairReportSubmitted;
	}

	public void setAtgRepairReportSubmitted(boolean atgRepairReportSubmitted) {
		this.atgRepairReportSubmitted = atgRepairReportSubmitted;
	}

	public boolean isSpillBucketTestingDocumentSubmitted() {
		return spillBucketTestingDocumentSubmitted;
	}

	public void setSpillBucketTestingDocumentSubmitted(boolean spillBucketTestingDocumentSubmitted) {
		this.spillBucketTestingDocumentSubmitted = spillBucketTestingDocumentSubmitted;
	}

	public boolean isSpillBucketRepairDocumentSubmitted() {
		return spillBucketRepairDocumentSubmitted;
	}

	public void setSpillBucketRepairDocumentSubmitted(boolean spillBucketRepairDocumentSubmitted) {
		this.spillBucketRepairDocumentSubmitted = spillBucketRepairDocumentSubmitted;
	}

	public boolean isSumpMaintenanceDocumentSubmitted() {
		return sumpMaintenanceDocumentSubmitted;
	}

	public void setSumpMaintenanceDocumentSubmitted(boolean sumpMaintenanceDocumentSubmitted) {
		this.sumpMaintenanceDocumentSubmitted = sumpMaintenanceDocumentSubmitted;
	}

	public boolean isUdcMaintenanceDocumentSubmitted() {
		return udcMaintenanceDocumentSubmitted;
	}

	public void setUdcMaintenanceDocumentSubmitted(boolean udcMaintenanceDocumentSubmitted) {
		this.udcMaintenanceDocumentSubmitted = udcMaintenanceDocumentSubmitted;
	}

	public boolean isSirReportSubmitted() {
		return sirReportSubmitted;
	}

	public void setSirReportSubmitted(boolean sirReportSubmitted) {
		this.sirReportSubmitted = sirReportSubmitted;
	}

	public boolean isMonthlyWalkThroughReportSubmitted() {
		return monthlyWalkThroughReportSubmitted;
	}

	public void setMonthlyWalkThroughReportSubmitted(boolean monthlyWalkThroughReportSubmitted) {
		this.monthlyWalkThroughReportSubmitted = monthlyWalkThroughReportSubmitted;
	}

	public boolean isTankMonitorStaticIPSubmitted() {
		return tankMonitorStaticIPSubmitted;
	}

	public void setTankMonitorStaticIPSubmitted(boolean tankMonitorStaticIPSubmitted) {
		this.tankMonitorStaticIPSubmitted = tankMonitorStaticIPSubmitted;
	}

	public String getReleaseDetectionReportURL() {
		return releaseDetectionReportURL;
	}

	public void setReleaseDetectionReportURL(String releaseDetectionReportURL) {
		this.releaseDetectionReportURL = releaseDetectionReportURL;
	}

	public String getRepairDocumentsURL() {
		return repairDocumentsURL;
	}

	public void setRepairDocumentsURL(String repairDocumentsURL) {
		this.repairDocumentsURL = repairDocumentsURL;
	}

	public String getLineAndLeakDetectorURL() {
		return lineAndLeakDetectorURL;
	}

	public void setLineAndLeakDetectorURL(String lineAndLeakDetectorURL) {
		this.lineAndLeakDetectorURL = lineAndLeakDetectorURL;
	}

	public String getTankTestingReportURL() {
		return tankTestingReportURL;
	}

	public void setTankTestingReportURL(String tankTestingReportURL) {
		this.tankTestingReportURL = tankTestingReportURL;
	}

	public String getCathodicProtectionURL() {
		return cathodicProtectionURL;
	}

	public void setCathodicProtectionURL(String cathodicProtectionURL) {
		this.cathodicProtectionURL = cathodicProtectionURL;
	}

	public String getInternalLiningInspectionURL() {
		return internalLiningInspectionURL;
	}

	public void setInternalLiningInspectionURL(String internalLiningInspectionURL) {
		this.internalLiningInspectionURL = internalLiningInspectionURL;
	}

	public String getPipingCathodicProtectionURL() {
		return pipingCathodicProtectionURL;
	}

	public void setPipingCathodicProtectionURL(String pipingCathodicProtectionURL) {
		this.pipingCathodicProtectionURL = pipingCathodicProtectionURL;
	}

	public String getDropTubeRepairDocumentURL() {
		return dropTubeRepairDocumentURL;
	}

	public void setDropTubeRepairDocumentURL(String dropTubeRepairDocumentURL) {
		this.dropTubeRepairDocumentURL = dropTubeRepairDocumentURL;
	}

	public String getTankInterstitialMonitoringURL() {
		return tankInterstitialMonitoringURL;
	}

	public void setTankInterstitialMonitoringURL(String tankInterstitialMonitoringURL) {
		this.tankInterstitialMonitoringURL = tankInterstitialMonitoringURL;
	}

	public String getPipinginterstitialMonitoringURL() {
		return pipinginterstitialMonitoringURL;
	}

	public void setPipinginterstitialMonitoringURL(String pipinginterstitialMonitoringURL) {
		this.pipinginterstitialMonitoringURL = pipinginterstitialMonitoringURL;
	}

	public String getAtgTestReportURL() {
		return atgTestReportURL;
	}

	public void setAtgTestReportURL(String atgTestReportURL) {
		this.atgTestReportURL = atgTestReportURL;
	}

	public String getAtgRepairReportURL() {
		return atgRepairReportURL;
	}

	public void setAtgRepairReportURL(String atgRepairReportURL) {
		this.atgRepairReportURL = atgRepairReportURL;
	}

	public String getSpillBucketTestingDocumentURL() {
		return spillBucketTestingDocumentURL;
	}

	public void setSpillBucketTestingDocumentURL(String spillBucketTestingDocumentURL) {
		this.spillBucketTestingDocumentURL = spillBucketTestingDocumentURL;
	}

	public String getSpillBucketRepairDocumentURL() {
		return spillBucketRepairDocumentURL;
	}

	public void setSpillBucketRepairDocumentURL(String spillBucketRepairDocumentURL) {
		this.spillBucketRepairDocumentURL = spillBucketRepairDocumentURL;
	}

	public String getSumpMaintenanceDocumentURL() {
		return sumpMaintenanceDocumentURL;
	}

	public void setSumpMaintenanceDocumentURL(String sumpMaintenanceDocumentURL) {
		this.sumpMaintenanceDocumentURL = sumpMaintenanceDocumentURL;
	}

	public String getUdcMaintenanceDocumentURL() {
		return udcMaintenanceDocumentURL;
	}

	public void setUdcMaintenanceDocumentURL(String udcMaintenanceDocumentURL) {
		this.udcMaintenanceDocumentURL = udcMaintenanceDocumentURL;
	}

	public String getSirReportURL() {
		return sirReportURL;
	}

	public void setSirReportURL(String sirReportURL) {
		this.sirReportURL = sirReportURL;
	}

	public String getMonthlyWalkThroughReportURL() {
		return monthlyWalkThroughReportURL;
	}

	public void setMonthlyWalkThroughReportURL(String monthlyWalkThroughReportURL) {
		this.monthlyWalkThroughReportURL = monthlyWalkThroughReportURL;
	}

	public String getTankMonitorStaticIPURL() {
		return tankMonitorStaticIPURL;
	}

	public void setTankMonitorStaticIPURL(String tankMonitorStaticIPURL) {
		this.tankMonitorStaticIPURL = tankMonitorStaticIPURL;
	}

	public String getCofaLink() {
		return cofaLink;
	}

	public void setCofaLink(String cofaLink) {
		this.cofaLink = cofaLink;
	}

	public boolean isCofaLinkEnable() {
		return cofaLinkEnable;
	}

	public void setCofaLinkEnable(boolean cofaLinkEnable) {
		this.cofaLinkEnable = cofaLinkEnable;
	}

	public boolean isCofaLinkSubmitted() {
		return cofaLinkSubmitted;
	}

	public void setCofaLinkSubmitted(boolean cofaLinkSubmitted) {
		this.cofaLinkSubmitted = cofaLinkSubmitted;
	}

}
