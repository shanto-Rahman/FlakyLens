@Test public void should_collect_all_errors_when_using_extracting(){
softly.assertThat(names).extracting("first").overridingErrorMessage("error 1").contains("gandalf").overridingErrorMessage("error 2").contains("frodo");
softly.assertThat(names).extracting("last").overridingErrorMessage("error 3").isEmpty();
assertThat(e.getErrors()).containsExactly("error 1","error 2","error 3");
}