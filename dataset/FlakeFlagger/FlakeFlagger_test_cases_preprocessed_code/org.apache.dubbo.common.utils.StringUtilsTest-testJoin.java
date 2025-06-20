@Test public void testJoin() throws Exception {
assertEquals(StringUtils.join(s),"123");
assertEquals(StringUtils.join(s,','),"1,2,3");
assertEquals(StringUtils.join(s,","),"1,2,3");
}