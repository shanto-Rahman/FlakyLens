@Test public void testServerInfo() throws Exception {
latch.await();
Assert.assertEquals(200,statusCode);
if (statusCode == 200) {
Assert.assertNotNull(body);
}
}