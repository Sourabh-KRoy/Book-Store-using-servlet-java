package test;
import java.sql.*;
public class BookBuyUpdateDAO {
  public int k=0;
  public int buy(BookBean bb,int rqty) {
	  try {
		  Connection con = DBConnection.getCon();
		  PreparedStatement ps = con.prepareStatement
				  ("update BookDetails57 set qty=? where code=?");
		  ps.setInt(1, (bb.getQty()-rqty));
		  ps.setString(2, bb.getCode());
		  k=ps.executeUpdate();
	  }catch(Exception e) {e.printStackTrace();}
	return k;
  }
}
