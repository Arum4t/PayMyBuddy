package com.paymybuddy.webapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
class WalletServiceTest {

    @Mock
    private WalletService walletService;

    @Test
    void getAllWallet() {
        walletService.getAllWallet();
        verify(walletService).getAllWallet();
    }

    @Test
    void getWalletById() {
        walletService.getWalletById(1);
        verify(walletService).getWalletById(1);
    }

    @Test
    void getWalletByPersonId() {
        walletService.getWalletByPersonId(1);
        verify(walletService).getWalletByPersonId(1);
    }

    @Test
    void addMoneyToWallet() {
        walletService.addMoneyToWallet("olivier@test.com",50F);
        verify(walletService).addMoneyToWallet("olivier@test.com",50F);
    }

    @Test
    void removeMoneyToWallet() {
        walletService.removeMoneyToWallet(1,50F);
        verify(walletService).removeMoneyToWallet(1, 50F);
    }

    @Test
    void testAddMoneyToWallet() {
        walletService.addMoneyToWallet(1,50F);
        verify(walletService).addMoneyToWallet(1, 50F);
    }
}