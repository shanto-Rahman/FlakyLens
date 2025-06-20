@Test public void shouldBeTheSameWebClient(){
  assertThat(previousWebDriver).isNotNull().isSameAs(this.webDriver);
}
