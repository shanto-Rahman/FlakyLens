@Test public void testDiscoveryListener() throws Exception {
  Map<String,Endpoint> endpointMap=Maps.newConcurrentMap();
  CountDownLatch joinLatch=new CountDownLatch(1);
  CountDownLatch leaveLatch=new CountDownLatch(1);
  DiscoveryListener discoveryListener=new DiscoveryListener(){
    @Override public void onJoin(    Endpoint endpoint){
      endpointMap.put(endpoint.getAddress(),endpoint);
      joinLatch.countDown();
    }
    @Override public void onLeave(    Endpoint endpoint){
      endpointMap.remove(endpoint.getAddress());
      leaveLatch.countDown();
    }
  }
;
  Discovery discovery=discoveryFactory.create(cluster,discoveryListener);
  Membership membership=membershipFactory.create(cluster);
  membership.join(endpoint);
  joinLatch.await();
  System.out.printf("Got our onJoin call\n");
  membership.leave(endpoint);
  System.out.printf("Left the cluster\n");
  leaveLatch.await();
  System.out.printf("done\n");
}
