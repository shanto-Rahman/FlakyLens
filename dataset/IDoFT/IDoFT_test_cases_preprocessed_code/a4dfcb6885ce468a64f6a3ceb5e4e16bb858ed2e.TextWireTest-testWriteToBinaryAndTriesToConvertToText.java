@Test public void testWriteToBinaryAndTriesToConvertToText(){
Assert.assertEquals("{map={some={key=value}, some-other={key=value}}}",o.toString());
}