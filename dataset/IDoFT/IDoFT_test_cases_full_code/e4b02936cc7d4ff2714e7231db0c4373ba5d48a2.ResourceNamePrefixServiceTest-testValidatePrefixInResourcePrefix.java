@Test public void testValidatePrefixInResourcePrefix() throws Throwable {
  ResourceNamePrefixState state=createValidResourceNamePrefixState();
  doPost(state,ResourceNamePrefixService.FACTORY_LINK);
  state.prefix=null;
  validateIllegalArgument(state,"prefix must not be null.");
  state.prefix="";
  validateIllegalArgument(state,"prefix must not empty.");
  state.prefix="ABCDEFGH";
  assertTrue(state.prefix.length() > ResourceNamePrefixState.MAX_PREFIX_LENGTH);
  validateIllegalArgument(state,"prefix must less than max.");
}
