/** 
 * Test getPartitionspecsGroupedByStorageDescriptor() multiple partitions: <ul> <li>Partition with null SD</li> <li>Two partitions under the table location</li> <li>One partition outside of table location</li> </ul>
 */
@Test public void testGetPartitionspecsGroupedBySDonePartitionCombined() throws MetaException {
assertThat(result.size(),is(3));
assertThat(ps1.getRootPath(),is((String)null));
assertThat(ps1.getPartitionList(),is((List<Partition>)null));
assertThat(partitions1.size(),is(1));
assertThat(partition1.getRelativePath(),is((String)null));
assertThat(partition1.getValues(),is(Collections.singletonList("val3")));
assertThat(ps2.getRootPath(),is(tbl.getSd().getLocation()));
assertThat(ps2.getPartitionList(),is((List<Partition>)null));
assertThat(partitions2.size(),is(2));
if (partition2_1.getRelativePath().equals("baz")) {
}
assertThat(partition2_1.getRelativePath(),is("/bar"));
assertThat(partition2_1.getValues(),is(Collections.singletonList("val1")));
assertThat(partition2_2.getRelativePath(),is("/baz"));
assertThat(partition2_2.getValues(),is(Collections.singletonList("val4")));
assertThat(ps4.getRootPath(),is((String)null));
assertThat(ps4.getSharedSDPartitionSpec(),is((PartitionSpecWithSharedSD)null));
assertThat(partitions.size(),is(1));
assertThat(partition.getSd().getLocation(),is("/a/b"));
assertThat(partition.getValues(),is(Collections.singletonList("val2")));
}