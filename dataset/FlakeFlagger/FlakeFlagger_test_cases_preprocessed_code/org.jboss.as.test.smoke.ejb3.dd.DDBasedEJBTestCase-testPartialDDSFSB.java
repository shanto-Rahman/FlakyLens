/** 
 * Tests that the ejb-jar.xml and annotations are merged correctly for a SFSB, and the bean is invokable through its exposed views
 * @throws Exception
 */
@Test public void testPartialDDSFSB() throws Exception {
Assert.assertEquals("Unexpected return message from bean",msgOne,localBusinessIntfView.echo(msgOne));
Assert.assertEquals("Unexpected return message from no-interface view of bean",msgTwo,noInterfaceView.echo(msgTwo));
}