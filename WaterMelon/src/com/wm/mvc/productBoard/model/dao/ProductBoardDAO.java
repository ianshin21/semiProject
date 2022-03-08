package com.wm.mvc.productBoard.model.dao;

import static com.wm.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wm.mvc.common.util.PageInfo;
import com.wm.mvc.productBoard.model.vo.BoardReply;
import com.wm.mvc.productBoard.model.vo.ProductBoard;

public class ProductBoardDAO {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<ProductBoard> findAll(Connection conn, PageInfo info) {
		List<ProductBoard> pList = new ArrayList<>();

		
		
		String query = 
		
		  "SELECT * "
			+ "FROM ("
			+    "SELECT ROWNUM AS RNUM, "
			+           "PRODUCT_NO, "
			+ 			"PRODUCT_NAME, "
			+ 			"MEMBER_ID, "
			+ 			"PRODUCT_PRICE, "
			+ 			"PRODUCT_METHOD, "
			+     		"PRODUCT_STATE,  "
			+     		"PRODUCT_PICTURE_URL, "
			+     		"PRODUCT_TEXT, "
			+     		"VISIT_COUNT, "
			+     		"UPLOAD_DATE, "
			+     		"TRADE_AREA, "
			+     		"LIKE_COUNT, "
			+     		"STATUS  "
			+ 	 "FROM ("
			+ 	    "SELECT P.PRODUCT_NO, "
			+ 			   "P.PRODUCT_NAME, "
			+  			   "M.MEMBER_ID, "
			+  			   "P.PRODUCT_PRICE, "
			+  			   "P.PRODUCT_METHOD, "
			+  			   "P.PRODUCT_STATE, "
			+  			   "P.PRODUCT_PICTURE_URL, "
			+  			   "P.PRODUCT_TEXT, "
			+  			   "P.VISIT_COUNT, "
			+  			   "P.UPLOAD_DATE, "
			+  			   "P.TRADE_AREA, "
			+  			   "P.LIKE_COUNT, "
			+  			   "P.STATUS "
			+ 		"FROM PRODUCT_REGISTRY P "
			+ 		"JOIN MEMBER M ON(P.PRODUCT_WRITER = M.MEMBER_ID) "
			+ 		"WHERE P.STATUS = 'Y'  ORDER BY P.UPLOAD_DATE DESC"
			+ 	 ")"
			+ ") WHERE RNUM BETWEEN ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, info.getStartList()); // 한 페이지의 첫 게시물 본호
			pstmt.setInt(2, info.getEndList()); // 한 페이지의 마지막 게시물 번호
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductBoard prdBoard = new ProductBoard();
				
				prdBoard.setProductNo(rs.getInt("PRODUCT_NO"));
				prdBoard.setProductName(rs.getString("PRODUCT_NAME"));
				prdBoard.setMemberId(rs.getString("MEMBER_ID"));
				prdBoard.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				prdBoard.setProductMethod(rs.getString("PRODUCT_METHOD"));
				prdBoard.setProductState(rs.getString("PRODUCT_STATE"));
				prdBoard.setProductPictureUrl(rs.getString("PRODUCT_PICTURE_URL"));
				prdBoard.setProductText(rs.getString("PRODUCT_TEXT"));
				prdBoard.setVisitCount(rs.getInt("VISIT_COUNT"));
				prdBoard.setUploadDate(rs.getDate("UPLOAD_DATE"));
				prdBoard.setTradeArea(rs.getString("TRADE_AREA"));
				prdBoard.setLikeCount(rs.getInt("LIKE_COUNT"));
				prdBoard.setStatus(rs.getString("TRADE_AREA"));
				
				pList.add(prdBoard);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return pList;
	}
	
