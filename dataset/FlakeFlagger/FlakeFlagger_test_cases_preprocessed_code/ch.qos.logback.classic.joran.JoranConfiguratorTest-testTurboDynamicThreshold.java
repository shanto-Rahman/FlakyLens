@Test public void testTurboDynamicThreshold() throws JoranException {
assertEquals(0,listAppender.list.size());
assertEquals(1,listAppender.list.size());
assertEquals("hello user2",le.getMessage());
}