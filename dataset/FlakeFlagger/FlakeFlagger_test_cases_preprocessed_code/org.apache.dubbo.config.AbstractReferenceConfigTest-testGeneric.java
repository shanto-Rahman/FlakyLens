@Test public void testGeneric() throws Exception {
assertThat(referenceConfig.isGeneric(),is(true));
assertThat(parameters,hasKey("generic"));
}