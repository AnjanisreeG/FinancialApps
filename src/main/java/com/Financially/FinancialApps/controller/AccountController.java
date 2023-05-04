package com.Financially.FinancialApps.controller;

import com.Financially.FinancialApps.model.Account;
import com.Financially.FinancialApps.service.AccountService;
import com.Financially.FinancialApps.service.impl.CommonExceptions;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping("/finance")
public class AccountController {

    AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("{Id}")
    public Account getAccountDetails(@PathVariable("Id") Integer Id) throws CommonExceptions {
        return accountService.getAccountDetail(Id);
    }

    @GetMapping
    public List<Account> getAllAccountDetails(){
        return accountService.getAllAccounts();
    }

    @PostMapping
    public String createAccount(@RequestBody Account account){
        accountService.createAccount(account);
        return "Account created";
    }

    @PutMapping("/update")
    public String UpdateAccount(@RequestBody Account account){
        accountService.updateAccount(account);
        return "Account Updated";
    }

    @GetMapping("/check/{acctID}")
    public int checkBalance(@PathVariable int acctID){
        return accountService.checkBalance(acctID);
    }

    @RequestMapping(value = "/depositAmount", method = RequestMethod.PUT)
    @ResponseBody
    public String depositAmount(@RequestParam("Id") Integer Id,@RequestParam("balance") Integer balance){
        accountService.depositAmount(Id,balance);
        return "Deposited Successfully";
    }

    @RequestMapping(value = "/withDrawAmount", method = RequestMethod.PUT)
    @ResponseBody
    public String withDrawAmount(@RequestParam("Id") Integer Id,@RequestParam("balance") Integer balance){
        accountService.withDrawAmount(Id,balance);
        return "Withdraw Successfully";
    }

    @RequestMapping(value = "/fundsTransfer", method = RequestMethod.PUT)
    @ResponseBody
    public String fundsTransfer(@RequestParam("acctID") int acctID, @RequestParam("destAcctID") int destAcctID, @RequestParam("balance") int balance){
        accountService.fundsTransfer(acctID,destAcctID,balance);
        return "Successfully Transferred";
    }
}
