@Test public void testSingleLogMessageToFile() throws IOException, InterruptedException {
File logFileName=new File(directory,"server1.log");
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Hello",HttpClientUtils.readResponse(result));
Assert.assertEquals("Remote address 127.0.0.1 Code 200 test-header single-val\n",FileUtils.readFile(logFileName));
}