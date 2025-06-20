/** 
 * Covers test case when there is EAR with disabled session sharing
 */
@Test @OperateOnDeployment(EAR_DEPLOYMENT_NOT_SHARED_SESSIONS) public void testNotSharedSessions() throws IOException {
assertEquals("0",result);
assertEquals("1",result);
assertEquals("0",result);
assertEquals("1",result);
assertEquals("2",result);
}