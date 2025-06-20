@Test public void testContextInfo() throws SQLException {
assertEquals(map.get(key),rs.getString(3));
assertTrue(map.size() != 0);
assertEquals(map.size(),i);
}