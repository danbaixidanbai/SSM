package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BookMapper;
import com.exception.AccountMoneyException;
import com.exception.BookKuCunException;
import com.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookMapper;
	@Override
	public int findBookPriceByIsbn(String isbn) {
		return bookMapper.findBookPriceByIsbn(isbn);
	}
	@Transactional
	@Override
	public void BuyBooks(String isbn, String userName) {
		int price=bookMapper.findBookPriceByIsbn(isbn);
		System.out.println("书价："+price);
		int money=bookMapper.getMoneyByUserName(userName);
		System.out.println("余额："+money);
		int kucun=bookMapper.getBookKuCunByIsbn(isbn);
		System.out.println("库存："+kucun);
		if(kucun==0) throw new BookKuCunException("库存不足！！！");
		bookMapper.updateBookStock(isbn);
		if(price>money) throw new AccountMoneyException("余额不足！！！");
		bookMapper.updateUserAccount(userName, price);
	}

}
