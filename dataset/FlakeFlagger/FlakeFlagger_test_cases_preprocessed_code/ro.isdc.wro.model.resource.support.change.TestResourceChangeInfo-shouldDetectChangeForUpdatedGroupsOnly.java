@Test public void shouldDetectChangeForUpdatedGroupsOnly(){
assertTrue(victim.isChanged(GROUP1_NAME));
assertTrue(victim.isChanged(GROUP2_NAME));
assertFalse(victim.isChanged(GROUP1_NAME));
assertFalse(victim.isChanged(GROUP2_NAME));
assertTrue(victim.isChanged(GROUP3_NAME));
}