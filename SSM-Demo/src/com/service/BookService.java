package com.service;

public interface BookService {
	public int findBookPriceByIsbn(String isbn);
	public void BuyBooks(String isbn,String userName);
}
