@Test public void testST_TriangleContouringWithZDoubleRange() throws SQLException {
Statement st=connection.createStatement();//RW
assertEquals(2,rs.getMetaData().getColumnCount());
assertTrue(rs.next());
assertEquals(0,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(1,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(1,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(1,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(2,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(2,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(2,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(2,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(3,rs.getInt("idiso"));
assertTrue(rs.next());
assertEquals(3,rs.getInt("idiso"));
assertFalse(rs.next());
}