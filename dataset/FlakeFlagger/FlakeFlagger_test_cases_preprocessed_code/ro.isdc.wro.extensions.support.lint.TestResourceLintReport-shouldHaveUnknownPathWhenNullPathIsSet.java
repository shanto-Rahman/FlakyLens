@Test public void shouldHaveUnknownPathWhenNullPathIsSet(){
assertEquals(ResourceLintReport.UNKNOWN_PATH,victim.getResourcePath());
}