/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noncormicommon;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mkaplan
 */
public class RMICommon extends UnicastRemoteObject implements RmiInterface{
    NonCon nonCon;
    Users user;
    ResultSet rs;
    	public RMICommon() throws RemoteException {
		super();
	}
    //Uygun olmayan ürün ekler
    public void nC_Ekle(String date, String product, String dprtmnt, String detectivePer, String nCDetail, String nCType,String nCCause, int writerId, int requesterId, int chefId, int manId, int corAcId) throws RemoteException, ClassNotFoundException, SQLException {
       nonCon = new NonCon();
       Database db = new Database();
       nonCon.setNonConSDate(date);
       nonCon.setNonConProduct(product);
       nonCon.setNonConDprtmn(dprtmnt);
       nonCon.setDetectivePer(detectivePer);
       nonCon.setNonConDetail(nCDetail);
       nonCon.setNonConType(nCType);
       nonCon.setNonConCause(nCCause);
       nonCon.setWriterId(writerId);
       nonCon.setRequesterId(requesterId);
       nonCon.setChefId(chefId);
       nonCon.setManagerId(manId);
       nonCon.setCorrectiveActId(corAcId);

       
       db.addNC(nonCon);
    }
    
    
    public void rP_Ekle(String StockCode, int qntty, String unit, int nc_id)throws RemoteException, ClassNotFoundException, SQLException {
        RejectProduct rejectProduct = new RejectProduct();
        Database db = new Database();
        rejectProduct.setStockCode(StockCode);
        rejectProduct.setQuantity(qntty);
        rejectProduct.setUnit(unit);
        rejectProduct.setRejectProductId(nc_id);
        
        db.addRP(rejectProduct);
        
    }
    
