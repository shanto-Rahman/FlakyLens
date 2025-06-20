@Test public void shouldNotRequireChangeAfterHashUpdate(){
assertFalse(victim.isCheckRequiredForGroup(GROUP1_NAME));
}