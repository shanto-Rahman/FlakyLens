@Test @SuppressWarnings("unchecked") public void testLinkedMap() throws Exception {
Assert.assertEquals("{\"aaa\":\"bbb\"}",json);
Assert.assertEquals("bbb",result.get("aaa"));
}