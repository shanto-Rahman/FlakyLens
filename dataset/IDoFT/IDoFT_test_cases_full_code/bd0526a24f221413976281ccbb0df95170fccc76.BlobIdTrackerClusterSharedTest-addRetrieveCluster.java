/** 
 * Test simulating add, remove, retrieve scenarios for blobId tracker on a 2 node cluster.
 * @throws IOException
 */
@Test public void addRetrieveCluster() throws Exception {
  String clusterRepoId=randomUUID().toString();
  cluster1=new Cluster(clusterRepoId,folder.newFolder("cluster1").getAbsolutePath(),folder);
  cluster2=new Cluster(clusterRepoId,folder.newFolder("cluster2").getAbsolutePath(),folder);
  Set<String> adds=newHashSet();
  adds.addAll(cluster2.doAdd(range(5,9)));
  cluster2.forceSnapshot();
  log.info("Done force snapshot for cluster2");
  adds.addAll(cluster1.doAdd(range(0,4)));
  cluster1.forceSnapshot();
  log.info("Done force snapshot for cluster1");
  Set<String> retrieves=cluster1.doRetrieve();
  assertEquals("Retrieves not correct",adds,retrieves);
  log.info("Done retrieve on cluster1");
  cluster1.doRemove(adds,range(4,5));
  log.info("Done remove on cluster1");
  retrieves=cluster1.doRetrieve();
  log.info("Done retrieve on cluster1 again");
  assertEquals("Retrieves not correct after remove",adds,retrieves);
}
