@Test @TestDir @TestJetty @TestHdfs public void testRenameSnapshot() throws Exception {
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertTrue(result.contains("snap-renamed"));
Assert.assertFalse(result.contains("snap-to-rename"));
}