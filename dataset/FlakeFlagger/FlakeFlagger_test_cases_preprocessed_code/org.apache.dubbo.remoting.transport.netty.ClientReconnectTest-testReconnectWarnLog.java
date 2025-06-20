/** 
 * Reconnect log check, when the time is not enough for shutdown time, there is no error log, but there must be a warn log
 */
@Test public void testReconnectWarnLog() throws RemotingException, InterruptedException {
Thread.sleep(1500);
Assert.assertEquals("no error message ",0,LogUtil.findMessage(Level.ERROR,"client reconnect to "));
Assert.assertEquals("must have one warn message ",1,LogUtil.findMessage(Level.WARN,"client reconnect to "));
}