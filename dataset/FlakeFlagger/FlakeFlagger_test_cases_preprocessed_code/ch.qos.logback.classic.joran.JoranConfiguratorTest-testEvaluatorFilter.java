@Test public void testEvaluatorFilter() throws JoranException {
assertNotNull(listAppender);
assertEquals(1,listAppender.list.size());
assertEquals(Level.WARN,back.getLevel());
assertEquals("hello",back.getMessage());
}