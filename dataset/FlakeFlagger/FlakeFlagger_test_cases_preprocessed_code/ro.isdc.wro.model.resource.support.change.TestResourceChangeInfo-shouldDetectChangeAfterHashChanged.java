@Test public void shouldDetectChangeAfterHashChanged(){
assertTrue(victim.isChanged(GROUP1_NAME));
assertTrue(victim.isCheckRequiredForGroup(GROUP1_NAME));
assertTrue(victim.isChanged(GROUP1_NAME));
assertTrue(victim.isChanged(GROUP1_NAME));
assertTrue(victim.isChanged(GROUP2_NAME));
}