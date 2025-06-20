@Test public void test1_2() throws Exception {
assertTrue(content.equals("/**/fnUpdateSome({\"name\":\"哈哈哈\",\"id\":123})") || content.equals("/**/fnUpdateSome({\"id\":123,\"name\":\"哈哈哈\"})"));
}