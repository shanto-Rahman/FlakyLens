@Test public void assertCreateCoordinatorRegistryCenterWithDigest() throws ReflectiveOperationException {
assertThat(zkConfig.getNamespace(),is("namespace"));
assertThat(zkConfig.getDigest(),is("digest"));
}