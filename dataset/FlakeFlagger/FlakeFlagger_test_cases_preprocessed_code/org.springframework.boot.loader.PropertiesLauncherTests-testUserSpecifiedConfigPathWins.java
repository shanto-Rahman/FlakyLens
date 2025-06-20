@Test public void testUserSpecifiedConfigPathWins() throws Exception {
assertEquals("my.BarApplication",launcher.getMainClass());
}