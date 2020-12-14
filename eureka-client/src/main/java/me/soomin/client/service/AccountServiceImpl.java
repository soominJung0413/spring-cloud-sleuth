package me.soomin.client.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.soomin.client.domain.Account;
import me.soomin.client.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    @NonNull
    private AccountRepository accountRepository;

    @Override
    public Account register(Account account) {

        Account savedAccount = accountRepository.save(account);

        return savedAccount;
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> selectedAccount_opt = accountRepository.findById(id);
        return selectedAccount_opt.orElseThrow(() -> new RuntimeException("Not Exist Account"));
    }

    @Override
    public Account registerProductId(Map<String, String> map) {
        Optional<Account> selectedAccount_opt = accountRepository.findById(Long.parseLong(map.get("accountId")));

        Account account = selectedAccount_opt.get();

        if(account.getProductId() == null){
            account.setProductId(Long.parseLong(map.get("id")));
            accountRepository.flush();
        }

        account.setProductId(Long.parseLong(map.get("id")));

        accountRepository.save(account);


        return account;
    }


}
