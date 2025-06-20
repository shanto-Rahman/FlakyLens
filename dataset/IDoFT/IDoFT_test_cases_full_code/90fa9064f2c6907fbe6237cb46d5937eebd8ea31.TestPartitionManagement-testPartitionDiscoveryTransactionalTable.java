@Test public void testPartitionDiscoveryTransactionalTable() throws TException, IOException, InterruptedException, ExecutionException {
  String dbName="db6";
  String tableName="tbl6";
  Map<String,Column> colMap=buildAllColumns();
  List<String> partKeys=Lists.newArrayList("state","dt");
  List<String> partKeyTypes=Lists.newArrayList("string","date");
  List<List<String>> partVals=Lists.newArrayList(Lists.newArrayList("__HIVE_DEFAULT_PARTITION__","1990-01-01"),Lists.newArrayList("CA","1986-04-28"),Lists.newArrayList("MN","2018-11-31"));
  createMetadata(DEFAULT_CATALOG_NAME,dbName,tableName,partKeys,partKeyTypes,partVals,colMap,true);
  Table table=client.getTable(dbName,tableName);
  List<Partition> partitions=client.listPartitions(dbName,tableName,(short)-1);
  assertEquals(3,partitions.size());
  String tableLocation=table.getSd().getLocation();
  URI location=URI.create(tableLocation);
  Path tablePath=new Path(location);
  FileSystem fs=FileSystem.get(location,conf);
  Path newPart1=new Path(tablePath,"state=WA/dt=2018-12-01");
  Path newPart2=new Path(tablePath,"state=UT/dt=2018-12-02");
  fs.mkdirs(newPart1);
  fs.mkdirs(newPart2);
  assertEquals(5,fs.listStatus(tablePath).length);
  table.getParameters().put(PartitionManagementTask.DISCOVER_PARTITIONS_TBLPROPERTY,"true");
  table.getParameters().put(hive_metastoreConstants.TABLE_IS_TRANSACTIONAL,"true");
  table.getParameters().put(hive_metastoreConstants.TABLE_TRANSACTIONAL_PROPERTIES,TransactionalValidationListener.INSERTONLY_TRANSACTIONAL_PROPERTY);
  client.alter_table(dbName,tableName,table);
  runPartitionManagementTask(conf);
  partitions=client.listPartitions(dbName,tableName,(short)-1);
  assertEquals(5,partitions.size());
  assertEquals(0,PartitionManagementTask.getSkippedAttempts());
  boolean deleted=fs.delete(newPart1.getParent(),true);
  assertTrue(deleted);
  assertEquals(4,fs.listStatus(tablePath).length);
  PartitionManagementTask partitionDiscoveryTask1=new PartitionManagementTask();
  partitionDiscoveryTask1.setConf(conf);
  PartitionManagementTask partitionDiscoveryTask2=new PartitionManagementTask();
  partitionDiscoveryTask2.setConf(conf);
  PartitionManagementTask partitionDiscoveryTask3=new PartitionManagementTask();
  partitionDiscoveryTask3.setConf(conf);
  List<PartitionManagementTask> tasks=Lists.newArrayList(partitionDiscoveryTask1,partitionDiscoveryTask2,partitionDiscoveryTask3);
  ExecutorService executorService=Executors.newFixedThreadPool(3);
  int successBefore=PartitionManagementTask.getCompletedAttempts();
  int skippedBefore=PartitionManagementTask.getSkippedAttempts();
  List<Future<?>> futures=new ArrayList<>();
  for (  PartitionManagementTask task : tasks) {
    futures.add(executorService.submit(task));
  }
  for (  Future<?> future : futures) {
    future.get();
  }
  int successAfter=PartitionManagementTask.getCompletedAttempts();
  int skippedAfter=PartitionManagementTask.getSkippedAttempts();
  assertEquals(1,successAfter - successBefore);
  assertEquals(2,skippedAfter - skippedBefore);
  partitions=client.listPartitions(dbName,tableName,(short)-1);
  assertEquals(4,partitions.size());
}
