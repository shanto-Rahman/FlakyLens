@Test public void testGetManyResources() throws Exception {
Assert.assertEquals(3,propertyProvider.populateResources(resources,request,null).size());
Assert.assertEquals("http://ec2-23-23-71-42.compute-1.amazonaws.com/cgi-bin/rrd.py?c=HDPSlaves&h=domU-12-31-39-0E-34-E3.compute-1.internal,domU-12-31-39-0E-34-E1.compute-1.internal,domU-12-31-39-0E-34-E2.compute-1.internal&m=jvm.metrics.gcCount&s=10&e=20&r=1",streamProvider.getLastSpec());
Assert.assertEquals(2,PropertyHelper.getProperties(res).size());
Assert.assertNotNull(res.getPropertyValue(PROPERTY_ID));
}