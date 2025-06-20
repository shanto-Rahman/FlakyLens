@Test public void customBanner(){
  SpringApplication application=spy(new SpringApplication(ExampleConfig.class));
  application.setWebApplicationType(WebApplicationType.NONE);
  this.context=application.run("--spring.banner.location=classpath:test-banner.txt");
  assertThat(this.output.toString()).startsWith("Running a Test!");
}
