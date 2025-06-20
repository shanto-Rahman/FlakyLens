@Test public void testTranslat() throws Exception {
assertEquals(StringUtils.translat(s,"123456","abcdef"),"afcad");
assertEquals(StringUtils.translat(s,"123456","abcd"),"acad");
}