    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noncormicommon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mkaplan
 */
public class Database extends Config{
 
    private Connection dbConnection = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    public Database() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://"+dbHost+":"
		+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
		
		dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
		
		st = dbConnection.createStatement();
    }
    //Uygun olmayan ürün formu doldurulur.
    public void addNC(NonCon nonCon) throws SQLException{
        String ekle = "INSERT INTO "+Const.NON_CONFORMING   +"("+Const.NC_SDATE                  +"," + Const.NC_NON_CON_PRDCT  +
                        ","+Const.NC_NON_CON_DPRTMN         +","+Const.NC_DETECTIVE_PER          +"," + Const.NC_NON_CON_DETAIL +
                        ","+Const.NC_NON_CON_TYPE           +","+Const.NC_NON_CON_CAUSE          +"," + Const.NC_USERS_USERID   +
                        ","+Const.NC_USERS_USERID1          +","+Const.NC_USERS_USERID2          +"," + Const.NC_USERS_USERID3  +
                        ","+Const.NC_CORRECTIVE_ACTION_CAID +")"+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);
			
		preparedStatement.setString(1, nonCon.getNonConSDate());
		preparedStatement.setString(2, nonCon.getNonConProduct());
                preparedStatement.setString(3, nonCon.getNonConDprtmn());
		preparedStatement.setString(4, nonCon.getDetectivePer());
		preparedStatement.setString(5, nonCon.getNonConDetail());
                preparedStatement.setString(6, nonCon.getNonConType());
                preparedStatement.setString(7, nonCon.getNonConCause());
                preparedStatement.setInt   (8, nonCon.getWriterId());
                preparedStatement.setInt   (9, nonCon.getRequesterId());
                preparedStatement.setInt   (10, nonCon.getChefId());
                preparedStatement.setInt   (11, nonCon.getManagerId());
                preparedStatement.setInt   (12, nonCon.getCorrectiveActId());


			
		preparedStatement.executeUpdate();
    }
    //Uygun olmayan ürün, miktar bilgisi eklemek için kullanılır.
    public void addRP(RejectProduct rejectProduct) throws SQLException {
        
                String ekle = "INSERT INTO "+Const.REJECT_PRODUCT + "("+Const.RPQ_STOCK_CODE+","+Const.RPQ_QUANTITY+","+
                        Const.RPQ_UNIT+","+Const.RPQ_RP_REJECTPRODUCT_ID+")"+"VALUES(?,?,?,?)";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);

                preparedStatement.setString (1, rejectProduct.getStockCode());
                preparedStatement.setInt    (2, rejectProduct.getQuantity());
                preparedStatement.setString (3, rejectProduct.getUnit());
                preparedStatement.setInt    (4, rejectProduct.getRejectProductId());

                preparedStatement.executeUpdate();
        
    }
    //Düzeltici Faaliyet eklemek için kullanılır.
    public void addCorrAct(CorrectiveAction correctiveAction) throws SQLException {
        
                String ekle = "INSERT INTO "+Const.CORRECTIVE_ACTION + "("+Const.CA_CADETAIL+")"+"VALUES(?)";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);

                preparedStatement.setString(1, correctiveAction.getCADetail());


                preparedStatement.executeUpdate();
        
    }
    
   //Şartlı onay talep bilgisi eklemek(güncellemek) için kullanılır.
    public void updateNC_CA( NonCon nonCon) throws SQLException {
         String ekle = "UPDATE "+Const.NON_CONFORMING+" SET "+Const.NC_CON_APPROVAL + "=?," + Const.NC_CON_APPROVAL_DETAIL +"=?," +
				Const.NC_TRAINING_STTS+"=?,"+Const.NC_TRAINING_DETAILS+"=?,"+Const.NC_REQUESTED_CHNGS+"=?,"+
                                Const.NC_REQUEST_TIME+"=?,"+Const.NC_REQUESTER+"=?"+
                                " WHERE "+Const.NC_USERS_USERID1+"=?"+" AND "+
                                Const.NC_NON_CONFOR_ID+"=?";
			
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);
			
		preparedStatement.setInt(1, nonCon.getConApproval());
		preparedStatement.setString(2, nonCon.getConApprovalDetail());
		preparedStatement.setInt(3, nonCon.getTrainingStatus());
		preparedStatement.setString(4, nonCon.getTrainingDetails());
                preparedStatement.setString(5, nonCon.getRequestChngs());
                preparedStatement.setString(6, nonCon.getRequestTime());
                preparedStatement.setInt(7,nonCon.getRequester());
                preparedStatement.setInt(8,nonCon.getRequesterId());
                preparedStatement.setInt(9, nonCon.getNonConId());
                        
			
		preparedStatement.executeUpdate();
    }
    //Ürünün hurda edilmesine onay vermek için kullanılır
        public void updateNC_CA_Scrap( NonCon nonCon) throws SQLException {
         String ekle = "UPDATE "+Const.NON_CONFORMING+" SET "+Const.NC_REQUESTER_SCRAP+"=?"+
                                " WHERE "+Const.NC_USERS_USERID1+"=?"+" AND "+
                                Const.NC_NON_CONFOR_ID+"=?";
			
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);
			
		preparedStatement.setInt(1, nonCon.getRequesterScrap());

                        
			
		preparedStatement.executeUpdate();
    }
    
    
    //Satın almadan gelen şartlı onay talepleri için ön onay vermek için kullanılır
    public void updateNC_PA( NonCon nonCon) throws SQLException {
         String ekle = "UPDATE "+Const.NON_CONFORMING+" SET "+Const.NC_CHEF+"=?"+" WHERE "+Const.NC_USERS_USERID2+"=?"+
                 " AND "+Const.NC_NON_CONFOR_ID+"=?";
			
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);
			
		preparedStatement.setInt(1, nonCon.getChef());
		preparedStatement.setInt(2, nonCon.getChefId());
		preparedStatement.setInt(3, nonCon.getNonConId());

                        
			
		preparedStatement.executeUpdate();
                
                
    }
    //Satın almadan gelen şartlı onay talepleri için ürünün hurda edilmesinde kullanılır.
        public void updateNC_PA_Scrap( NonCon nonCon) throws SQLException {
         String ekle = "UPDATE "+Const.NON_CONFORMING+" SET "+Const.NC_CHEF_SCRAP+"=?"+" WHERE "+Const.NC_USERS_USERID2+"=?"+
                 " AND "+Const.NC_NON_CONFOR_ID+"=?";
			
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);
			
		preparedStatement.setInt(1, nonCon.getChefScrap());
		preparedStatement.setInt(2, nonCon.getChefId());
		preparedStatement.setInt(3, nonCon.getNonConId());

                        
			
		preparedStatement.executeUpdate();
                
                
    }
    //Talep edilen şartlı onayların üretim müdürü tarafından onayı için kullanılır.
    public void updateNC_MA( NonCon nonCon) throws SQLException {
         String ekle = "UPDATE "+Const.NON_CONFORMING+" SET "+Const.NC_MANAGER+"=?,"+Const.NC_FDATE+"=?,"
                 +Const.NC_CORRECTIVE_ACTION_CAID+" WHERE "+Const.NC_NON_CONFOR_ID+"=?";
			
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);
			
		preparedStatement.setInt(1, nonCon.getManager());
                preparedStatement.setString(2, nonCon.getNonConFDate());
                preparedStatement.setInt(3, nonCon.getCorrectiveActId());
		preparedStatement.setInt(4, nonCon.getNonConId());

                        
			
		preparedStatement.executeUpdate();
            
            }
    //Talep edilen şartlı onayların üretim müdürü tarafından hurdaya ayrılmasına karar vermek için kullanılır.
        public void updateNC_MA_Scrap( NonCon nonCon) throws SQLException {
         String ekle = "UPDATE "+Const.NON_CONFORMING+" SET "+Const.NC_MANAGER_SCRAP+"=?,"+
                 " WHERE "+Const.NC_NON_CONFOR_ID+"=?";
			
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);
			
		preparedStatement.setInt(1, nonCon.getManagerScrap());
		preparedStatement.setInt(2, nonCon.getNonConId());

                        
			
		preparedStatement.executeUpdate();
            
            }
   
    
    public void deleteNC(NonCon nonCon) throws SQLException {
         String ekle = "UPDATE "+Const.NON_CONFORMING+" SET "+Const.NC_DELETE+" WHERE "+Const.NC_NON_CONFOR_ID+"=?";
			
		PreparedStatement preparedStatement = dbConnection.prepareStatement(ekle);
			
                preparedStatement.setInt(1, nonCon.getDelete());
                preparedStatement.setInt(2, nonCon.getNonConId());
                        	
		preparedStatement.executeUpdate();
    }
    
        //Kapanmamış tüm şikayetleri göstermek için kullanılır.   
    public ArrayList<NonCon> NCGetTum() throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_NON_CONFOR_ID+","+Const.NC_NON_CON_PRDCT+","+Const.NC_SDATE
                        +","+Const.NC_USERS_USERID1+"," + Const.NC_USERS_USERID2+" FROM "+ Const.NON_CONFORMING;

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();
                    
                    nonCon.setNonConId(rs.getInt(Const.NC_NON_CONFOR_ID));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setRequesterId(rs.getInt(Const.NC_USERS_USERID1));
                    nonCon.setChefId(rs.getInt(Const.NC_USERS_USERID2));
                    
                    
                    uygunsuz.add(nonCon);

                }
                

                return uygunsuz;        
        
        
    }
    
    //Kapanmamış tüm şikayetleri göstermek için kullanılır.   
    public ArrayList<NonCon> NCGet() throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_NON_CONFOR_ID+","+Const.NC_NON_CON_PRDCT+","+Const.NC_SDATE
                        +","+Const.NC_USERS_USERID1+"," + Const.NC_USERS_USERID2+" FROM "+ Const.NON_CONFORMING+
                        " WHERE "+ Const.NC_REQUESTER+"=0"+" OR "+Const.NC_CHEF+"=0"+" OR "+Const.NC_MANAGER+"=0";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();
                    
                    nonCon.setNonConId(rs.getInt(Const.NC_NON_CONFOR_ID));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setRequesterId(rs.getInt(Const.NC_USERS_USERID1));
                    nonCon.setChefId(rs.getInt(Const.NC_USERS_USERID2));
                    
                    
                    uygunsuz.add(nonCon);

                }
                

                return uygunsuz;        
        
        
    }
    //Kapanmamış tüm şikayetleri göstermek için kullanılır. 
    public ArrayList<NonCon> NCGetKapali() throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_NON_CONFOR_ID+","+Const.NC_NON_CON_PRDCT+","+Const.NC_SDATE
                        +","+Const.NC_USERS_USERID1+"," + Const.NC_USERS_USERID2+" FROM "+ Const.NON_CONFORMING+
                        " WHERE "+ Const.NC_REQUESTER+"=1"+" AND "+Const.NC_CHEF+"=1"+" AND "+Const.NC_MANAGER+"=1";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();
                    
                    nonCon.setNonConId(rs.getInt(Const.NC_NON_CONFOR_ID));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setRequesterId(rs.getInt(Const.NC_USERS_USERID1));
                    nonCon.setChefId(rs.getInt(Const.NC_USERS_USERID2));
                    
                    
                    uygunsuz.add(nonCon);

                }

                return uygunsuz;        
        
        
    }
    //Şartlı onay talebi için bekleyen uygun olmayan ürün listesini göstermek için kullanılır. 
        public ArrayList<NonCon> NCCRListGet(int requesterId) throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_NON_CONFOR_ID+","+Const.NC_NON_CON_PRDCT+","+Const.NC_SDATE
                        +"," + Const.NC_USERS_USERID2+" FROM "+ Const.NON_CONFORMING+
                        " WHERE "+ Const.NC_REQUESTER+"=0" + " AND "+Const.NC_USERS_USERID1+"=?";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
                
                preparedStatement.setInt(1,requesterId);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();
                    
                    nonCon.setNonConId(rs.getInt(Const.NC_NON_CONFOR_ID));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setRequesterId(rs.getInt(Const.NC_USERS_USERID2));
                    
                    uygunsuz.add(nonCon);
                }

                return uygunsuz;        
        
        
    }
        
        //Şartlı onay talebi için bekleyen uygun olmayan ürün listesini göstermek için kullanılır. 
        public ArrayList<NonCon> NCCRGet(int nC_ID) throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_SDATE+","+Const.NC_NON_CON_PRDCT+","+Const.NC_NON_CON_DPRTMN+","
                        +Const.NC_DETECTIVE_PER+","+Const.NC_NON_CON_DETAIL+","+ Const.NC_NON_CON_TYPE+","+
                        Const.NC_NON_CON_CAUSE+","+Const.NC_USERS_USERID+","+Const.NC_USERS_USERID1+","+Const.NC_USERS_USERID2+","+
                        Const.NC_USERS_USERID3+" FROM "+ Const.NON_CONFORMING+" WHERE "+Const.NC_NON_CONFOR_ID+"=?";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
                
                preparedStatement.setInt(1,nC_ID);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();
                    
                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setNonConDprtmn(rs.getString(Const.NC_NON_CON_DPRTMN));
                    nonCon.setDetectivePer(rs.getString(Const.NC_DETECTIVE_PER));
                    nonCon.setNonConDetail(rs.getString(Const.NC_NON_CON_DETAIL));
                    nonCon.setNonConType(rs.getString(Const.NC_NON_CON_TYPE));
                    nonCon.setNonConCause(rs.getString(Const.NC_NON_CON_CAUSE));
                    nonCon.setWriterId(rs.getInt(Const.NC_USERS_USERID));
                    nonCon.setRequesterId(rs.getInt(Const.NC_USERS_USERID1));
                    nonCon.setChefId(rs.getInt(Const.NC_USERS_USERID2));
