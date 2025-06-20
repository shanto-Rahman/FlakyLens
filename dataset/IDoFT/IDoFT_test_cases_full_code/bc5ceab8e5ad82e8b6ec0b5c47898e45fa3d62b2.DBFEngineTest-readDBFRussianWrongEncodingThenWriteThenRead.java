/** 
 * Read a DBF where the encoding is missing in header. Then write it with a good header. Then check the content.
 * @throws SQLException
 */
@Test public void readDBFRussianWrongEncodingThenWriteThenRead() throws SQLException {
  Statement st=connection.createStatement();
  st.execute("drop table if exists sotchi");
  st.execute("CALL DBFREAD(" + StringUtils.quoteStringSQL(DBFEngineTest.class.getResource("sotchi.dbf").getPath()) + ", 'SOTCHI', 'cp1251');");
  st.execute("CALL DBFWRITE('target/sotchi.dbf', 'SOTCHI', 'cp1251');");
  st.execute("drop table if exists sotchi");
  st.execute("CALL FILE_TABLE('target/sotchi.dbf', 'SOTCHI_GOODHEADER');");
  try (ResultSet rs=st.executeQuery("SELECT * FROM SOTCHI_GOODHEADER")){
    ResultSetMetaData meta=rs.getMetaData();
    assertEquals("B_ДНА",meta.getColumnName(6));
    assertEquals("ИМЕНА_УЧАС",meta.getColumnName(9));
    assertEquals("ДЛИНА_КАНА",meta.getColumnName(10));
    assertEquals("ДЛИНА_КАН_",meta.getColumnName(11));
    assertEquals("ИМЯ_МУООС",meta.getColumnName(12));
    assertTrue(rs.next());
    assertEquals("ВП-2",rs.getString("NAMESHEME"));
    assertEquals("Дубовский канал",rs.getString("NAME10000"));
    assertTrue(rs.next());
    assertEquals("ВП-2-кр1-2",rs.getString("NAMESHEME"));
    assertTrue(rs.next());
    assertEquals("ВП-1",rs.getString("NAMESHEME"));
    assertTrue(rs.next());
    assertEquals("ВП-2-кр1-4",rs.getString("NAMESHEME"));
    assertTrue(rs.next());
    assertEquals("ВП-2-кр1-4-8",rs.getString("NAMESHEME"));
    assertFalse(rs.next());
  }
   st.execute("drop table SOTCHI_GOODHEADER");
}
