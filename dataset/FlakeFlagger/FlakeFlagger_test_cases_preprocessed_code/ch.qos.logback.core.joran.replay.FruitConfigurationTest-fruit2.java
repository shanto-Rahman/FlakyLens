@Test public void fruit2() throws Exception {
assertNotNull(fsList);
assertEquals(2,fsList.size());
assertNotNull(fs0);
assertEquals("fs0",fs0.getName());
assertTrue(fruit0 instanceof Fruit);
assertEquals("blue",fruit0.getName());
assertNotNull(fs1);
assertEquals("fs1",fs1.getName());
assertTrue(fruit1 instanceof WeightytFruit);
assertEquals("orange",fruit1.getName());
assertEquals(1.2,((WeightytFruit)fruit1).getWeight(),0.01);
}