//                  nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    uygunsuz.add(nonCon);

                }

                return uygunsuz;        
        
        
    }
        
                //Şartlı onay talebi için bekleyen uygun olmayan ürün listesini göstermek için kullanılır. 
        public NonCon NCRP_GET() throws SQLException{
                NonCon noncon=null;
                String sorgu = "SELECT "+Const.NC_NON_CONFOR_ID+" FROM "+ Const.NON_CONFORMING+" ORDER BY "+Const.NC_NON_CONFOR_ID+" DESC LIMIT 1";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);


                rs = preparedStatement.executeQuery();

                while(rs.next()){
                noncon = new NonCon();
                
                noncon.setRejectProductId1(rs.getInt(1));    

                }

                return noncon;        
        
        
    }
        
            //Ön Şartlı onay için bekleyen uygun olmayan ürün listesini göstermek için kullanılır. 
        public ArrayList<NonCon> NCPAListGet(int chefId) throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_NON_CONFOR_ID+","+Const.NC_NON_CON_PRDCT+","+Const.NC_SDATE
                        +"," + Const.NC_USERS_USERID2+" FROM "+ Const.NON_CONFORMING+
                        " WHERE "+ Const.NC_REQUESTER+"=1"+ " AND " +Const.NC_CHEF+"=0" + " AND "+Const.NC_USERS_USERID2+"=?";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
                
                preparedStatement.setInt(1,chefId);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();

                    nonCon.setNonConId(rs.getInt(Const.NC_NON_CONFOR_ID));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setChefId(rs.getInt(Const.NC_USERS_USERID2));
