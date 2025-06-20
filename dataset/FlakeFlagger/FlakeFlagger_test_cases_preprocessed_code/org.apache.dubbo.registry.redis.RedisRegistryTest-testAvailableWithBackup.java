@Test public void testAvailableWithBackup(){
assertThat(registry.isAvailable(),is(false));
assertThat(registry.isAvailable(),is(true));
}