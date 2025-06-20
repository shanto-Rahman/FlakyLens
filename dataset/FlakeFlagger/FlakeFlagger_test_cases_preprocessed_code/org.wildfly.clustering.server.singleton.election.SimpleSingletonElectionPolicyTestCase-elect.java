@Test public void elect(){
assertSame(node1,new SimpleSingletonElectionPolicy().elect(nodes));
assertSame(node1,new SimpleSingletonElectionPolicy(0).elect(nodes));
assertSame(node2,new SimpleSingletonElectionPolicy(1).elect(nodes));
assertSame(node3,new SimpleSingletonElectionPolicy(2).elect(nodes));
assertSame(node1,new SimpleSingletonElectionPolicy(3).elect(nodes));
assertNull(new SimpleSingletonElectionPolicy().elect(Collections.<Node>emptyList()));
}