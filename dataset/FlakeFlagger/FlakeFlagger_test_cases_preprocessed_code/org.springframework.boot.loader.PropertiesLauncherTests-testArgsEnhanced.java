@Test public void testArgsEnhanced() throws Exception {
assertEquals("[foo, bar]",Arrays.asList(launcher.getArgs("bar")).toString());
}