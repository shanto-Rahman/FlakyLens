@Test public void verifyXDiscriminatorValue(){
Assert.assertNotNull(cm);
Assert.assertNotNull(cm.children);
assertEquals(xDiscriminatorValues,excpectedDiscriminatorValues);
assertEquals(cm.discriminator,discriminator);
}