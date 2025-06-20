@Test public void testTempUnavailableServlet() throws IOException, InterruptedException {
Assert.assertEquals(StatusCodes.SERVICE_UNAVAILABLE,result.getStatusLine().getStatusCode());
Thread.sleep(1001);
Assert.assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
}