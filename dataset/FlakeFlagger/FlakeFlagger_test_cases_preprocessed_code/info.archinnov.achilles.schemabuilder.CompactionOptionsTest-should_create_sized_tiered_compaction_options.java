@Test public void should_create_sized_tiered_compaction_options() throws Exception {
assertThat(build).isEqualTo("{'class' : 'SizeTieredCompactionStrategy', 'enabled' : true, 'max_threshold' : 4, 'tombstone_compaction_interval' : 3, 'tombstone_threshold' : 0.7, 'bucket_high' : 1.2, 'bucket_low' : 0.5, 'cold_reads_to_omit' : 0.89, 'min_threshold' : 2, 'min_sstable_size' : 5000000}");
}