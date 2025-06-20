@Test public void shouldBeADifferentWebClient(){
  this.webDriver.get("/html");
  WebElement element=this.webDriver.findElement(By.tagName("body"));
  assertThat(element.getText()).isEqualTo("Hello");
  try {
    ReflectionTestUtils.invokeMethod(previousWebDriver,"getCurrentWindow");
    fail("Did not call quit()");
  }
 catch (  NoSuchWindowException ex) {
  }
  assertThat(previousWebDriver).isNotNull().isNotSameAs(this.webDriver);
}
