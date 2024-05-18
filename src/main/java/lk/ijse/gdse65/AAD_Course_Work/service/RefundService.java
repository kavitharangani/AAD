package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.RefundDTO;

import java.util.List;

public interface RefundService {
    RefundDTO saveRefund(RefundDTO refund);
    RefundDTO getSelectedRefund(String id);
    boolean deleteRefund(String id) throws NotFoundException;
    boolean updateRefund(String id,RefundDTO refund)throws NotFoundException;
    List<RefundDTO> getAllRefund();
}
