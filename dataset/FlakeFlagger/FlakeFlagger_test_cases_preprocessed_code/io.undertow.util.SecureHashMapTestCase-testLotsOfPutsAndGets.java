@Test public void testLotsOfPutsAndGets(){
Assert.assertEquals(entry.getValue(),map.get(entry.getKey()));
Assert.assertEquals(entry.getValue(),map.remove(entry.getKey()));
Assert.assertEquals(0,map.size());
}