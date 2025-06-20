/** 
 * Test simulating add, remove, retrieve scenarios for blobId tracker on a 2 node cluster.
 * @throws IOException
 */
@Test public void addRetrieveCluster() throws Exception {
adds.addAll(cluster2.doAdd(range(5,9)));//IT
cluster2.forceSnapshot();//IT
adds.addAll(cluster1.doAdd(range(0,4)));//IT
cluster1.forceSnapshot();//IT
Set<String> retrieves=cluster1.doRetrieve();//IT
assertEquals("Retrieves not correct",adds,retrieves);
cluster1.doRemove(adds,range(4,5));//IT
retrieves=cluster1.doRetrieve();//IT
assertEquals("Retrieves not correct after remove",adds,retrieves);
}