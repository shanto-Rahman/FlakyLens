@Test public void whenUsingBlockFormArgumentsToHelpersCanBeRetrievedFromOptionsHashInStringForm() throws IOException {
assertEquals("HELP ME MY BOSS is.a slave.driver: help :(",compile("{{#wycats this is.a slave.driver}}help :({{/wycats}}",helpers,true).apply($));
}