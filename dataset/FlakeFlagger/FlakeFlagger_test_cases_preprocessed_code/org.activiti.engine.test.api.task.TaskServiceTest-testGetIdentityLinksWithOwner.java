public void testGetIdentityLinksWithOwner(){
assertEquals(2,identityLinks.size());
assertEquals("fozzie",assignee.getUserId());
assertNull(assignee.getGroupId());
assertEquals(IdentityLinkType.ASSIGNEE,assignee.getType());
assertEquals("kermit",owner.getUserId());
assertNull(owner.getGroupId());
assertEquals(IdentityLinkType.OWNER,owner.getType());
}