	public ProductBoard findBoardByNo(Connection conn, int productNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductBoard board = null;
		String query = 
			  "SELECT  P.PRODUCT_NO, "
			+         "P.PRODUCT_NAME, "
			//+         "M.USER_ID, "
			+         "M.MEMBER_ID, "
			+         "M.PHONE, "
			+         "P.PRODUCT_PRICE, "
			+         "P.PRODUCT_PICTURE_URL, "
			+         "P.PRODUCT_STATE, "
			+         "P.PRODUCT_METHOD, "
			+         "P.TRADE_AREA, "
			+         "P.PRODUCT_TEXT, "
			+         "P.STATUS "
	

			+ "FROM PRODUCT_REGISTRY P "
			+ "JOIN MEMBER M ON(P.PRODUCT_WRITER = M.MEMBER_ID)"
			+ "WHERE P.PRODUCT_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, productNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new ProductBoard();
				
				board.setProductNo(rs.getInt("PRODUCT_NO"));
				board.setProductName(rs.getString("PRODUCT_NAME"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setPhone(rs.getString("PHONE"));
				board.setProductPrice(rs.getInt("PRODUCT_PRICE"));
				board.setProductPictureUrl(rs.getString("PRODUCT_PICTURE_URL"));
				board.setProductText(rs.getString("PRODUCT_TEXT"));
				board.setProductState(rs.getString("PRODUCT_STATE"));
				board.setProductMethod(rs.getString("PRODUCT_METHOD"));
				board.setTradeArea(rs.getString("TRADE_AREA"));
				board.setStatus(rs.getString("STATUS"));
		
				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}		
		
		return board;
	}
	

	
	public int insertProduct(Connection conn, ProductBoard product) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(product);
		try {
			pstmt = conn.prepareStatement(
					"INSERT INTO PRODUCT_REGISTRY VALUES(SEQ_PNO.NEXTVAL,?,?,?,?,?,?,?,DEFAULT,DEFAULT,?,DEFAULT,DEFAULT)");
			
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2,product.getProductWriter());
			pstmt.setInt(3, product.getProductPrice());
			pstmt.setString(4, product.getProductMethod());
			pstmt.setString(5, product.getProductState());
			pstmt.setString(6, product.getProductPictureUrl());
			pstmt.setString(7, product.getProductText());
			
			pstmt.setString(8, product.getTradeArea());
			
	
			result = pstmt.executeUpdate(); //영향 받은 행 리턴 
			System.out.println("insertproduct : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result; //boiardwireteservlet으로 전달 84 saveboard로 감.
	}
	
	public int updateProduct(Connection conn, ProductBoard product) {
		
		int result = 0;
		PreparedStatement pstmt = null; // 시작하는 애 얻어와야
		
		
		try {
	
			pstmt = conn.prepareStatement("UPDATE PRODUCT_REGISTRY SET PRODUCT_NAME=?, PRODUCT_PRICE=?, PRODUCT_METHOD=?, PRODUCT_STATE=?,  PRODUCT_TEXT=? TRADE_AREA=? WHERE PRODUCT_NO=?");
			
			// 쿼리 물음표에 들어갈 값
			pstmt.setString(1, product.getProductName());
	
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setString(3, product.getProductMethod());
			pstmt.setString(4, product.getProductState());

			pstmt.setString(5, product.getProductText());
			
			pstmt.setString(6, product.getTradeArea());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		
		return result;
	}

	public int updateBoardStatus(Connection conn, int productNo, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE PRODUCT_REGISTRY SET STATUS=? WHERE PRODUCT_NO=?");
			
			pstmt.setString(1, status);
			pstmt.setInt(2, productNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}





	public int getBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "SELECT COUNT(*) FROM PRODUCT_REGISTRY ";
	//	String query = "SELECT COUNT(*) FROM BOARD WHERE STATUS = 'Y'";

		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int insertBoardReply(Connection conn, BoardReply reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO COMMENT_LIST VALUES(SEQ_CCNO.NEXTVAL, ?, ?, ?, DEFAULT, SYSDATE)";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, reply.getProductNo());
			pstmt.setInt(2, reply.getCommentWriterNo());
			pstmt.setString(3, reply.getContent());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<BoardReply> getReplies(Connection conn, int productNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardReply> list = new ArrayList();
		String query = 
				  "SELECT COMMENT_NO, "
				+ 	   "PRODUCT_NO, "
				+ 	   "MEMBER_ID, "
				+ 	   "CONTENT, "
				+      "C.STATUS, "
				+      "C.WRITE_TIME "
				+ "FROM COMMENT_LIST C "
				+ "JOIN MEMBER M ON(C.COMMENT_WRITER_NO = M.MEMBER_NO) "
				+ "WHERE C.STATUS='Y' AND PRODUCT_NO = ?	"
				+ "ORDER BY WRITE_TIME DESC";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, productNo);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				BoardReply reply=new BoardReply();

				reply.setCommentNo(rs.getInt("COMMENT_NO"));
				reply.setProductNo(rs.getInt("PRODUCT_NO"));
				reply.setMemberId(rs.getString("MEMBER_ID"));
				reply.setContent(rs.getString("CONTENT"));
				reply.setStatus(rs.getString("STATUS"));
				reply.setWritetime(rs.getDate("WRITE_TIME"));

				list.add(reply);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}

	public int updateReplyStatus(Connection conn, int productNo, int commentNo, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE COMMENT_LIST SET STATUS=? WHERE PRODUCT_NO=? AND COMMENT_NO=?");
			
			pstmt.setString(1,status );
			pstmt.setInt(2, productNo);
			pstmt.setInt(3, commentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		return result;
	}

	

	
}
