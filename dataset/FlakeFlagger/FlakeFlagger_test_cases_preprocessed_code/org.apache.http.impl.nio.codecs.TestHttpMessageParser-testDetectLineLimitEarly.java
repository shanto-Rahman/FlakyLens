@Test public void testDetectLineLimitEarly() throws Exception {
Assert.assertEquals(2,requestParser.fillBuffer(channel));
Assert.assertNull(requestParser.parse());
Assert.assertEquals(4,requestParser.fillBuffer(channel));
Assert.fail("IOException should have been thrown");
}