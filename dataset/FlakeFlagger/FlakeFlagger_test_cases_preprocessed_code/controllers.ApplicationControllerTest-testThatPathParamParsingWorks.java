@Test public void testThatPathParamParsingWorks(){
assertTrue(response.contains("john@example.com"));
assertTrue(response.contains("12345"));
assertTrue(response.contains("By the way... Reverse url of this rawUrl is: /user/12345/john@example.com/userDashboard"));
}