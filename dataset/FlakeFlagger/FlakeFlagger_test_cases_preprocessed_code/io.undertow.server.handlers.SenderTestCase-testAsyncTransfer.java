@Test public void testAsyncTransfer() throws Exception {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
File file=new File(SenderTestCase.class.getResource(SenderTestCase.class.getSimpleName() + ".class").toURI());//RO
DataInputStream is=new DataInputStream(new FileInputStream(file));
Assert.assertArrayEquals(data,HttpClientUtils.readRawResponse(result));
}