@Test public void testNoActivationOnFirstRecord(){
  getActivator().newTagValueSent(getTestKey());
  assertFalse(getTestTag().getAddress().isTimeDeadbandEnabled());
}
