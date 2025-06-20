@Test public void shouldDetectResourceChange() throws Exception {
Assert.assertEquals(GROUP_NAME,cacheEntry.getGroupName());
flag.set(true);
assertFalse(victim.getResourceChangeDetector().checkChangeForGroup(RESOURCE_URI,GROUP_NAME));
assertTrue(victim.getResourceChangeDetector().checkChangeForGroup(RESOURCE_URI,GROUP_NAME));
assertTrue(flag.get());
}