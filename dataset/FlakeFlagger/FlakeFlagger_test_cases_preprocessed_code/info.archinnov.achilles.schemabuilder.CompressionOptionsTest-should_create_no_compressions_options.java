@Test public void should_create_no_compressions_options() throws Exception {
assertThat(build).isEqualTo("{'sstable_compression' : ''}");
}