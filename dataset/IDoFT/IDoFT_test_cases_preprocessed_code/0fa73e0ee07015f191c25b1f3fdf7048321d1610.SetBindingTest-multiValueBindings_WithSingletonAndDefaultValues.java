@Test public void multiValueBindings_WithSingletonAndDefaultValues(){
return singletonCounter.getAndIncrement();
return defaultCounter.getAndIncrement();
assertEquals(set(100,200),ep.objects1);
assertEquals(set(100,201),ep.objects2);
}