@Test public void whenInsideABlockInStringModePassesTheAppropriateContextInTheOptionsHash() throws IOException {
assertEquals("STOP ME FROM READING HACKER NEWS I need-a dad.joke",compile("{{#with dale}}{{tomdale ../need dad.joke}}{{/with}}",helpers,true).apply($("dale",$,"need","need-a")));
}