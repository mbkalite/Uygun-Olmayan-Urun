/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noncormicommon;

/**
 *
 * @author mkaplan
 */
public class CorrectiveAction {
    int CaId;
    String CADetail;

    public CorrectiveAction() {
    }

    public CorrectiveAction(int CaId, String CADetail) {
        this.CaId = CaId;
        this.CADetail = CADetail;
    }

    public int getCaId() {
        return CaId;
    }

    public void setCaId(int CaId) {
        this.CaId = CaId;
    }

    public String getCADetail() {
        return CADetail;
    }

    public void setCADetail(String CADetail) {
        this.CADetail = CADetail;
    }


    
    
}
