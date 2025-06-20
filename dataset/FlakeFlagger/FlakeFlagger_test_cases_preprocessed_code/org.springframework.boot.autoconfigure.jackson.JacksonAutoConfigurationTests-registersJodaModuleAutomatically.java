@Test public void registersJodaModuleAutomatically(){
assertThat(objectMapper.canSerialize(LocalDateTime.class),is(true));
}