@Test public void assertCreateCoordinatorRegistryCenterFromCache() throws ReflectiveOperationException {
assertThat(zkConfig.getNamespace(),is("otherNamespace"));
assertNull(zkConfig.getDigest());
}