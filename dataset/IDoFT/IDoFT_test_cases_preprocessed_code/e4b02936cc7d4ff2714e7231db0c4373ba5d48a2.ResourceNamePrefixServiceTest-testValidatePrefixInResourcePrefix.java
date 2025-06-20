@Test public void testValidatePrefixInResourcePrefix() throws Throwable {
assertTrue(state.prefix.length() > ResourceNamePrefixState.MAX_PREFIX_LENGTH);
}