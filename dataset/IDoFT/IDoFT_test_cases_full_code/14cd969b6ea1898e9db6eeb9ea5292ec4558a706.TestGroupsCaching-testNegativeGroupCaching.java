@Test public void testNegativeGroupCaching() throws Exception {
  final String user="negcache";
  final String failMessage="Did not throw IOException: ";
  conf.setLong(CommonConfigurationKeys.HADOOP_SECURITY_GROUPS_NEGATIVE_CACHE_SECS,2);
  FakeTimer timer=new FakeTimer();
  Groups groups=new Groups(conf,timer);
  groups.cacheGroupsAdd(Arrays.asList(myGroups));
  groups.refresh();
  FakeGroupMapping.addToBlackList(user);
  try {
    groups.getGroups(user);
    fail(failMessage + "Failed to obtain groups from FakeGroupMapping.");
  }
 catch (  IOException e) {
    GenericTestUtils.assertExceptionContains("No groups found for user",e);
  }
  try {
    groups.getGroups(user);
    fail(failMessage + "The user is in the negative cache.");
  }
 catch (  IOException e) {
    GenericTestUtils.assertExceptionContains("No groups found for user",e);
  }
  FakeGroupMapping.clearBlackList();
  try {
    groups.getGroups(user);
    fail(failMessage + "The user is still in the negative cache, even " + "FakeGroupMapping has resumed.");
  }
 catch (  IOException e) {
    GenericTestUtils.assertExceptionContains("No groups found for user",e);
  }
  timer.advance(4 * 1000);
  assertEquals(Arrays.asList(myGroups),groups.getGroups(user));
}
