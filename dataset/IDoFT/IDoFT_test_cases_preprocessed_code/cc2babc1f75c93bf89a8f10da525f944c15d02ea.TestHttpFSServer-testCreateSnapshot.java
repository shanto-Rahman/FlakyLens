@Test @TestDir @TestJetty @TestHdfs public void testCreateSnapshot() throws Exception {
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertTrue(result.equals("{\"Path\":\"/tmp/tmp-snap-test/.snapshot/snap-with-name\"}"));
Assert.assertTrue(result.contains("snap-with-name"));
}