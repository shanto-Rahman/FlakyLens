@Test public void testPostBody() throws Exception {
latch.await(10,TimeUnit.SECONDS);
Assert.assertEquals(200,statusCode);
if (statusCode == 200) {
Assert.assertNotNull(body);
Assert.assertEquals("<script>alert(\\'test\\')</script>",map.get("key2"));
Assert.assertEquals("<script>alert('test')</script>",map.get("key"));
}
}