@Test public void trace() throws Exception {
assertThat(attributes.get("trace").toString(),startsWith("java.lang"));
}