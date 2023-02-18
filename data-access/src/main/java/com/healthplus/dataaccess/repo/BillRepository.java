package com.healthplus.dataaccess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthplus.dataaccess.domain.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value="Select * From Bill Where patient=?1", nativeQuery=true)
public 	List<Bill> getBillByPatient(Integer id);

}
