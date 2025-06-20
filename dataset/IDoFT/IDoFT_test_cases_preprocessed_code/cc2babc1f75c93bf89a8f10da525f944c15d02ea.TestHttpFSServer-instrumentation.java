@Test @TestDir @TestJetty @TestHdfs public void instrumentation() throws Exception {
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_UNAUTHORIZED);
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertTrue(line.contains("\"counters\":{"));
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_BAD_REQUEST);
}