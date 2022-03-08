package com.wm.mvc.productBoard.model.service;

import static com.wm.mvc.common.jdbc.JDBCTemplate.close;
import static com.wm.mvc.common.jdbc.JDBCTemplate.commit;
import static com.wm.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.wm.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.wm.mvc.common.util.PageInfo;
import com.wm.mvc.community.model.dao.CommunityDAO;
import com.wm.mvc.productBoard.model.dao.ProductBoardDAO;
import com.wm.mvc.productBoard.model.vo.BoardReply;
import com.wm.mvc.productBoard.model.vo.ProductBoard;



public class ProductBoardService {

	Connection conn = getConnection();
	PreparedStatement pstmt =null;
	ResultSet rs=null;



	public ProductBoard getBoard(int productNo, boolean hasRead) {
		int result = 0;
		Connection conn = getConnection();
		ProductBoard board = new ProductBoardDAO().findBoardByNo(conn, productNo);
		
		// 게시글 조회수 증가 로직
//		if(board != null && !hasRead) {
//			result = new ProductBoardDAO().updateReadCount(conn, board);
//			
//			if (result > 0) {
//				commit(conn);
//			} else {
//				rollback(conn);
//			}
//		}		
		
		close(conn);	
		
		return board;
	}
	public int saveBoard(ProductBoard product) {
		int result=0;
		Connection conn = getConnection();
		
		//insert와 update 모두 saveboard 사용   // 키 값이 없다고 생각하기
		// insert 부분은 boardNo는 필요없음			// 키 값이 있다고 생각하기
		// update한 부분은  boardNo는 필요함
		
		// boardNo 없는거면 새로 만들고 잇으묜 그냥 덮어쓰기
		if(product.getProductNo() != 0) {
			
			result = new ProductBoardDAO().updateProduct(conn, product);
		}
		else {
		
			result = new ProductBoardDAO().insertProduct(conn, product);
		}
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int deleteProduct(int productNo) {
		getConnection();
		int result = new ProductBoardDAO().updateBoardStatus(conn,productNo,"N");
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int getBoardCount() {
		Connection conn = getConnection();

		int result = new ProductBoardDAO().getBoardCount(conn);

		close(conn);

		return result;	
	}


	public List<ProductBoard> getBoardList(PageInfo info) {
		// TODO Auto-generated method stub
	Connection conn = getConnection();
		
		List<ProductBoard> list = new ProductBoardDAO().findAll(conn, info);
		
		close(conn);		
		
		return list;
	}
	public int saveBoardReply(BoardReply reply) {
		
		int result = 0;
		Connection conn = getConnection();

		result = new ProductBoardDAO().insertBoardReply(conn, reply);			
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;		
	}
	public List<BoardReply> getReplyList(int productNo) {
		Connection conn = getConnection();

		List<BoardReply> replies = new ProductBoardDAO().getReplies(conn, productNo);

		close(conn);		

		return replies;
	}
	public int deleteReply(int productNo, int commentNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		int result = new ProductBoardDAO().updateReplyStatus(conn, productNo, commentNo, "N");
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;
		
	}




	
	
}
