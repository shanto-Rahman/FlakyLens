@Test @TestDir @TestJetty @TestHdfs public void testCreateSnapshotNoSnapshotName() throws Exception {
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertTrue(Pattern.matches("(\\{\\\"Path\\\"\\:\\\"/tmp/tmp-snap-test/.snapshot/s)" + "(\\d{8})(-)(\\d{6})(\\.)(\\d{3})(\\\"\\})",result));
Assert.assertTrue(Pattern.matches("(.+)(\\\"pathSuffix\\\":\\\"s)" + "(\\d{8})(-)(\\d{6})(\\.)(\\d{3})(\\\")(.+)",result));
}