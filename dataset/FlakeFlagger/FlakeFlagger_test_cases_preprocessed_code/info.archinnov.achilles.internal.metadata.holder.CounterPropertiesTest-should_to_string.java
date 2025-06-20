@Test public void should_to_string() throws Exception {
assertThat(props.toString()).isEqualTo("CounterProperties{fqcn=fqcn, idMeta=" + idMeta.toString() + "}");
}