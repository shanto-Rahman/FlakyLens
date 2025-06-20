public void testProcess(){
assertEquals(4,parentNode.getRowsList().size());
assertEquals(result[1].get(0).getEvents().iterator().next(),parentNode.getRowsList().get(0)[1]);
}