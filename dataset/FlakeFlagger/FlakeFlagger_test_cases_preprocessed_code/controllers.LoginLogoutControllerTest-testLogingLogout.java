@Test public void testLogingLogout(){
assertTrue(response.contains("Error. Forbidden."));
assertTrue(response.contains("New article"));
assertTrue(response.contains("Error. Forbidden."));
}