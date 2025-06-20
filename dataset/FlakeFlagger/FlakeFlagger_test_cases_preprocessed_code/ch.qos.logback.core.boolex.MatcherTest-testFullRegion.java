public void testFullRegion() throws Exception {
assertTrue(matcher.matches("test"));
assertTrue(matcher.matches("xxxxtest"));
assertTrue(matcher.matches("testxxxx"));
assertTrue(matcher.matches("xxxxtestxxxx"));
}