@Test public void shouldReturnEmptyStringWhenGroupHasNoResources(){
Assert.assertEquals(StringUtils.EMPTY,victim.process(key));
}