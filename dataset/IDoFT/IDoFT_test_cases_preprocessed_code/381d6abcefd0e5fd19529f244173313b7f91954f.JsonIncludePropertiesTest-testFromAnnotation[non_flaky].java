public void testFromAnnotation(){
assertNotNull(v);
assertEquals(2,v.getIncluded().size());
assertEquals(_set("foo","bar"),included);
assertTrue(test1 || test2);
assertEquals(v,JsonIncludeProperties.Value.from(Bogus.class.getAnnotation(JsonIncludeProperties.class)));
}