package me.soomin.client.service;

import me.soomin.client.domain.Account;

import java.util.Map;

public interface AccountService {

    Account register(Account account);

    Account findById(Long id);

    Account registerProductId(Map<String,String> map);
}
