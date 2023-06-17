/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noncormicommon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mkaplan
 */
public interface RmiInterface extends Remote{
   
    
    
    public void nC_Ekle(String date, String product, String dprtmnt, String detectivePer, String nCDetail, 
            String nCType,String nCCause, int writerId, int requesterId, int chefId, int corAcId, int manId,
            RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void rP_Ekle(String StockCode, int qntty, String unit, int nc_id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void cA_Ekle(String cADetail)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void nC_CA_Guncelle(int conApp, String conAppDetail, int trainingStts, String trainingDetail, String requestChngs,
            String requestTime, int requester, int reqeuesterId, int nC_Id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void nC_CA_Scrap_Guncelle(int ReqScrapStts, int reqeuesterId, int nC_Id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void nC_PA_Guncelle(int chef, int chefId, int nC_Id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void nC_PA_Scrap_Guncelle(int ChefScrapStts, int chefId, int nC_Id, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void nC_MA_Guncelle( int manager, String fDate, int cAId, int nCId, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void nC_MA_Scrap_Guncelle( int manager, int nCId, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public void nC_Silmek( int delete, int nCId, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public boolean isUserLoggedIn(Users users, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<NonCon> NCGetTum(RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<NonCon> NCGet(RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
      
    public ArrayList<NonCon> NCGetKapali(RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<NonCon> NCCRListGet(int requesterId, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<NonCon> NCCRGet(int nC_ID, RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public NonCon NCRP_GET(RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<NonCon> NCPAListGet(int chefId,RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<NonCon> NCPAGet(int nC_ID,RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<NonCon> NCMAListGet(int ma_Id,RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<NonCon> NCMAGet(int nC_ID,RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public ArrayList<RejectProduct> RPGet(int rp_id,RMICommon common)throws RemoteException, ClassNotFoundException, SQLException;
    
    public int UserGet (String userName, RMICommon common) throws RemoteException, ClassNotFoundException, SQLException;
}
