@Test public void testMultipartRequestToDefaultServlet() throws Exception {
assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals(MESSAGE,result);
}