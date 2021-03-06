import { Component, OnInit, ViewChild, Input } from '@angular/core';
import {RequestOptions, Request, RequestMethod} from '@angular/http';
import { Observable } from 'rxjs';
import { Headers } from '@angular/http'
declare var $: any;
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { ImportFieldValues } from './import.mapping';
import { FileUpload } from 'primeng/primeng';
import { ImportService } from '../services/import.service';
import { CommonService } from '../services/common.service';
@Component({
  selector: 'golars-import',
  templateUrl: './import.component.html',
  styleUrls: ['./import.component.css']
})
export class ImportComponent implements OnInit {
  importForm;
  @ViewChild('fileInput') fileInput: FileUpload;
  @Input() selectedFolder;
  docTypes=[];
  docTypesFullList = ImportFieldValues.docTypeMapping;
  stateProgram= ImportFieldValues.stateProgramMapping;
  compliaceDocumentTypes = ImportFieldValues.compliaceDocumentTypes;
  regulatoryTypes = ImportFieldValues.regulatoryTypes;
  complianceStatuses = ImportFieldValues.complianceStatuses;
  importTypes = ImportFieldValues.importTypes;
  scopeOfWork = [];
  scopeOfWorkFullList = ImportFieldValues.scopeOfWorkMapping;
  stateProgramMappingForDocumentType = ImportFieldValues.stateProgramMappingForDocumentType;
  stateProgramMappingForScopeOfWork = ImportFieldValues.stateProgramMappingForScopeOfWork;
  editDocument = false;
  importDocName;
  docData ;
  showSuccessMessage=false;
  showFileSelectWarningMessage=false;
  successMessage=null;
  showFileSelectErrorMessage=false;
  fileSelectErrorMessage=null;
  fileSelectWarningMessage= null;
  importFolder;
  disableImportButton = false;
defaultdate;
  model: any = {};
  
  constructor(private http: HttpClient,private importService: ImportService,private commonService: CommonService) { }

