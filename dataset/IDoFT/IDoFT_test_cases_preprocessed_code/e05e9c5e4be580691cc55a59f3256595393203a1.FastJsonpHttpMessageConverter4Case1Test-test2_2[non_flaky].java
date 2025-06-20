@Test public void test2_2() throws Exception {
assertTrue(content.equals("/**/fnUpdateSome({\"p1\":1,\"p2\":2})") || content.equals("/**/fnUpdateSome({\"p2\":2,\"p1\":1})"));
}