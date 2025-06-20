@Test public void customId() throws Exception {
assertThat(this.context.getId(),startsWith("foo"));
}