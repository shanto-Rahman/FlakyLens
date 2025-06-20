@Test public void should_find_accessors() throws Exception {
assertThat(accessors).hasSize(2);
assertThat(accessors[0].getName()).isEqualTo("getComplicatedAttributeName");
assertThat(accessors[1].getName()).isEqualTo("setComplicatedAttributeName");
}