@Test public void testMatchesGroupId() throws Exception {
  String testGroupId="app1_group1";
  EntityLogInfo testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,"app1_group1",UserGroupInformation.getLoginUser().getUserName());
  assertTrue(testLogInfo.matchesGroupId(testGroupId));
  testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,"test_app1_group1",UserGroupInformation.getLoginUser().getUserName());
  assertTrue(testLogInfo.matchesGroupId(testGroupId));
  testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,"app2_group1",UserGroupInformation.getLoginUser().getUserName());
  assertFalse(testLogInfo.matchesGroupId(testGroupId));
  testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,"app1_group2",UserGroupInformation.getLoginUser().getUserName());
  assertFalse(testLogInfo.matchesGroupId(testGroupId));
  testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,"app1_group12",UserGroupInformation.getLoginUser().getUserName());
  assertFalse(testLogInfo.matchesGroupId(testGroupId));
  testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,"app1_group1_2",UserGroupInformation.getLoginUser().getUserName());
  assertTrue(testLogInfo.matchesGroupId(testGroupId));
  testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,"app1_group1.dat",UserGroupInformation.getLoginUser().getUserName());
  assertTrue(testLogInfo.matchesGroupId(testGroupId));
  testLogInfo=new EntityLogInfo(TEST_ATTEMPT_DIR_NAME,"app2",UserGroupInformation.getLoginUser().getUserName());
  assertFalse(testLogInfo.matchesGroupId(testGroupId));
}
