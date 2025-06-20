/** 
 * This is a simple automatic test to ensure log messages are delivered by slf4j in the console.
 */
@Test public void testLogger() throws IOException {
Assert.assertThat(log,containsString("] [INFO]"));
Assert.assertThat(log,containsString("] [WARN]"));
}