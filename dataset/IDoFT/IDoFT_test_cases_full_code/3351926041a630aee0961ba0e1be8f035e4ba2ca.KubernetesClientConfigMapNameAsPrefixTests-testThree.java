/** 
 * <pre> 'spring.cloud.kubernetes.config.useNameAsPrefix=true' 'spring.cloud.kubernetes.config.sources[2].name=config-map-three' ("property", "three") As such: @ConfigurationProperties(prefix = "config-map-three") </pre>
 */
@Test public void testThree(){
  this.webClient.get().uri("/prefix/three").exchange().expectStatus().isOk().expectBody(String.class).value(Matchers.equalTo("three"));
}
