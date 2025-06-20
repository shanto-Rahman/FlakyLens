@Test public void testSingleLogMessageToDatabase() throws IOException, InterruptedException, SQLException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Hello",HttpClientUtils.readResponse(result));
Assert.assertEquals("127.0.0.1",resultDatabase.getString(logHandler.getRemoteHostField()));
Assert.assertEquals("5",resultDatabase.getString(logHandler.getBytesField()));
Assert.assertEquals("200",resultDatabase.getString(logHandler.getStatusField()));
if (statement != null) {
}
if (conn != null) {
}
}