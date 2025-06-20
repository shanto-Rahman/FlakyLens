@Test public void testRequestExpectContinueGenerated() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals(HTTP.EXPECT_CONTINUE,header.getValue());
}