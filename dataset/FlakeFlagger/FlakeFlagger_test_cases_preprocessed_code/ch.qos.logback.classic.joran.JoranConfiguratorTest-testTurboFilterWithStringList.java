@Test public void testTurboFilterWithStringList() throws JoranException {
assertTrue(filter instanceof DebugUsersTurboFilter);
assertEquals(2,dutf.getUsers().size());
}