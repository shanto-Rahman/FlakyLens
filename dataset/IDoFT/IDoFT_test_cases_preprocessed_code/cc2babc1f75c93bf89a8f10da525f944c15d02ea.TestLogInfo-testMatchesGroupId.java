@Test public void testMatchesGroupId() throws Exception {
assertTrue(testLogInfo.matchesGroupId(testGroupId));
assertTrue(testLogInfo.matchesGroupId(testGroupId));
assertFalse(testLogInfo.matchesGroupId(testGroupId));
assertFalse(testLogInfo.matchesGroupId(testGroupId));
assertFalse(testLogInfo.matchesGroupId(testGroupId));
assertTrue(testLogInfo.matchesGroupId(testGroupId));
assertTrue(testLogInfo.matchesGroupId(testGroupId));
assertFalse(testLogInfo.matchesGroupId(testGroupId));
}