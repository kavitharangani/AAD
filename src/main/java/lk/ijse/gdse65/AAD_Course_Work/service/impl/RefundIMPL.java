package lk.ijse.gdse65.AAD_Course_Work.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.RefundDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.CustomerEntity;
import lk.ijse.gdse65.AAD_Course_Work.entity.RefundEntity;
import lk.ijse.gdse65.AAD_Course_Work.repo.RefundDAO;
import lk.ijse.gdse65.AAD_Course_Work.service.RefundService;
import lk.ijse.gdse65.AAD_Course_Work.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RefundIMPL implements RefundService {

    private final RefundDAO refundDAO;
    private final Mapping mapping;

    @Override
    public RefundDTO saveRefund(RefundDTO refund) {
        refund.setRefundId(UUID.randomUUID().toString());
        return mapping.toRefundDTO(refundDAO.save(mapping.torRefundEntity(refund)));
    }

    @Override
    public RefundDTO getSelectedRefund(String id) {
        return null;
    }

    @Override
    public boolean deleteRefund(String id) throws NotFoundException {
        Optional<RefundEntity> refund = refundDAO.findById(id);
        if (refund.isPresent()) {
            refundDAO.deleteById(id);
            return true;
        }else{
            throw new NotFoundException(id+" not found (:");
        }
    }

    @Override
    public boolean updateRefund(String id, RefundDTO refundDTO) throws NotFoundException {
        Optional<RefundEntity> optionalRefundEntity = refundDAO.findById(id);
        if (optionalRefundEntity.isPresent()) {
            RefundEntity refundEntity = optionalRefundEntity.get();
            refundEntity.setDescription(refundDTO.getDescription());
            refundEntity.setRefundDate(refundDTO.getRefundDate());
            refundDAO.save(refundEntity);
            return true;
        } else {
            throw new NotFoundException("Refund with ID " + id + " not found.");
        }

}

    @Override
    public List<RefundDTO> getAllRefund() {
        return mapping.toRefundDTOList(refundDAO.findAll());
    }
}
