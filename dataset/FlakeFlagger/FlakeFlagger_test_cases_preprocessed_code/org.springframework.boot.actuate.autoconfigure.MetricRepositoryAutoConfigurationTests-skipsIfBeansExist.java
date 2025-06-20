@Test public void skipsIfBeansExist() throws Exception {
assertThat(context.getBeansOfType(DefaultGaugeService.class).size(),equalTo(0));
assertThat(context.getBeansOfType(DefaultCounterService.class).size(),equalTo(0));
}