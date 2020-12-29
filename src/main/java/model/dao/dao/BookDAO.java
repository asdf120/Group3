package model.dao.dao;

import model.vo.BookVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BookDAO {

    void insertBook(BookVO vo);

    //public void modifyBook(BookVO vo) ;

     void deleteBook(BookVO vo);

     void updateBook(BookVO vo);

    BookVO selectBook(BookVO vo);

     List<BookVO> bookList(BookVO  vo) ;


    List<BookVO> genrebookList(String genre) ;
    List<BookVO> searchBook(Map map);

    List<Map<String, Object>> getGenreSalesList();
    HashMap<Integer,Integer> salesList();

     List carouselBook();
     List<BookVO> bestBook();
     List<BookVO> hotBook(String genre);
 HashMap<Integer,Integer> ageList();
 HashMap<Integer,Integer> twentypriceList();
 HashMap<Integer, Integer> teenageList(String age);
 HashMap<Integer, Integer> daychart();

 //베스트 도서 리스트
 List<BookVO> bestbookList();

 //출간순서 도서 리스트
    List<BookVO> newbookList();

    //동적 책 장르별 탭
    List<BookVO> bookTab();
}
