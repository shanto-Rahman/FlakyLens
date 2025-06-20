@Test public void shouldDetectIncrementalChangeOfImportedCss() throws Exception {
assertTrue(victim.getTargetGroupsAsList().isEmpty());
assertFalse(victim.getTargetGroupsAsList().isEmpty());
}