/** 
 * Covers test case when there is EAR with enabled session sharing
 */
@Test @OperateOnDeployment(EAR_DEPLOYMENT_SHARED_SESSIONS) public void testSharedSessionsOneEar() throws IOException {
assertEquals("0",result);
assertEquals("1",result);
assertEquals("2",result);
assertEquals("3",result);
assertEquals("4",result);
}