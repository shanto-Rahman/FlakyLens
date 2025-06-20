/** 
 * Test getPartitionspecsGroupedByStorageDescriptor() multiple partitions: <ul> <li>Partition with null SD</li> <li>Two partitions under the table location</li> <li>One partition outside of table location</li> </ul>
 */
@Test public void testGetPartitionspecsGroupedBySDonePartitionCombined() throws MetaException {
  String sharedInputFormat="foo1";
  Table tbl=new TableBuilder().setDbName(DB_NAME).setTableName(TABLE_NAME).addCol("id","int").setLocation("/foo").build(null);
  Partition p1=new PartitionBuilder().setDbName("DB_NAME").setTableName(TABLE_NAME).setLocation("/foo/bar").addCol("a1","int").addValue("val1").setInputFormat(sharedInputFormat).build(null);
  Partition p2=new PartitionBuilder().setDbName("DB_NAME").setTableName(TABLE_NAME).setLocation("/a/b").addCol("a2","int").addValue("val2").setInputFormat("foo2").build(null);
  Partition p3=new PartitionBuilder().setDbName("DB_NAME").setTableName(TABLE_NAME).addCol("a3","int").addValue("val3").setInputFormat("foo3").build(null);
  Partition p4=new PartitionBuilder().setDbName("DB_NAME").setTableName("TABLE_NAME").setLocation("/foo/baz").addCol("a1","int").addValue("val4").setInputFormat(sharedInputFormat).build(null);
  p3.unsetSd();
  List<PartitionSpec> result=MetaStoreServerUtils.getPartitionspecsGroupedByStorageDescriptor(tbl,Arrays.asList(p1,p2,p3,p4));
  assertThat(result.size(),is(3));
  PartitionSpec ps1=result.get(0);
  assertThat(ps1.getRootPath(),is((String)null));
  assertThat(ps1.getPartitionList(),is((List<Partition>)null));
  PartitionSpecWithSharedSD partSpec=ps1.getSharedSDPartitionSpec();
  List<PartitionWithoutSD> partitions1=partSpec.getPartitions();
  assertThat(partitions1.size(),is(1));
  PartitionWithoutSD partition1=partitions1.get(0);
  assertThat(partition1.getRelativePath(),is((String)null));
  assertThat(partition1.getValues(),is(Collections.singletonList("val3")));
  PartitionSpec ps2=result.get(1);
  assertThat(ps2.getRootPath(),is(tbl.getSd().getLocation()));
  assertThat(ps2.getPartitionList(),is((List<Partition>)null));
  List<PartitionWithoutSD> partitions2=ps2.getSharedSDPartitionSpec().getPartitions();
  assertThat(partitions2.size(),is(2));
  PartitionWithoutSD partition2_1=partitions2.get(0);
  PartitionWithoutSD partition2_2=partitions2.get(1);
  if (partition2_1.getRelativePath().equals("baz")) {
    PartitionWithoutSD tmp=partition2_1;
    partition2_1=partition2_2;
    partition2_2=tmp;
  }
  assertThat(partition2_1.getRelativePath(),is("/bar"));
  assertThat(partition2_1.getValues(),is(Collections.singletonList("val1")));
  assertThat(partition2_2.getRelativePath(),is("/baz"));
  assertThat(partition2_2.getValues(),is(Collections.singletonList("val4")));
  PartitionSpec ps4=result.get(2);
  assertThat(ps4.getRootPath(),is((String)null));
  assertThat(ps4.getSharedSDPartitionSpec(),is((PartitionSpecWithSharedSD)null));
  List<Partition> partitions=ps4.getPartitionList().getPartitions();
  assertThat(partitions.size(),is(1));
  Partition partition=partitions.get(0);
  assertThat(partition.getSd().getLocation(),is("/a/b"));
  assertThat(partition.getValues(),is(Collections.singletonList("val2")));
}
