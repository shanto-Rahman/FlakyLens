@Test public void testEquals() throws Exception {
assertTrue("Properties object is same",properties1 != properties2);
assertTrue("Objects are not equal",properties1.equals(properties2));
assertTrue("Hash codes are not equal",properties1.hashCode() == properties2.hashCode());
assertFalse("Objects are equal",properties1.equals(properties2));
}