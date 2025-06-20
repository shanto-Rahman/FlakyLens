@Test public void testLineLimit() throws Exception {
Assert.assertNotNull(inbuffer1.readLine());
Assert.assertEquals(60,bytesRead);
Assert.fail("IOException should have been thrown");
Assert.assertEquals(20,bytesRead);
}