@Test public void withSubst() throws Exception {
assertNotNull(fsList);
assertEquals(1,fsList.size());
assertNotNull(fs0);
assertEquals("fs0",fs0.getName());
assertTrue(fruit0 instanceof WeightytFruit);
assertEquals("orange-" + oldCount,fruit0.getName());
assertEquals(1.2,((WeightytFruit)fruit0).getWeight(),0.01);
}