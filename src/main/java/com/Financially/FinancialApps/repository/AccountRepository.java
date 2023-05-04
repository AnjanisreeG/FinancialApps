package com.Financially.FinancialApps.repository;

import com.Financially.FinancialApps.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    @Query(value = "select balance from Account where acctID = ?1")
    public int checkBalance(int acctID);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Account set balance = balance+?2 where acctID=?1")
    public void saveBalanceByAcctID(int acctID, int balance);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Account set balance = balance-?2 where acctID=?1")
    public void withDrawAmountByAcctID(int Id, int balance);

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update Account set balance = balance-?2 where acctID=?1")
//    public void withdrawalTransferringAccount(int Id, int balance);
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update Account set balance = balance-?2 where acctID=?1")
//    public void depositToReceiverAcct(int acctID, int balance);


}
