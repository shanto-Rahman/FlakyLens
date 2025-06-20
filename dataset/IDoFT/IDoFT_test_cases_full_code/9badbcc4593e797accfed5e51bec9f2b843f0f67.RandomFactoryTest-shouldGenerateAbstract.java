@Test public void shouldGenerateAbstract(){
  com.openpojo.random.sampleclasses.AnAbstractClass anAbstractClass=RandomFactory.getRandomValue(com.openpojo.random.sampleclasses.AnAbstractClass.class);
  Assert.assertNotNull(anAbstractClass);
}
