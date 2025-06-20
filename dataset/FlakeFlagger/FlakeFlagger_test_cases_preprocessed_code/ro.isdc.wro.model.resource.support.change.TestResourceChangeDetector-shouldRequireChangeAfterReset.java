@Test public void shouldRequireChangeAfterReset() throws Exception {
assertFalse(victim.checkChangeForGroup("resource",GROUP1_NAME));
assertTrue(victim.checkChangeForGroup("resource",GROUP2_NAME));
}