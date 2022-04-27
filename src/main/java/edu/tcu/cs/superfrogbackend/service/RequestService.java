package edu.tcu.cs.superfrogbackend.service;

import edu.tcu.cs.superfrogbackend.dao.RequestDao;
import edu.tcu.cs.superfrogbackend.domain.Request;
import edu.tcu.cs.superfrogbackend.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RequestService {

    private RequestDao requestDao;
    private IdWorker idWorker;

    // Spring will automatically inject an instance of RequestDao and an instance of IdWorker into this class
    public RequestService(RequestDao requestDao, IdWorker idWorker) {
        this.requestDao = requestDao;
        this.idWorker = idWorker;
    }

    public List<Request> findAll() {
        return requestDao.findAll();
    }

    public Request findById(String requestId) {
        return requestDao.findById(requestId).get();
    }

    public void save(Request newRequest) {
        requestDao.save(newRequest);
    }

    public void update(String requestId, Request updatedRequest) {
        updatedRequest.setId(requestId);
        requestDao.save(updatedRequest);
    }

    public void delete(String requestId) {
        requestDao.deleteById(requestId);
    }
}
