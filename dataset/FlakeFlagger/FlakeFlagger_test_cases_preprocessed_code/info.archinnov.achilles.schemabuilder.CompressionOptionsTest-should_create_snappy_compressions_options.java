@Test public void should_create_snappy_compressions_options() throws Exception {
assertThat(build).isEqualTo("{'sstable_compression' : 'SnappyCompressor', 'chunk_length_kb' : 128, 'crc_check_chance' : 0.6}");
}