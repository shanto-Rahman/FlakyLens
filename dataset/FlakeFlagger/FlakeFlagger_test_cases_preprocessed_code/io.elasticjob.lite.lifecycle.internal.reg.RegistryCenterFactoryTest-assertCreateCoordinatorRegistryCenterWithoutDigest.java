@Test public void assertCreateCoordinatorRegistryCenterWithoutDigest() throws ReflectiveOperationException {
assertThat(zkConfig.getNamespace(),is("namespace"));
assertNull(zkConfig.getDigest());
}