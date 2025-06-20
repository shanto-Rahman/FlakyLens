@Test public void testDatasourceSerialization() throws Exception {
if (in != null) {
}
Connection conn=ds.getConnection();
Assert.assertTrue(rs.next());
if (out != null) {
}
}