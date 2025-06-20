@Test public void testForcedLogRotation() throws IOException, InterruptedException {
File logFileName=new File(logDirectory,"server.log");
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Hello",HttpClientUtils.readResponse(result));
Assert.assertEquals("Remote address 127.0.0.1 Code 200 test-header v1\n",FileUtils.readFile(logFileName));
Assert.assertFalse(logFileName.exists());
File firstLogRotate=new File(logDirectory,"server_" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".log");
Assert.assertEquals("Remote address 127.0.0.1 Code 200 test-header v1\n",FileUtils.readFile(firstLogRotate));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Hello",HttpClientUtils.readResponse(result));
Assert.assertEquals("Remote address 127.0.0.1 Code 200 test-header v2\n",FileUtils.readFile(logFileName));
Assert.assertFalse(logFileName.exists());
File secondLogRotate=new File(logDirectory,"server_" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "-1.log");
Assert.assertEquals("Remote address 127.0.0.1 Code 200 test-header v2\n",FileUtils.readFile(secondLogRotate));
}