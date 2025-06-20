@Test public void shouldBeSameWhenContainingIdenticalAttributes(){
assertEquals(key1,key2);
assertEquals(key1.hashCode(),key2.hashCode());
}