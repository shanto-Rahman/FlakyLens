@Test(expected=InvalidGroupNameException.class) public void testGetInvalidGroup(){
Assert.assertFalse(victim.getGroups().isEmpty());
}