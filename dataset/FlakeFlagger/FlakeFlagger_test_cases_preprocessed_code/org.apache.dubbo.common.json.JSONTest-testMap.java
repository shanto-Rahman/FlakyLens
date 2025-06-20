@Test @SuppressWarnings("unchecked") public void testMap() throws Exception {
Assert.assertEquals("{\"aaa\":\"bbb\"}",json);
Assert.assertEquals("bbb",result.get("aaa"));
}