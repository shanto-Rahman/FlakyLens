@Test public void shouldNotHaveVerboseInfoLog(){
counter.incrementAndGet();
Assert.assertTrue(counter.get() < times);
}