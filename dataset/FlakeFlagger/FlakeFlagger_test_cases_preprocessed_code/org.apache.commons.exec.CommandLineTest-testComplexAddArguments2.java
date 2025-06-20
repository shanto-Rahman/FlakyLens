/** 
 * Create a command line with pre-quoted strings to test SANDBOX-192, e.g. "runMemorySud.cmd", "10", "30", "-XX:+UseParallelGC", "\"-XX:ParallelGCThreads=2\"" Please not that we re forced to add additional single quotes to get the test working - don't know if this is a bug or a feature.
 */
public void testComplexAddArguments2(){
assertEquals("runMemorySud.cmd 10 30 -XX:+UseParallelGC \"-XX:ParallelGCThreads=2\"",cmdl.toString());
assertEquals(new String[]{"runMemorySud.cmd","10","30","-XX:+UseParallelGC","\"-XX:ParallelGCThreads=2\""},cmdl.toStrings());
}