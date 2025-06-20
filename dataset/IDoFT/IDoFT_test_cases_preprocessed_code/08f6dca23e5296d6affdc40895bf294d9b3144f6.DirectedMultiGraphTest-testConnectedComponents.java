public void testConnectedComponents(){
assertEquals(ccs.size(),4);
assertEquals(CollectionUtils.sorted(ccs.get(0)),Arrays.asList(1,2,3,4));
}