public void testGetIdentityLinksWithAssignee(){
assertEquals(1,identityLinks.size());
assertEquals("kermit",identityLinks.get(0).getUserId());
assertNull(identityLinks.get(0).getGroupId());
assertEquals(IdentityLinkType.ASSIGNEE,identityLinks.get(0).getType());
}