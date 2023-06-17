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
public class RejectProduct implements Serializable{
    String StockCode, Unit;
    int RejectProductId, Quantity;

    public RejectProduct() {
    }

    
    public RejectProduct(String StockCode, String Unit, int RejectProductId, int Quantity) {
        this.StockCode = StockCode;
        this.Unit = Unit;
        this.RejectProductId = RejectProductId;
        this.Quantity = Quantity;
    }

    public String getStockCode() {
        return StockCode;
    }

    public void setStockCode(String StockCode) {
        this.StockCode = StockCode;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public int getRejectProductId() {
        return RejectProductId;
    }

    public void setRejectProductId(int RejectProductId) {
        this.RejectProductId = RejectProductId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }


    
    
}
