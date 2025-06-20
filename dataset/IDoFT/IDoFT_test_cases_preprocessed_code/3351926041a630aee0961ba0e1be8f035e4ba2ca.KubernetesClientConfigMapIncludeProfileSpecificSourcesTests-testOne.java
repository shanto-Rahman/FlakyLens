/** 
 * <pre> 'spring.cloud.kubernetes.config.includeProfileSpecificSources=false' 'spring.cloud.kubernetes.config.sources[0].includeProfileSpecificSources=true' 'spring.cloud.kubernetes.config.sources[0].name=config-map-one' We do not define config-map 'config-map-one', but we do define 'config-map-one-dev'. As such: @ConfigurationProperties("one") must be resolved from 'config-map-one-dev' </pre>
 */
@Test public void testOne(){
}