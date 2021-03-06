import { Component, OnInit } from '@angular/core';
import { FolderService } from '../services/folder.service';
import { CommonService } from '../services/common.service';
import { GolarsConstants } from '../constants/golarsconstants';

@Component({
  selector: 'golars-rightpanel',
  templateUrl: './rightpanel.component.html',
  styleUrls: ['./rightpanel.component.css']
})
export class RightpanelComponent implements OnInit {

  docData = [];
  docName;
  treeNode;
  documentProperties = false;
  folderSelected = true;
  docURL: string = '';
  copyclicked = false;
  copyButtontitle = "Copy URL";
  docID;
  renderIframe = false;
  constructor(private folderService: FolderService, private commonService: CommonService) { }

  ngOnInit() {

    this.commonService.notifyObservable$.subscribe((treeNode) => {
      if ((treeNode !== null && treeNode !== undefined) && (treeNode.type === "fetchSubFolders" || treeNode.type == "clearRightSidePanel")) {
        if (this.commonService.getDocData() == null) {
          this.docID = treeNode.node.id;
          this.docData = [];
          this.folderSelected = true;
        }
      }
      if ((treeNode !== null && treeNode !== undefined) && (treeNode.type === "documentDetails" && treeNode.node != null && treeNode.node.folder === false)) {
        this.copyclicked = false;
        this.docID = this.getDocumentId(treeNode.node);
        this.copyButtontitle = "Copy URL";
        this.documentProperties = true;
        this.folderSelected = false;
        this.docName = treeNode.node.label;
        this.docData = [];
        this.treeNode = treeNode;
        this.docData = treeNode.node.properties;
        this.documentProperties = false;
        this.constructURL();
        // this.folderService.fetchDocumentDetails(treeNode.node.label)
        // .subscribe(
        //   fetchDocumentDetails => {
        //       this.documentProperties = false;
        //       this.docData = fetchDocumentDetails; 
        //       console.log(fetchDocumentDetails)
        //     },
        //     error => {
        //         console.log(error);
        //     });

      } else if ((treeNode !== null && treeNode !== undefined && treeNode.node !== undefined) && (treeNode.type === "documentDetails" && treeNode.node.folder === true)) {
        this.docData = [];
        this.folderSelected = true;
      }
    });
  }
  constructURL() {
    this.docURL = location.origin + GolarsConstants.DOWNLOAD_DOC_URL + this.docID + "/" + encodeURI(this.docName);
  }
  getDocURL() {
    return this.docURL + "#zoom=75"
  }
  getDocPropertiesValue() {
    if (this.docName == null) return "";
    return "File properties of " + this.docName;
  }
  getDocumentId(node) {
    return node.parentid.substring(node.parentid.length - 7)
  }
  
}