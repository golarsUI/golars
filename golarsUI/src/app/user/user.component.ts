import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from '../services/user.service';
import { FormGroup, NgForm } from '@angular/forms';
import { CommonService } from '../services/common.service';
import { FolderService } from '../services/folder.service';
import { GolarsConstants } from '../constants/golarsconstants';
import { TreeNode, TreeModule, Tree } from 'primeng/primeng';

@Component({
  selector: 'golars-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  model: any = {};
  @ViewChild('userTree')  treeComponent: Tree;
  constructor(private userService: UserService, private commonService: CommonService, private folderService: FolderService) { }
  showSuccessMessage = false;
  showFailureMessage = false;
  successMessage = null;
  failureMessage = null;
  disableRegisterButton = false;
  selectedFiles=[];
  selectedFoldres=[];
  folderData: any;
  treeLoading = true;
  isEdit = false;
  user;
  folderArray=[];
  @ViewChild('f') formElem: NgForm;
  ngOnInit() {
    this.user = this.commonService.getEditUser();
    if (this.user !== null && this.user !== undefined) {
      this.user = JSON.parse(this.user);
      this.isEdit = true;
      this.populateFields();
    }
    this.folderService.fetchFolders("-1", null, false, this.commonService.getUserName(), this.commonService.isAdmin()) // retrieve all thd parent folders
      .subscribe(
        data => {
          data.forEach(element => {
            this.addFolderClass(element,null);
          });
          
          this.treeLoading = false;
          this.folderData = data;
          this.selectFolders()
          // data.forEach(function(entry) {
          //     console.log(entry);
          // })
        },
        error => {
          console.log(error);
        });

  }

  register() {
    this.resetSuccessAndFailureMessages();
    if(this.isEdit){
      this.model.edit = this.isEdit;
    }
    this.model.newlyCreated = true;
    this.userService.registerUser(this.model)
      .subscribe(
        result => {
          if (result == true) {

            // this.model=[];
            this.showSuccessMessage = true;
            if(this.isEdit){
              this.successMessage = "User Updated Successfully.";
            }else

            this.successMessage = "User Created Successfully.";
            this.disableRegisterButton = true;
            //   this.model=[];
            //   this.formElem.form.reset();
            //   Object.keys(this.formElem.controls).forEach(control => {
            //     this.formElem.controls[control].setErrors(null);
            //     this.formElem.controls[control].markAsPristine();

            // });
          } else {
            this.showFailureMessage = true;
            this.failureMessage = "User Already Exists.";
          }
          // console.log(result)
        },
        error => {
          console.log(error)
        });
  }
  selectTreeNode(children,id){
    for(var i=0;i<children.length;i++){
        var folder = children[i];
        if(folder.id == id){
          this.folder = folder;
          return ;
            // folder.expanded = true;
            // this.treeComponent.selection = folder;
        //    this.expandChildren(this.treeComponent.selection)
        }
        
        else{
        //   folder.expanded=true;
       this.selectTreeNode(folder.children,id)
    }

    }
}
addFolderClass(element,parent) {
  element.expandedIcon = GolarsConstants.FOLDER_OPEN_ICON;
  element.collapsedIcon = GolarsConstants.FOLDER_CLOSE_ICON;
  if(this.folderArray.indexOf(element.id.toString())>=0){
  this.selectedFoldres.push(element.id);
}
  if(parent != null)
  element.parent = parent;
  parent = element;
  if (element.children != null && element.children.length > 0)
      element.children.forEach(element => {
          element.parent = parent;
          this.addFolderClass(element,parent);
      });

}
expandParent(node){
  node.expanded=true;
  if(!node.selected)
    node.partialSelected =true;
    if(node.parent){
      if(node.parent!=null)
      this.expandParent(node.parent)
     
    }
  }
  folder;
  selectFolders() {
   for(var i=0;i<this.selectedFoldres.length;i++){
    this.folder=null;
    this.selectTreeNode(this.folderData,Number(this.selectedFoldres[i]))
    if (this.folder != null){
      this. folder.expanded=true;
      this. folder.selected=true;
      this.selectedFiles.push(this.folder);
      // this.treeComponent.selection = folder;
      this.expandParent(this.folder)
  }
   }
  }
  fillPermissionField() {
    this.model.filePermission = "";
    this.model.permissonFolderID = ""
    for (var i = 0; i < this.selectedFiles.length; i++) {
      this.model.filePermission += this.selectedFiles[i].label;
      this.model.permissonFolderID += this.selectedFiles[i].id+"%%$%%"+this.selectedFiles[i].label;
      if (i < this.selectedFiles.length - 1) {
        this.model.filePermission += ",";
        this.model.permissonFolderID += ",";
      }
    }
  }
  resetSuccessAndFailureMessages() {
    this.showSuccessMessage = false;
    this.showFailureMessage = false;
    this.successMessage = null;
    this.failureMessage = null;
    this.disableRegisterButton = false;
  }
  populateFields() {
    this.model.firstName = this.user.firstName;
    this.model.lastName = this.user.lastName;
    this.model.email = this.user.emailAddress;
    this.model.admin = this.user.admin;
    this.model.active = this.user.active;
    console.log("this.user.permissonFolderID ---",this.user.permissonFolderID)
    if(this.user.permissonFolderID == null || this.user.permissonFolderID == undefined)
    this.user.permissonFolderID="";
    var folderNameArray = this.user.permissonFolderID.split(",");
    var folderDisplayName = "";
    if(folderNameArray.length>0){
    for(var j=0;j<folderNameArray.length;j++){
      var folderName=""
      if(folderNameArray[j].indexOf("%%$%%")>=0){
      folderName =  folderNameArray[j].substring(folderNameArray[j].indexOf("%%$%%")+5);
      this.folderArray.push(folderNameArray[j].substring(0,folderNameArray[j].indexOf("%%$%%")))
    }
      else
      folderName = folderNameArray[j];
      
      folderDisplayName+=folderName;
      if(j < folderNameArray.length-1)
      folderDisplayName+=", "
    }
  }else{
    folderDisplayName = folderNameArray;
  }
    this.model.filePermission = folderDisplayName;
    this.model.username = this.user.username;
    this.model.password = this.user.password;
  }
}
