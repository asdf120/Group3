package service.service;

import model.vo.PurchaseBookVO;
import model.vo.PurchaseVO;

import java.util.List;
import java.util.Map;

public interface PurchaseService {
    public String insertPurchase(Map purchaseMap);

    public void insertPurchaseBook(PurchaseBookVO purchaseBookVO);

    public List<String> selectOrderNumber(PurchaseVO purchaseVO);

    public List<PurchaseVO> selectOrderList(PurchaseVO purchaseVO);

    public PurchaseVO purchaseInfo(PurchaseVO purchaseVO);

    public List<PurchaseVO> selectDetailOrder(PurchaseVO purchaseVO);

    public void cancelOrder(PurchaseVO purchaseVO);

    public List<PurchaseBookVO> selectIsbn(PurchaseVO purchaseVO);

    public void cancel_salesData(PurchaseBookVO purchaseBookVO);

}
