@Test public void testForUnescapedCharacterInURLisRejected() throws Exception {
Assert.assertTrue(res,res.startsWith("HTTP/1.1 400"));
Assert.assertFalse(res,res.contains("ECHO"));
}