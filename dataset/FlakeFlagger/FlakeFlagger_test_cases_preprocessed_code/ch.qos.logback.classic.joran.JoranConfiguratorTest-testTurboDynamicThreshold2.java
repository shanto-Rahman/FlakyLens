@Test public void testTurboDynamicThreshold2() throws JoranException {
assertEquals(0,listAppender.list.size());
assertEquals(2,listAppender.list.size());
assertEquals("hello user1",le.getMessage());
assertEquals("hello user2",le.getMessage());
}