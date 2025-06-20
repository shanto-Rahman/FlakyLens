@Test public void enableBannerInLogViaProperty(){
  SpringApplication application=spy(new SpringApplication(ExampleConfig.class));
  application.setWebApplicationType(WebApplicationType.NONE);
  this.context=application.run("--spring.main.banner-mode=log");
  verify(application,atLeastOnce()).setBannerMode(Banner.Mode.LOG);
  assertThat(this.output.toString()).contains("o.s.b.SpringApplication");
}
