package com.Financially.FinancialApps.service;

import com.Financially.FinancialApps.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public String createAccount(Account account);
    public String updateAccount(Account account);
    public Account getAccountDetail(int Id);
    public List<Account> getAllAccounts();

    public int checkBalance(int acctID);
    public void depositAmount(int Id, int balance);

    public void withDrawAmount(int Id, int balance);

    public void fundsTransfer(int acctID,int destAcctID, int balance);

}
