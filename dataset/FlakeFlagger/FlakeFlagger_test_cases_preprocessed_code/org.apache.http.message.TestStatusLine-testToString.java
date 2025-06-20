@Test public void testToString() throws Exception {
Assert.assertEquals("HTTP/1.1 200 OK",statusline.toString());
Assert.assertEquals("HTTP/1.1 200 ",statusline.toString());
}