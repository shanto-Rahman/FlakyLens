@Deployment public void testCustomIdentityLink(){
assertEquals(1,tasks.size());
assertEquals(2,identityLinks.size());
assertEquals("businessAdministrator",idLink.getType());
if (userId == null) {
assertEquals("management",idLink.getGroupId());
assertEquals("kermit",userId);
}
}