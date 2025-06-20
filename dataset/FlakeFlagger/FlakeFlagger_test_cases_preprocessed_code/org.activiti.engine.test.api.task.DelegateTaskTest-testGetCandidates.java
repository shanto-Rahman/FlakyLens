/** 
 * @see  <a href="https://activiti.atlassian.net/browse/ACT-380">https://activiti.atlassian.net/browse/ACT-380</a>
 */
@Deployment public void testGetCandidates(){
assertNotNull(task);
assertEquals(2,candidateUsers.size());
assertTrue(candidateUsers.contains("kermit"));
assertTrue(candidateUsers.contains("gonzo"));
assertEquals(2,candidateGroups.size());
assertTrue(candidateGroups.contains("management"));
assertTrue(candidateGroups.contains("accountancy"));
}