//                    nonCon.setNonConDprtmn(rs.getString(Const.NC_NON_CON_DPRTMN));
//                    nonCon.setDetectivePer(rs.getString(Const.NC_DETECTIVE_PER));
//                    nonCon.setNonConDetail(rs.getString(Const.NC_NON_CON_DETAIL));
//                    nonCon.setNonConType(rs.getString(Const.NC_NON_CON_TYPE));
//                    nonCon.setNonConCause(rs.getString(Const.NC_NON_CON_CAUSE));
//                    nonCon.setWriterId(rs.getInt(Const.NC_USERS_USERID));
//                    nonCon.setRequesterId(rs.getInt(Const.NC_USERS_USERID1));
//                    
//                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    
                    uygunsuz.add(nonCon);
                }

                return uygunsuz;        
        
        
    }
        
            //Ön Şartlı onay için bekleyen uygun olmayan ürün listesini göstermek için kullanılır. 
        public ArrayList<NonCon> NCPAGet(int nC_ID) throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_SDATE+","+Const.NC_NON_CON_PRDCT+","+Const.NC_NON_CON_DPRTMN+","
                        +Const.NC_DETECTIVE_PER+","+Const.NC_NON_CON_DETAIL+","+ Const.NC_NON_CON_TYPE+","+
                        Const.NC_NON_CON_CAUSE+","+Const.NC_CON_APPROVAL+","+Const.NC_CON_APPROVAL_DETAIL+
                        ","+Const.NC_TRAINING_STTS+","+Const.NC_TRAINING_DETAILS+
                        ","+Const.NC_REQUESTED_CHNGS+","+Const.NC_REQUEST_TIME+
                        ","+Const.NC_USERS_USERID+","+Const.NC_USERS_USERID1+","+Const.NC_USERS_USERID2+","+
                        Const.NC_USERS_USERID3+" FROM "+ Const.NON_CONFORMING+" WHERE "+Const.NC_NON_CONFOR_ID+"=?";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
                
                preparedStatement.setInt(1,nC_ID);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();
                    
                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setNonConDprtmn(rs.getString(Const.NC_NON_CON_DPRTMN));
                    nonCon.setDetectivePer(rs.getString(Const.NC_DETECTIVE_PER));
                    nonCon.setNonConDetail(rs.getString(Const.NC_NON_CON_DETAIL));
                    nonCon.setNonConType(rs.getString(Const.NC_NON_CON_TYPE));
                    nonCon.setNonConCause(rs.getString(Const.NC_NON_CON_CAUSE));
                    nonCon.setConApproval(rs.getInt(Const.NC_CON_APPROVAL));
                    nonCon.setConApprovalDetail(rs.getString(Const.NC_CON_APPROVAL_DETAIL));
                    nonCon.setTrainingStatus(rs.getInt(Const.NC_TRAINING_STTS));
                    nonCon.setTrainingDetails(rs.getString(Const.NC_TRAINING_DETAILS));
                    nonCon.setRequestChngs(rs.getString(Const.NC_REQUESTED_CHNGS));
                    nonCon.setRequestTime(rs.getString(Const.NC_REQUEST_TIME));
                    
                    nonCon.setWriterId(rs.getInt(Const.NC_USERS_USERID));
                    nonCon.setRequesterId(rs.getInt(Const.NC_USERS_USERID1));
                    nonCon.setChefId(rs.getInt(Const.NC_USERS_USERID2));
