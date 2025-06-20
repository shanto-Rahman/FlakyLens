@Test public void testGetWithoutTid() throws Exception {
latch.await();
Assert.assertEquals(200,statusCode);
Assert.assertNotNull(body);
}