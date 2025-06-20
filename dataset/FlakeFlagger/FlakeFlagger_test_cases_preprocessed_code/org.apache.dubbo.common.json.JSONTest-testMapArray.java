@Test @SuppressWarnings("unchecked") public void testMapArray() throws Exception {
Assert.assertEquals("[{\"aaa\":\"bbb\"}]",json);
Assert.assertEquals(1,result.length);
Assert.assertEquals("bbb",((Map<String,String>)result[0]).get("aaa"));
}