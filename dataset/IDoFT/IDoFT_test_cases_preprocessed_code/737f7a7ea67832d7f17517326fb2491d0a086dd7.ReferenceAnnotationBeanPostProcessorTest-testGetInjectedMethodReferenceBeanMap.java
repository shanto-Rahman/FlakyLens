@Test public void testGetInjectedMethodReferenceBeanMap(){
Assert.assertEquals(2,referenceBeanMap.size());
Assert.assertEquals("org.apache.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor$ReferenceMethodElement",injectedElement.getClass().getName());
Assert.assertEquals("1.2",referenceBean.getVersion());
Assert.assertEquals("dubbo://127.0.0.1:12345",referenceBean.getUrl());
}