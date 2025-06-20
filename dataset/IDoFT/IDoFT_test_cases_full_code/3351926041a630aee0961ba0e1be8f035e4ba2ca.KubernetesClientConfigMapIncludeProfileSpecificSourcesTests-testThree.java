/** 
 * <pre> 'spring.cloud.kubernetes.config.includeProfileSpecificSources=false' 'spring.cloud.kubernetes.config.sources[2].name=config-map-three' We define config-map 'config-map-three', but we also define 'config-map-three-dev'. This tests proves that data will be read from 'config-map-three' _only_, even if 'config-map-three-dev' also exists. This happens because the 'includeProfileSpecificSources'  property is not defined at the source level, but it is defaulted from the root level, where we set it to false. If this would be incorrect, the value we read from '/profile-specific/three' would have been 'threeDev' and _not_ 'three', simply because 'config-map-three-dev' would override the property value. As such: @ConfigurationProperties("three") must be resolved from 'config-map-three' </pre>
 */
@Test public void testThree(){
  this.webClient.get().uri("/profile-specific/three").exchange().expectStatus().isOk().expectBody(String.class).value(Matchers.equalTo("three"));
}
