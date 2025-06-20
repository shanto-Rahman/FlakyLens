public void test_7() throws Exception {
Assert.assertEquals(new Date(1294552193254L),list.get(0));
Assert.assertEquals("xxx",list.get(1));
Assert.assertEquals(Boolean.TRUE,list.get(2));
Assert.assertEquals(Boolean.FALSE,list.get(3));
Assert.assertEquals(null,list.get(4));
Assert.assertEquals(new JSONObject(),list.get(5));
}