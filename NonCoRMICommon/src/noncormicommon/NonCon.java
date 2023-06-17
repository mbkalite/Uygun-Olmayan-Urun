/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noncormicommon;

import java.io.Serializable;

/**
 *
 * @author mkaplan
 */
public class NonCon implements Serializable{
    int NonConId, ConApproval, TrainingStatus, Requester, 
            Chef, Manager, CorrectiveActId, RejectProductId1, 
            WriterId, RequesterId, ChefId, ManagerId, RequesterScrap, ChefScrap, ManagerScrap, delete;
    String NonConSDate,NonConFDate,NonConProduct, NonConDprtmn, DetectivePer, NonConDetail, NonConType, 
            NonConCause, ConApprovalDetail, TrainingDetails, RequestChngs, RequestTime, chefName; 

    public NonCon(){
        
    }

    public NonCon(int NonConId, int ConApproval, int TrainingStatus, int Requester, int Chef, int Manager, int CorrectiveActId, int RejectProductId1, int RejectProductId2, int RejectProductId3, int WriterId, int RequesterId, int ChefId, int ManagerId, int RequesterScrap, int ChefScrap, int ManagerScrap, int delete, String NonConSDate, String NonConFDate, String NonConProduct, String NonConDprtmn, String DetectivePer, String NonConDetail, String NonConType, String NonConCause, String ConApprovalDetail, String TrainingDetails, String RequestChngs, String RequestTime, String ChefName) {
        this.NonConId = NonConId;
        this.ConApproval = ConApproval;
        this.TrainingStatus = TrainingStatus;
        this.Requester = Requester;
        this.Chef = Chef;
        this.Manager = Manager;
        this.CorrectiveActId = CorrectiveActId;
        this.RejectProductId1 = RejectProductId1;
        this.WriterId = WriterId;
        this.RequesterId = RequesterId;
        this.ChefId = ChefId;
        this.ManagerId = ManagerId;
        this.RequesterScrap = RequesterScrap;
        this.ChefScrap = ChefScrap;
        this.ManagerScrap = ManagerScrap;
        this.delete = delete;
        this.NonConSDate = NonConSDate;
        this.NonConFDate = NonConFDate;
        this.NonConProduct = NonConProduct;
        this.NonConDprtmn = NonConDprtmn;
        this.DetectivePer = DetectivePer;
        this.NonConDetail = NonConDetail;
        this.NonConType = NonConType;
        this.NonConCause = NonConCause;
        this.ConApprovalDetail = ConApprovalDetail;
        this.TrainingDetails = TrainingDetails;
        this.RequestChngs = RequestChngs;
        this.RequestTime = RequestTime;
        this.chefName = ChefName; 
    }

    public int getNonConId() {
        return NonConId;
    }

    public void setNonConId(int NonConId) {
        this.NonConId = NonConId;
    }

    public int getConApproval() {
        return ConApproval;
    }

    public void setConApproval(int ConApproval) {
        this.ConApproval = ConApproval;
    }

    public int getTrainingStatus() {
        return TrainingStatus;
    }

    public void setTrainingStatus(int TrainingStatus) {
        this.TrainingStatus = TrainingStatus;
    }

    public int getRequester() {
        return Requester;
    }

    public void setRequester(int Requester) {
        this.Requester = Requester;
    }

    public int getChef() {
        return Chef;
    }

    public void setChef(int Chef) {
        this.Chef = Chef;
    }

    public int getManager() {
        return Manager;
    }

    public void setManager(int Manager) {
        this.Manager = Manager;
    }

    public int getCorrectiveActId() {
        return CorrectiveActId;
    }

    public void setCorrectiveActId(int CorrectiveActId) {
        this.CorrectiveActId = CorrectiveActId;
    }

    public int getRejectProductId1() {
        return RejectProductId1;
    }

    public void setRejectProductId1(int RejectProductId1) {
        this.RejectProductId1 = RejectProductId1;
    }

    public int getWriterId() {
        return WriterId;
    }

    public void setWriterId(int WriterId) {
        this.WriterId = WriterId;
    }

    public int getRequesterId() {
        return RequesterId;
    }

    public void setRequesterId(int RequesterId) {
        this.RequesterId = RequesterId;
    }

    public int getChefId() {
        return ChefId;
    }

    public void setChefId(int ChefId) {
        this.ChefId = ChefId;
    }

    public int getManagerId() {
        return ManagerId;
    }

    public void setManagerId(int ManagerId) {
        this.ManagerId = ManagerId;
    }

    public int getRequesterScrap() {
        return RequesterScrap;
    }

    public void setRequesterScrap(int RequesterScrap) {
        this.RequesterScrap = RequesterScrap;
    }

    public int getChefScrap() {
        return ChefScrap;
    }

    public void setChefScrap(int ChefScrap) {
        this.ChefScrap = ChefScrap;
    }

    public int getManagerScrap() {
        return ManagerScrap;
    }

    public void setManagerScrap(int ManagerScrap) {
        this.ManagerScrap = ManagerScrap;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public String getNonConSDate() {
        return NonConSDate;
    }

    public void setNonConSDate(String NonConSDate) {
        this.NonConSDate = NonConSDate;
    }

    public String getNonConFDate() {
        return NonConFDate;
    }

    public void setNonConFDate(String NonConFDate) {
        this.NonConFDate = NonConFDate;
    }

    public String getNonConProduct() {
        return NonConProduct;
    }

    public void setNonConProduct(String NonConProduct) {
        this.NonConProduct = NonConProduct;
    }

    public String getNonConDprtmn() {
        return NonConDprtmn;
    }

    public void setNonConDprtmn(String NonConDprtmn) {
        this.NonConDprtmn = NonConDprtmn;
    }

    public String getDetectivePer() {
        return DetectivePer;
    }

    public void setDetectivePer(String DetectivePer) {
        this.DetectivePer = DetectivePer;
    }

    public String getNonConDetail() {
        return NonConDetail;
    }

    public void setNonConDetail(String NonConDetail) {
        this.NonConDetail = NonConDetail;
    }

    public String getNonConType() {
        return NonConType;
    }

    public void setNonConType(String NonConType) {
        this.NonConType = NonConType;
    }

    public String getNonConCause() {
        return NonConCause;
    }

    public void setNonConCause(String NonConCause) {
        this.NonConCause = NonConCause;
    }

    public String getConApprovalDetail() {
        return ConApprovalDetail;
    }

    public void setConApprovalDetail(String ConApprovalDetail) {
        this.ConApprovalDetail = ConApprovalDetail;
    }

    public String getTrainingDetails() {
        return TrainingDetails;
    }

    public void setTrainingDetails(String TrainingDetails) {
        this.TrainingDetails = TrainingDetails;
    }

    public String getRequestChngs() {
        return RequestChngs;
    }

    public void setRequestChngs(String RequestChngs) {
        this.RequestChngs = RequestChngs;
    }

    public String getRequestTime() {
        return RequestTime;
    }

    public void setRequestTime(String RequestTime) {
        this.RequestTime = RequestTime;
    }
    
        public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

}