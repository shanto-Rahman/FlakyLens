@Test public void shouldDetectChangeForDifferentGroups(){
assertTrue(victim.isChanged(GROUP1_NAME));
assertTrue(victim.isCheckRequiredForGroup(GROUP2_NAME));
assertTrue(victim.isChanged(GROUP2_NAME));
}