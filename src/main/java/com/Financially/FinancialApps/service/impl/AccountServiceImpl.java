package com.Financially.FinancialApps.service.impl;

import com.Financially.FinancialApps.model.Account;
import com.Financially.FinancialApps.repository.AccountRepository;
import com.Financially.FinancialApps.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public String createAccount(Account account) {
        accountRepository.save(account);
        return "Success";
    }

    @Override
    public String updateAccount(Account account) {
        accountRepository.save(account);
        return "Update Success";
    }

    @Override
    public Account getAccountDetail(int Id) {
        return accountRepository.findById(Id).get();
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public int checkBalance(int acctID) {
        return accountRepository.checkBalance(acctID);
    }

    @Override
    public void depositAmount(int acctID, int balance) {
        accountRepository.saveBalanceByAcctID(acctID, balance);
    }

    @Override
    public void withDrawAmount(int Id, int balance) {
        accountRepository.withDrawAmountByAcctID(Id, balance);
    }

    @Override
    public void fundsTransfer(int acctID,int destAcctID, int balance) {
        accountRepository.withDrawAmountByAcctID(acctID,balance);
        accountRepository.saveBalanceByAcctID(destAcctID,balance);
    }
}
