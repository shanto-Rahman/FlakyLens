@Test public void shouldNotDetectChangeAfterFirstRun() throws Exception {
assertFalse(victim.getResourceChangeDetector().checkChangeForGroup(RESOURCE_URI,GROUP_NAME));
}