public void test_multimap() throws Exception {
assertTrue(json.equals("{1:[\"a\",\"b\"],2:[\"c\"]}") || json.equals("{1:[\"b\",\"a\"],2:[\"c\"]}"));
}