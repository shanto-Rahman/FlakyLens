@Test public void shouldGetASMVersion(){
  final Version version=getImplementationVersion(ClassUtil.loadClass(ASMDetector.ASM_CLASS_NAME));
  assertThat(version.getVersion(),Matchers.anyOf(startsWith("5."),startsWith("6."),startsWith("7.")));
}
