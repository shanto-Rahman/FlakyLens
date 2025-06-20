/** 
 * This is a simple automatic test to ensure log messages are delivered by slf4j in the console.
 */
@Test public void testLogger() throws IOException {
  ByteArrayOutputStream baos=new ByteArrayOutputStream();
  PrintStream ps=new PrintStream(baos,true,"UTF-8");
  PrintStream old=System.err;
  System.setErr(ps);
  XRLog.setLoggerImpl(new Slf4jLogger());
  runWithLogOutput();
  ps.flush();
  String log=baos.toString("UTF-8");
  old.println(log);
  System.setErr(old);
  Assert.assertThat(log,containsString("] [INFO]"));
  Assert.assertThat(log,containsString("] [WARN]"));
}
