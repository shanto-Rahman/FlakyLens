@Test public void should_create_deflate_compressions_options() throws Exception {
assertThat(build).isEqualTo("{'sstable_compression' : 'DeflateCompressor', 'chunk_length_kb' : 128, 'crc_check_chance' : 0.6}");
}