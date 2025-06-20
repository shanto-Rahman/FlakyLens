@Test public void elect(){
assertSame(node1,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(Arrays.asList(node1,node2,node3,node4)));
assertSame(node1,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(Arrays.asList(node4,node3,node2,node1)));
assertSame(node2,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(Arrays.asList(node2,node3,node4)));
assertSame(node2,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(Arrays.asList(node4,node3,node2)));
assertSame(node3,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(nodes));
assertSame(node4,new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(nodes));
assertNull(new PreferredSingletonElectionPolicy(policy,preference1,preference2).elect(nodes));
}