/** 
 * Test on    {@link ReferenceAnnotationBeanPostProcessor#getReferenceBeans()}
 */
@Test public void testGetReferenceBeans(){
Assert.assertEquals(1,referenceBeans.size());
Assert.assertEquals(referenceBean.get(),testBean.getDemoServiceFromAncestor());
Assert.assertEquals(referenceBean.get(),testBean.getDemoServiceFromParent());
Assert.assertEquals(referenceBean.get(),testBean.getDemoService());
}