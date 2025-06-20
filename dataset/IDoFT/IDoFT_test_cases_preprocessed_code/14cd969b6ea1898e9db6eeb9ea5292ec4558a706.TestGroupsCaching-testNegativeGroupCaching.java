@Test public void testNegativeGroupCaching() throws Exception {
groups.cacheGroupsAdd(Arrays.asList(myGroups));//RW
FakeGroupMapping.addToBlackList(user);//IT
fail(failMessage + "Failed to obtain groups from FakeGroupMapping.");
fail(failMessage + "The user is in the negative cache.");
FakeGroupMapping.clearBlackList();//IT
fail(failMessage + "The user is still in the negative cache, even " + "FakeGroupMapping has resumed.");
assertEquals(Arrays.asList(myGroups),groups.getGroups(user));//RW
}