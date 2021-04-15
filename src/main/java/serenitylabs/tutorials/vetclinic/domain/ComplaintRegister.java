package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

public class ComplaintRegister {
    private List<String> complaintRegister = new ArrayList<>();
    public List<String> getComplains() {
        return complaintRegister;
    }

    public void recordComplaint(String complaint) {
        complaintRegister.add(complaint);
    }
}
