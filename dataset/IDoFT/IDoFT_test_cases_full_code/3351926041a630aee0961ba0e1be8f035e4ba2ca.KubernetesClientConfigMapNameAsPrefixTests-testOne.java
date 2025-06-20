/** 
 * <pre> 'spring.cloud.kubernetes.config.useNameAsPrefix=true' 'spring.cloud.kubernetes.config.sources[0].useNameAsPrefix=false' ("one.property", "one") As such: @ConfigurationProperties("one") </pre>
 */
@Test public void testOne(){
  this.webClient.get().uri("/prefix/one").exchange().expectStatus().isOk().expectBody(String.class).value(Matchers.equalTo("one"));
}