//                  nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    uygunsuz.add(nonCon);
                }

                return uygunsuz;        
        
        
    }
        
        //Üretim Müdürü onayı  için bekleyen uygun olmayan ürün listesini göstermek için kullanılır. 
        public ArrayList<NonCon> NCMAListGet(int ma_Id) throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_NON_CONFOR_ID+","+Const.NC_NON_CON_PRDCT+","+Const.NC_SDATE
                        +"," + Const.UT_USER_NAME+" FROM "+ Const.USERS_TABLE +" INNER JOIN "+Const.NON_CONFORMING+
                        " ON "+Const.UT_USER_ID+"="+Const.NC_USERS_USERID2+
                        " WHERE "+ Const.NC_REQUESTER+"=1"+ " AND " +Const.NC_CHEF+ "=1"+" AND "+Const.NC_MANAGER+"=0" 
                        + " AND "+Const.NC_USERS_USERID3+"=?";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
                
                preparedStatement.setInt(1,ma_Id);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();
                    
                    nonCon.setNonConId(rs.getInt(Const.NC_NON_CONFOR_ID));
                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setChefName(rs.getString(Const.UT_USER_NAME));
//                  nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    uygunsuz.add(nonCon);


                }

                return uygunsuz;        
        
        
    }
        
        //Üretim Müdürü onayı için bekleyen uygun olmayan ürün listesini göstermek için kullanılır. 
        public ArrayList<NonCon> NCMAGet(int nC_ID) throws SQLException{
                ArrayList<NonCon> uygunsuz = new ArrayList<NonCon>();
                String sorgu = "SELECT "+Const.NC_SDATE+","+Const.NC_NON_CON_PRDCT+","+Const.NC_NON_CON_DPRTMN+
                        ","+Const.NC_DETECTIVE_PER+","+Const.NC_NON_CON_DETAIL+","+ Const.NC_NON_CON_TYPE+
                        ","+Const.NC_NON_CON_CAUSE+","+Const.NC_CON_APPROVAL+","+Const.NC_CON_APPROVAL_DETAIL+
                        ","+Const.NC_TRAINING_STTS+","+Const.NC_TRAINING_DETAILS+","+Const.NC_REQUESTED_CHNGS+
                        ","+Const.NC_REQUEST_TIME+","+Const.NC_USERS_USERID+","+Const.NC_USERS_USERID1+
                        ","+Const.NC_USERS_USERID2+","+Const.NC_USERS_USERID3+","+Const.NC_CORRECTIVE_ACTION_CAID+
                        " FROM "+ Const.NON_CONFORMING+
                        " WHERE "+Const.NC_NON_CONFOR_ID+"=?";

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
                
                preparedStatement.setInt(1,nC_ID);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    NonCon nonCon = new NonCon();

                    nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    nonCon.setNonConProduct(rs.getString(Const.NC_NON_CON_PRDCT));
                    nonCon.setNonConDprtmn(rs.getString(Const.NC_NON_CON_DPRTMN));
                    nonCon.setDetectivePer(rs.getString(Const.NC_DETECTIVE_PER));
                    nonCon.setNonConDetail(rs.getString(Const.NC_NON_CON_DETAIL));
                    nonCon.setNonConType(rs.getString(Const.NC_NON_CON_TYPE));
                    nonCon.setNonConCause(rs.getString(Const.NC_NON_CON_CAUSE));
                    nonCon.setConApproval(rs.getInt(Const.NC_CON_APPROVAL));
                    nonCon.setConApprovalDetail(rs.getString(Const.NC_CON_APPROVAL_DETAIL));
                    nonCon.setTrainingStatus(rs.getInt(Const.NC_TRAINING_STTS));
                    nonCon.setTrainingDetails(rs.getString(Const.NC_TRAINING_DETAILS));
                    nonCon.setRequestChngs(rs.getString(Const.NC_REQUESTED_CHNGS));
                    nonCon.setRequestTime(rs.getString(Const.NC_REQUEST_TIME));
                    nonCon.setCorrectiveActId(rs.getInt(Const.NC_CORRECTIVE_ACTION_CAID));
                    
                    nonCon.setWriterId(rs.getInt(Const.NC_USERS_USERID));
                    nonCon.setRequesterId(rs.getInt(Const.NC_USERS_USERID1));
                    nonCon.setChefId(rs.getInt(Const.NC_USERS_USERID2));
//                  nonCon.setNonConSDate(rs.getString(Const.NC_SDATE));
                    uygunsuz.add(nonCon);
                }

                return uygunsuz;        
        
        
    }
    
        public ArrayList<RejectProduct> RPGet(int rp_id) throws SQLException{
                ArrayList<RejectProduct> reddedilen = new ArrayList<RejectProduct>();
                String sorgu = "SELECT * FROM "+Const.REJECT_PRODUCT +" WHERE "+ Const.RPQ_RP_REJECTPRODUCT_ID+"=?"; 

                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
                
                preparedStatement.setInt(1,rp_id);

                rs = preparedStatement.executeQuery();

                while(rs.next()){
                    RejectProduct rejectProduct = new RejectProduct();
                    
                    rejectProduct.setStockCode(rs.getString(Const.RPQ_STOCK_CODE));
                    rejectProduct.setQuantity(rs.getInt(Const.RPQ_QUANTITY));
                    rejectProduct.setUnit(rs.getString(Const.RPQ_UNIT));
                    
                    reddedilen.add(rejectProduct);

                }
                return reddedilen;        
    
        }    
        
        public boolean isUserLoggedIn(Users users) throws SQLException{
           
            if(!users.getUserName().equals("")||!users.getPassword().equals("")){
                String sorgu = "SELECT * FROM "+Const.USERS_TABLE + " WHERE " + Const.UT_USER_NAME + "=?"+
                        " AND "+ Const.UT_PASSWORD+"=?";
                
                PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
                preparedStatement.setString(1, users.getUserName());
                preparedStatement.setString(2, users.getPassword());
                        
                
                rs = preparedStatement.executeQuery();
                
                
            
            int counter =0;
            
            while(rs.next()){
                counter ++;
                
            }
            
            if(counter == 1){
                System.out.println("Giriş başarılı");
                return true;
                
            }
            return false;
                        }else {
                System.out.println("Lütfen doğru bilgileri giriniz.");
                return false;
    
}
    
        }    
        public int userGet (String username) throws SQLException{
          int z = 0;
          String sorgu = "SELECT "+Const.UT_USER_ID+" FROM "+Const.USERS_TABLE+" WHERE "+Const.UT_USER_NAME+"=?";
          PreparedStatement preparedStatement = dbConnection.prepareStatement(sorgu);
          preparedStatement.setString(1, username);
          
          rs=preparedStatement.executeQuery();
          
          while(rs.next()){
              Users user = new Users();
              
              z=rs.getInt(Const.UT_USER_ID);
              System.out.println(String.valueOf(z));
              
              
          }
          
            return z;
        }
        
}
