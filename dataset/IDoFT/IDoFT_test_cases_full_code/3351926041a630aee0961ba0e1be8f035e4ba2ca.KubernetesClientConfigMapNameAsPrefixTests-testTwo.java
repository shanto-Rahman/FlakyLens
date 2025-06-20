/** 
 * <pre> 'spring.cloud.kubernetes.config.useNameAsPrefix=true' 'spring.cloud.kubernetes.config.sources[1].explicitPrefix=two' ("property", "two") As such: @ConfigurationProperties("two") </pre>
 */
@Test public void testTwo(){
  this.webClient.get().uri("/prefix/two").exchange().expectStatus().isOk().expectBody(String.class).value(Matchers.equalTo("two"));
}
