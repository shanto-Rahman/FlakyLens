@Test public void testAllowedMethods() throws IOException {
Assert.assertEquals(405,result.getStatusLine().getStatusCode());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
}