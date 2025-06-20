@Test public void whenInsideABlockInStringModePassesTheAppropriateContextInTheOptionsHashToABlockHelper() throws IOException {
assertEquals("STOP ME FROM READING HACKER NEWS I need-a dad.joke wot",compile("{{#with dale}}{{#tomdale ../need dad.joke}}wot{{/tomdale}}{{/with}}",helpers,true).apply($("dale",$,"need","need-a")));
}