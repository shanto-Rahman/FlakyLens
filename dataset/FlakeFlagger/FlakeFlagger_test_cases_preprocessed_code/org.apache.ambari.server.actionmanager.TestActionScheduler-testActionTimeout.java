/** 
 * Test whether scheduler times out an action
 */
@Test public void testActionTimeout() throws Exception {
Thread.sleep(100);
assertEquals(stages.get(0).getHostRoleStatus(hostname,"NAMENODE"),HostRoleStatus.TIMEDOUT);
}