/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonconserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import noncormicommon.NonCon;
import noncormicommon.RMICommon;
import noncormicommon.RejectProduct;
import noncormicommon.RmiInterface;
import noncormicommon.Users;

/**
 *
 * @author mkaplan
 */
public class NonConServer implements RmiInterface{


    public static void main(String[] args) throws RemoteException {
                Registry server = LocateRegistry.createRegistry(1098);
		RMICommon common = new RMICommon();
		server.rebind("SartliOnay1", common);
		System.out.println("Server is ready");
    }

    @Override
    public void nC_Ekle(String date, String product, String dprtmnt, String detectivePer, String nCDetail, String nCType, String nCCause, int writerId, int requesterId, int chefId, int corAcId, int manId, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException {
        System.out.println("Çalıştı");
        common.nC_Ekle(date, product, dprtmnt, detectivePer, nCDetail, nCType, nCCause, writerId, requesterId, chefId, corAcId, manId);
    }

    @Override
    public void rP_Ekle(String StockCode, int qntty, String unit, int nc_id,RMICommon common) throws RemoteException, ClassNotFoundException, SQLException {
        System.out.println("hatali ürün eklendi");
        common.rP_Ekle(StockCode, qntty, unit, nc_id);
    }

    @Override
    public void cA_Ekle(String cADetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nC_CA_Guncelle(int conApp, String conAppDetail, int trainingStts, String trainingDetail, String requestChngs, String requestTime, int requester, int reqeuesterId, int nC_Id, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nC_CA_Scrap_Guncelle(int ReqScrapStts, int reqeuesterId, int nC_Id, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nC_PA_Guncelle(int chef, int chefId, int nC_Id, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nC_PA_Scrap_Guncelle(int ChefScrapStts, int chefId, int nC_Id, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nC_MA_Guncelle(int manager, String fDate, int cAId, int nCId, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nC_MA_Scrap_Guncelle(int manager, int nCId, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nC_Silmek(int delete, int nCId, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCGet(RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCCRListGet(int requesterId, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCCRGet(int nC_ID, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NonCon NCRP_GET(RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCPAListGet(int chefId, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCPAGet(int nC_ID, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCMAListGet(int ma_Id, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCMAGet(int nC_ID, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RejectProduct> RPGet(int rp_id, RMICommon common) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUserLoggedIn(Users users, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UserGet(String userName, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCGetKapali(RMICommon common) throws RemoteException, ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NonCon> NCGetTum(RMICommon common) throws RemoteException, ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
