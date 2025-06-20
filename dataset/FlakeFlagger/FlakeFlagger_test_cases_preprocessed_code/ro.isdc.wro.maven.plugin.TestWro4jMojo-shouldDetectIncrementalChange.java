@Test public void shouldDetectIncrementalChange() throws Exception {
assertTrue(victim.getTargetGroupsAsList().isEmpty());
assertFalse(victim.getTargetGroupsAsList().isEmpty());
}