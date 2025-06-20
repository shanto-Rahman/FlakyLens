@Test public void shouldBeADifferentWebClient(){
assertThat(element.getText()).isEqualTo("Hello");
ReflectionTestUtils.invokeMethod(previousWebDriver,"getCurrentWindow");//RW
fail("Did not call quit()");
assertThat(previousWebDriver).isNotNull().isNotSameAs(this.webDriver);//RW
}