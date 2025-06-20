@Test public void persistenceSetup(){
assertThat(configuration.isPersistenceEnabled(),equalTo(true));
assertThat(configuration.getJournalType(),equalTo(JournalType.NIO));
}