    //tüm uygun olmayan ürünlerin listesini çeker
    public ArrayList<NonCon> tum_NC_Cek_Tum() throws ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.NCGetTum();
    }
    
    //açık tüm uygun olmayan ürünlerin listesini çeker
    public ArrayList<NonCon> tum_NC_Cek() throws ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.NCGet();
    }
    //kapanmis tüm uygun olmayan ürünlerin listesini çeker
    public ArrayList<NonCon> tum_NC_Cek_Kapali() throws ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.NCGetKapali();
    }
    //tüm şartlı onay talebi uygun olmayan ürünlerin listesini çeker
    public ArrayList<NonCon> tB_SO_Cek_List(int requesterId) throws ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.NCCRListGet(requesterId);
    }

    //seçilen uygun olmayan ürün bilgilerini forma aktarır
    public ArrayList<NonCon> tB_SO_Cek(int nC_Id)throws RemoteException, ClassNotFoundException, SQLException {
    Database db = new Database();
    return db.NCCRGet(nC_Id);
    }
    
    //tüm ön onay bekleyen şikayetleri listeler
    public ArrayList<NonCon> NCPAListGet(int chefId) throws RemoteException, ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.NCPAListGet(chefId);
    }
    //seçilen uygun olmayan ürün bilgilerini ve seçilen şartlı onay talebini forma aktarır
    public ArrayList<NonCon> NCPAGet(int nC_ID) throws RemoteException, ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.NCPAGet(nC_ID);
    }
    
    //müdürün görmesi gereken şikayetleri listeler
    public ArrayList<NonCon> NCMAListGet(int ma_Id) throws RemoteException, ClassNotFoundException, SQLException{
       Database db = new Database();
        return db.NCMAListGet(ma_Id);
    }

    //müdürün şikayeti çekmesi için kullanılır.
    public ArrayList<NonCon> NCMAGet(int nC_ID) throws RemoteException, ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.NCMAGet(nC_ID);
    }
    

    public void nC_CA_Scrap_Guncelle(int reqScrapStts, int reqeuesterId, int nC_Id)throws RemoteException, ClassNotFoundException, SQLException {
        nonCon = new NonCon();
       Database db = new Database();
       
       nonCon.setRequesterScrap(reqScrapStts);
       nonCon.setRequesterId(reqeuesterId);
       nonCon.setNonConId(nC_Id);
       
       db.updateNC_CA_Scrap(nonCon);
    }
    
    
    public ArrayList<RejectProduct> RPGet(int rp_id) throws RemoteException, ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.RPGet(rp_id);
    }
    
    //şartlı onay talebindeki bilgileri ekler
    public void nC_CA_Guncelle(int conApp, String conAppDetail, int trainingStts, String trainingDetail, String requestChngs, String requestTime, int requester, int reqeuesterId, int nC_Id) throws RemoteException, ClassNotFoundException, SQLException{
         nonCon = new NonCon();
       Database db = new Database();
       
       nonCon.setConApproval(conApp);
       nonCon.setConApprovalDetail(conAppDetail);
       nonCon.setTrainingStatus(trainingStts);
       nonCon.setTrainingDetails(trainingDetail);
       nonCon.setRequestChngs(requestChngs);
       nonCon.setRequestTime(requestTime);
       nonCon.setRequester(requester);
       nonCon.setRequesterId(reqeuesterId);
       nonCon.setNonConId(nC_Id);
    
       db.updateNC_CA(nonCon);
    }
        //Ön onay durumunu günceller
    public void nC_PA_Guncelle(int chef, int chefId, int nC_Id)throws RemoteException, ClassNotFoundException, SQLException {
                nonCon = new NonCon();
       Database db = new Database();
       nonCon.setChef(chef);
       nonCon.setChefId(chefId);
       nonCon.setNonConId(nC_Id);
       
       db.updateNC_PA(nonCon);
    }
    
    
    public void nC_PA_Scrap_Guncelle(int chefScrapStts, int chefId, int nC_Id)throws RemoteException, ClassNotFoundException, SQLException {
        nonCon = new NonCon();
       Database db = new Database();
       nonCon.setChefScrap(chefScrapStts);
       nonCon.setChefId(chefId);
       nonCon.setNonConId(nC_Id);
       
       db.updateNC_PA_Scrap(nonCon);
    }
    
    
    
    
    public void nC_MA_Guncelle(int manager, String fDate, int cAId, int nCId)throws RemoteException, ClassNotFoundException, SQLException {
         nonCon = new NonCon();
       Database db = new Database();
       nonCon.setManager(manager);
       nonCon.setNonConFDate(fDate);
       nonCon.setCorrectiveActId(cAId);
       nonCon.setNonConId(nCId);
       
       db.updateNC_MA(nonCon);
    }

   
    public void nC_MA_Scrap_Guncelle(int managerScrap, int nCId)throws RemoteException, ClassNotFoundException, SQLException {
       nonCon = new NonCon();
       Database db = new Database();
       nonCon.setManagerScrap(managerScrap);
       nonCon.setNonConId(nCId);
       
       db.updateNC_MA(nonCon);
    }
    
    public boolean isUserLoggedIn(Users users) throws RemoteException, ClassNotFoundException, SQLException{
        Database db = new Database();
        return db.isUserLoggedIn(users);
        
    }
    
    
    public NonCon NCRP_GET() throws RemoteException, ClassNotFoundException, SQLException{
       nonCon = new NonCon();
       Database db = new Database();
       
       return db.NCRP_GET();
    }
    
    public int UserGet (String userName) throws RemoteException, ClassNotFoundException, SQLException{
        
        Database db = new Database();
        
        return db.userGet(userName);
    }
    
    
    @Override
    public void nC_Ekle(String date, String product, String dprtmnt, String detectivePer, String nCDetail, String nCType,String nCCause, int writerId, int requesterId, int chefId, int corAcId, int manId, RMICommon common) {
        try {
            nC_Ekle(date, product, dprtmnt, detectivePer, nCDetail, nCType, nCCause, writerId, requesterId, chefId, corAcId,manId);
        } catch (RemoteException ex) {
            Logger.getLogger(RMICommon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RMICommon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RMICommon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rP_Ekle(String StockCode, int qntty, String unit, int nc_id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
        rP_Ekle(StockCode, qntty, unit, nc_id);
    }

    @Override
    public void cA_Ekle(String cADetail)throws RemoteException, ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nC_CA_Guncelle(int conApp, String conAppDetail, int trainingStts, String trainingDetail, String requestChngs, String requestTime, int requester, int reqeuesterId, int nC_Id, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        nC_CA_Guncelle(conApp, conAppDetail, trainingStts, trainingDetail, requestChngs, requestTime, requester, reqeuesterId, nC_Id);
    }

    @Override
    public void nC_CA_Scrap_Guncelle(int ReqScrapStts, int reqeuesterId, int nC_Id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
        nC_CA_Scrap_Guncelle(ReqScrapStts, reqeuesterId, nC_Id);
    }

    @Override
    public void nC_PA_Guncelle(int chef, int chefId, int nC_Id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
        nC_PA_Guncelle(chef, chefId, nC_Id);
    }

    @Override
    public void nC_PA_Scrap_Guncelle(int ChefScrapStts, int chefId, int nC_Id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
        nC_PA_Scrap_Guncelle(ChefScrapStts, chefId, nC_Id);
    }

    @Override
    public void nC_MA_Guncelle(int manager, String fDate, int cAId, int nCId, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
        nC_MA_Guncelle(manager, fDate, cAId, nCId, common);
    }

    @Override
    public void nC_MA_Scrap_Guncelle(int manager, int nCId, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
        nC_MA_Scrap_Guncelle(manager, nCId);
    }

    @Override
    public void nC_Silmek(int delete, int nCId, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCGetTum(RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
       
       return tum_NC_Cek_Tum();
    }
    
    @Override
    public ArrayList<NonCon> NCGet(RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
       
       return tum_NC_Cek();
    }
    
    @Override
    public ArrayList<NonCon> NCGetKapali(RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
       
       return tum_NC_Cek_Kapali();
    }

    @Override
    public ArrayList<NonCon> NCCRListGet(int requesterId, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException {
        return tB_SO_Cek_List(requesterId);
    }

    @Override
    public ArrayList<NonCon> NCCRGet(int nC_ID, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return tB_SO_Cek(nC_ID);
    }

    @Override
    public NonCon NCRP_GET(RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return NCRP_GET();
    }

    @Override
    public ArrayList<NonCon> NCPAListGet(int chefId, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return NCPAListGet(chefId);
    }

    @Override
    public ArrayList<NonCon> NCPAGet(int nC_ID, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return NCPAGet(nC_ID);
    }

    @Override
    public ArrayList<NonCon> NCMAListGet(int ma_Id, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return NCMAListGet(ma_Id);
    }

    @Override
    public ArrayList<NonCon> NCMAGet(int nC_ID, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return  NCMAGet(nC_ID);
    }

    @Override
    public ArrayList<RejectProduct> RPGet(int rp_id, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return RPGet(rp_id);
    }
    @Override
    public boolean isUserLoggedIn(Users users, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return isUserLoggedIn(users);
    }
    
    @Override
    public int UserGet (String userName, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException{
        return UserGet(userName);
    }
}
