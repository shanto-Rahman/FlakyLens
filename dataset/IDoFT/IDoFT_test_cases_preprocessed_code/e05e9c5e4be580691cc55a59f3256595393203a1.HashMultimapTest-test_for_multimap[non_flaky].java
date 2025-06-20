public void test_for_multimap() throws Exception {
assertTrue(json.equals("{\"name\":[\"a\",\"b\"]}") || json.equals("{\"name\":[\"b\",\"a\"]}"));
}