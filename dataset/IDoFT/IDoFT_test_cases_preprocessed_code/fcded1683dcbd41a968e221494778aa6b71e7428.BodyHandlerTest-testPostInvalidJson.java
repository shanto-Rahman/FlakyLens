@Test public void testPostInvalidJson() throws Exception {
latch.await(10,TimeUnit.SECONDS);
Assert.assertEquals(400,statusCode);
if (statusCode == 400) {
Assert.assertNotNull(status);
Assert.assertEquals("ERR10015",status.getCode());
}
}