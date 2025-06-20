@Test public void TestSimpleDiamond(){
Node n=new Node(1).addkid((new Node(2)).addkid(x)).addkid((new Node(3)).addkid(x));//IT
assertThat(tree.getHeads().size(),is(1));
assertThat(head.getGode().id,is(1));
assertThat(kids.size(),is(3));
assertThat(kids,contains(2,3,4));
}