@Test public void testDatasource() throws Exception {
Connection conn=ds.getConnection();
Assert.assertTrue(rs.next());
}