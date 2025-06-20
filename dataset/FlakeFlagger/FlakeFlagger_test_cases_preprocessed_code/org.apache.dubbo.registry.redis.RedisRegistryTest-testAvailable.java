@Test public void testAvailable(){
assertThat(redisRegistry.isAvailable(),is(true));
assertThat(redisRegistry.isAvailable(),is(false));
}