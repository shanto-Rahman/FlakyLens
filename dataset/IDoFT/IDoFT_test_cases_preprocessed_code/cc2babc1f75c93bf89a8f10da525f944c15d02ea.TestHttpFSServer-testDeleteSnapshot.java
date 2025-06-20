@Test @TestDir @TestJetty @TestHdfs public void testDeleteSnapshot() throws Exception {
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertFalse(result.contains("snap-to-delete"));
}