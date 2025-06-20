@Test public void replaceWithJoran() throws JoranException {
assertNotNull(sla);
assertEquals(1,sla.strList.size());
assertEquals("And the number is XXXX, expiring on 12/2010",sla.strList.get(0));
}