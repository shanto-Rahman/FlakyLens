@Test public void testBindingWithMapKeyWithPeriod(){
assertEquals("value3",bean.mymap.get("key3"));
assertEquals("value12",bean.mymap.get("key1.key2"));
}