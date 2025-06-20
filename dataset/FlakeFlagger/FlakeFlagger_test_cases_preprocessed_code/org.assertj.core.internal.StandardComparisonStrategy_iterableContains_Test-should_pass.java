@Test public void should_pass(){
assertTrue(standardComparisonStrategy.iterableContains(list,"Frodo"));
assertTrue(standardComparisonStrategy.iterableContains(list,null));
assertFalse(standardComparisonStrategy.iterableContains(list,"Sauron"));
}