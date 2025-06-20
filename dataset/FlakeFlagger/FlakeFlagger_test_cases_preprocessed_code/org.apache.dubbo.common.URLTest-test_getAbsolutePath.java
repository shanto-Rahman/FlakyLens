@Test public void test_getAbsolutePath() throws Exception {
assertEquals(null,url.getAbsolutePath());
assertEquals("/home/user1/route.js",url.getAbsolutePath());
}