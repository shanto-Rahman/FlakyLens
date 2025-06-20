@Test public void shouldDetectChangeAfterNewHashUpdate(){
assertTrue(victim.isChanged(GROUP1_NAME));
assertTrue(victim.isChanged(GROUP2_NAME));
assertTrue(victim.isChanged(GROUP1_NAME));
assertTrue(victim.isChanged(GROUP1_NAME));
}