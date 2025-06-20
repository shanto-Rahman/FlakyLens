@Test public void testStickeySessions() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals(expected++,count);
}