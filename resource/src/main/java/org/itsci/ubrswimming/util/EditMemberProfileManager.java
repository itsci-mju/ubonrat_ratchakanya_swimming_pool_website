package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.itsci.ubrswimming.model.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditMemberProfileManager {

	public int editProfile(Members emb, String mid) {
      ConnectionDB condb = new ConnectionDB();
      Connection con = condb.getConnection();
      try {
          Statement stmt = con.createStatement();
          String sql = "update Members set  firstname = '"
        		  + emb.getFirstname()
                  + "',lastname='"+ emb.getLastname()
                  + "',address='"+ emb.getAddress()
                  + "',phone='"+ emb.getPhone()
                  + "' where members_id = '" + mid + "'";
          int result = stmt.executeUpdate(sql);
          con.close();
          return result;
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return -1;
  }

}
