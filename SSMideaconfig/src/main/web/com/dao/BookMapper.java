package com.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {
	public int findBookPriceByIsbn(String isbn);
	public void updateBookStock(String isbn);
	public void updateUserAccount(@Param("userName") String userName, @Param("price") int price);
	
	public int getBookKuCunByIsbn(String isbn);
	public int getMoneyByUserName(String userName);
}
