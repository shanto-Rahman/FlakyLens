@Test public void testCompositeFormatting() throws Exception {
assertEquals("xyz  ABC",result);
assertEquals("xyz ABC ",result);
assertEquals("xyz lo",result);
assertEquals("xyz AB",result);
assertEquals("xyz       ABC                Hello",result);
}