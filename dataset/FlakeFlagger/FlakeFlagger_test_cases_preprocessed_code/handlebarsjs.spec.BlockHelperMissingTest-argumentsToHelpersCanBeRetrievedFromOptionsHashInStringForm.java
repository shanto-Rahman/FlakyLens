@Test public void argumentsToHelpersCanBeRetrievedFromOptionsHashInStringForm() throws IOException {
assertEquals("HELP ME MY BOSS is.a slave.driver",compile("{{wycats this is.a slave.driver}}",helpers,true).apply($));
}