  ngOnInit() {

    
    this.model.importType = ImportFieldValues.importTypes[0].value;
    var self = this;
    $('body').on('hide.bs.modal', '.modal', function ($event) {
      if ($event.target.id != "importModal") return;

      self.commonService.removeEditUser();
      self.showSuccessMessage = false;
      self.successMessage = null;
      self.showFileSelectErrorMessage = false;
      self.fileSelectErrorMessage = null;
      if(self.fileInput!=null)
      self.fileInput.files = [];
      self.model = {}
      self.model.docUpdateDate = new Date();
      self.editDocument = false;
      

    })
  $('body').on('show.bs.modal', '.modal', function($event){
    if($event.target.id!="importModal") return;
    if (self.commonService.getDocData() != null) {
        
      self.editDocument = true;
      var docData = JSON.parse(localStorage.getItem("docData"));
      self.docData  = docData;
      self.fillImportDialogData(docData)
    }
    if(self.commonService.getStateProgramPreferences()!=null){
      self.stateProgram=[];
    var stateProgramValues = self.commonService.getStateProgramPreferences();
    self.stateProgramMappingForDocumentType = self.commonService.getDocumentTypePreferences();
    self.stateProgramMappingForScopeOfWork = self.commonService.getScopeOfWorkPreferences();
    self.compliaceDocumentTypes   = self.commonService.getComplianceDocTypePreferences();
    for(var i=0;i<stateProgramValues.length;i++){
      if(stateProgramValues[i].enable){
        if(stateProgramValues[i] !=null && stateProgramValues[i].value == 'IN-Brownfields'){
          stateProgramValues[i].value = 'IN - Brownfields';
        }
        self.stateProgram.push(stateProgramValues[i]);
    }
    }
    self.model.importType = ImportFieldValues.importTypes[0].value;
  }

})

  this.commonService.notifyObservable$.subscribe((treeNode) => {
    if(treeNode !== null && treeNode !== undefined && treeNode.type === "fetchSubFolders"){
    if(treeNode.node.label !== null){
    this.selectedFolder = treeNode.node;
    this.importFolder = treeNode.node.label;

    }
}
});
// set default value for Date Document updated
this.model.docUpdateDate = new Date();
  }
  fillImportDialogData(docData) {
    this.importDocName = docData.label;
    // this.fileInput.files[0] = new File([""], docData.label);
    if (docData.properties.docUpdateDate != null)
      this.model.docUpdateDate = new Date(docData.properties.docUpdateDate);
    this.model.fecilityName = docData.properties.fecilityName;
    if (docData.properties.docDate != null)
      this.model.docDate = new Date(docData.properties.docDate);
    this.model.fid = docData.properties.fid;
    this.model.city = docData.properties.city;
    this.model.street = docData.properties.street;
    this.model.stateProgram = docData.properties.stateProgram;
    this.getStateProgramAndScopeOfWorkDropDOwn(null)
    this.model.active = docData.properties.active;
    this.model.docTypes = docData.properties.docTypes;
     this.model.facilityRelated = docData.properties.facilityRelated == null?true:docData.properties.facilityRelated;
    this.model.compliaceDocumentType = docData.properties.compliaceDocumentType;
    this.model.regulatoryRecordActive = docData.properties.regulatoryRecordActive;
    this.model.regulatoryRecord = docData.properties.regulatoryRecord;
    this.model.regulatoryType = docData.properties.regulatoryType;
    this.model.description = docData.properties.description;
    if(docData.properties.scopeOfWork != null && docData.properties.scopeOfWork.length>0 && docData.properties.scopeOfWork.indexOf(';')>0)
      this.constructScopeOfWorkArray(docData.properties.scopeOfWork);
    else if(docData.properties.scopeOfWork != null && Array.isArray(docData.properties.scopeOfWork))
      this.model.scopeOfWork = docData.properties.scopeOfWork;
    else if(docData.properties.scopeOfWork!=null)
      this.model.scopeOfWork.push(docData.properties.scopeOfWork);

  }
  constructScopeOfWorkArray(scopeofworkObj){
    var docSworkArray = scopeofworkObj.split(";")
    this.model.scopeOfWork = docSworkArray;
  }
  resetSuccessFailureMessages(){
    this.showSuccessMessage = false;
    this.showFileSelectErrorMessage=false;  
  }
  updateDocumentProperties(){
    // console.log(this.docData)
    var docProperties = this.getDocumentProperties();
    this.docData.properties = JSON.parse(docProperties);
    this.disableImportButton =true;
    this.showSuccessMessage = false;
    this.showFileSelectErrorMessage=false;
    this.importService.updateDocumentPropeties(this.docData.parentid,this.docData.label,docProperties) .subscribe(
      message => {
        // console.log(message)
        if( message!= null && message.key != null && message.key == "fid" && message.value=="notexits"){
          this.showFileSelectErrorMessage=true;
          this.fileSelectErrorMessage="FID doesn't exists.";
          this.disableImportButton = false; 
          
          return;
        }
        if (message == true) {
          this.showSuccessMessage = true;
          this.successMessage = "Document Properties Updated Successfully !!";
          this.commonService.notify({ type: 'fetchSubFolders', node: this.selectedFolder, isDocumentsRequired: true });
          if (this.commonService.getDocData() != null) {
            this.commonService.notify({ type: 'documentDetails', node: this.docData, isDocumentsRequired: true });
            }
        }   
        this.disableImportButton=false;
      },
      error => {
        this.disableImportButton=false;
        console.log(error);
      });
  }
  importDocuments(){
// console.log(this.fileInput.files.length)
if(this.fileInput.files.length == 0){
  this.showFileSelectErrorMessage=true;
  this.fileSelectErrorMessage="Please select at least one file to Import"
  return;
}
const frmData = new FormData();

    
    for (var i = 0; i < this.fileInput.files.length; i++) { 
      // console.log(this.fileInput);
      frmData.append("fileUpload", this.fileInput.files[i]);
    }
    frmData.append("docProperties",this.getDocumentProperties());
    frmData.append("folderProperties",this.getFolderDetails());
    // frmData.set("documentProperties",this.getDocumentProperties())
    this.disableImportButton = true;
    this.showFileSelectErrorMessage=false;
    this.showSuccessMessage=false;
    this.showFileSelectWarningMessage=false;
    var importType = this.model.importType;
    this.importService.importDocuments(frmData)
    .subscribe(
        message => {
          // console.log(message)
          //check for fid error
          if( message!= null && message.key != null && message.key == "fid" && message.value=="notexits"){
            this.showFileSelectErrorMessage=true;
            this.fileSelectErrorMessage="FID doesn't exists.";
            this.disableImportButton = false; 
            return;
          }
          if( message!= null && message.key != null && message.key == "salesforce" && message.value=="warning"){
            this.showFileSelectWarningMessage=true;
            this.fileSelectWarningMessage="File uploaded successfully, However could not be loaded into Salesforce. Please report this issue to support team and update Salesforce manually to be in sync.";
            this.disableImportButton = false; 
            return;
          }
          if(message != null){
          this.showSuccessMessage=true;
          this.successMessage = "File(s) Imported Successfully !!";
          this.fileInput.files=[];
          this.model={}
          this.model.importType = importType;
          this.commonService.notify({ type: 'fetchSubFolders', node: this.selectedFolder, isDocumentsRequired: true });
        }else
        {
          this.showFileSelectErrorMessage=true;
          this.fileSelectErrorMessage="Document(s) already exists"
        }
        this.disableImportButton = false; 
        },
        error => {
          this.disableImportButton = false;
            console.log(error);
        });
  }
  onBasicUpload($event){
    this.showFileSelectErrorMessage=false;
  this.fileSelectErrorMessage=null;
  this.showSuccessMessage=false;
  this.successMessage = null;
  }
  setModalValue(activeCheckbox){
    if(activeCheckbox.checked)
    this.model.active.value='active';
    else
    this.model.active.value=''
  }
  getDocumentProperties(){
    // console.log(this.model)
    if(this.model.regulatoryType==null)
    this.model.regulatoryType = ImportFieldValues.regulatoryTypes[0].value;
    // if(this.model.complianceStatus==null)
    // this.model.complianceStatus = ImportFieldValues.complianceStatuses[0].value;
    this.model.docDate = new Date();
    return  JSON.stringify(this.model)
  }
  tmpFolder:any
  getFolderDetails(){
    this.tmpFolder = new Object()
    this.tmpFolder.username = this.selectedFolder.username;
    this. tmpFolder.parentid = this.selectedFolder.parentid;
    this.tmpFolder.label = this.selectedFolder.label;
    this.tmpFolder.id = this.selectedFolder.id;
    this.tmpFolder.folder = this.selectedFolder.folder;
    this.tmpFolder.expandedIcon = this.selectedFolder.expandedIcon;
    this.tmpFolder.collapsedIcon = this.selectedFolder.collapsedIcon;
    this.tmpFolder.expanded = this.selectedFolder.expanded;
    //  console.log( this.tmpFolder)
    return  JSON.stringify( this.tmpFolder)
  }
  getStateProgramAndScopeOfWorkDropDOwn($event){
    var selectedValue =null;
    if($event != null ) 
    selectedValue = $event.value;
    else 
    selectedValue =   this.model.stateProgram;
    // console.log(selectedValue)
    this.docTypes=[];
    this.scopeOfWork=[];
    this.model.scopeOfWork=[];
    for(var i=0;i<this.stateProgramMappingForDocumentType.length;i++){
      if(this.stateProgramMappingForDocumentType[i].label === selectedValue)
      this.constructDocumentType (this.stateProgramMappingForDocumentType[i].properties)
     
    // if(this.docTypesFullList[i].key != null && this.docTypesFullList[i].key.indexOf(selectedValue)>=0)
    // this.docTypes.push(this.docTypesFullList[i])
  }
  for(var i=0;i<this.stateProgramMappingForScopeOfWork.length;i++){
    if(this.stateProgramMappingForScopeOfWork[i].label === selectedValue)
    this.constructScopeOfObject (this.stateProgramMappingForScopeOfWork[i].properties)
  } 
  // for(var i=0;i<this.scopeOfWorkFullList.length;i++){
  //   if(this.scopeOfWorkFullList[i].key != null && this.scopeOfWorkFullList[i].key.indexOf(selectedValue)>=0)
  //   this.scopeOfWork.push(this.scopeOfWorkFullList[i])
  // } 
  }
  constructDocumentType(docTypeObj){
    for(var i=0;i<docTypeObj.length;i++)
    if(docTypeObj[i].enable != null && docTypeObj[i].enable == true)
    this.docTypes.push(docTypeObj[i])
  }
  constructScopeOfObject(docTypeObj){
    for(var i=0;i<docTypeObj.length;i++)
    if(docTypeObj[i].enable != null && docTypeObj[i].enable == true)
    this.scopeOfWork.push(docTypeObj[i])
  }

}
