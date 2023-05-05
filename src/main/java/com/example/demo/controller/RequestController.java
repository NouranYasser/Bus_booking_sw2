package com.example.demo.controller;
import java.util.List;
import java.util.Map;
import com.example.demo.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Request;
import com.example.demo.enums.RequestStatus;

@RestController
public class RequestController {

    @Autowired
    private RequestService requestService; 

    @PostMapping("/createRequest")
    public ResponseEntity<Request> createStockRequest(@RequestBody Request newRequest) {
        requestService.createRequest(newRequest);
        return new ResponseEntity<Request>(newRequest, HttpStatus.OK);
    }
    @GetMapping("/getAllRequests")
    public List<Request> getAllStockRequests() {
        return requestService.getAllRequests();
    }
    @GetMapping("/getRequestById")
    public Request getRequestById(@RequestParam Integer ID) {
    
    return requestService.getRequestById(ID);
    }
    

    @PutMapping("/updateRequestRequestStatus/{id}")
    public ResponseEntity<String> updaterequestRequestStatus(@PathVariable("id") Integer id,
            @RequestBody Map<String, String> request) {
        String statusString = request.get("status");
        if (statusString == null) {
            return new ResponseEntity<>("Invalid request body", HttpStatus.BAD_REQUEST);
        }
        RequestStatus status = RequestStatus.valueOf(statusString);
        requestService.updateRequestStatus(id, status);
                return new ResponseEntity<>(" Request status is updated!", HttpStatus.OK);
    }

    @DeleteMapping("/deleteRequest")
    public String deleterequestRequest(@RequestParam Integer ID) {
        requestService.deleteRequest(ID);
        return "deleted successfully";
    }

}
