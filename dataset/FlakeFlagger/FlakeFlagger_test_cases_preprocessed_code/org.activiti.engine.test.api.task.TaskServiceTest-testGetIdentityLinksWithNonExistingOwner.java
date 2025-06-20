public void testGetIdentityLinksWithNonExistingOwner(){
assertEquals(2,identityLinks.size());
assertEquals("nonExistingAssignee",assignee.getUserId());
assertNull(assignee.getGroupId());
assertEquals(IdentityLinkType.ASSIGNEE,assignee.getType());
assertEquals("nonExistingOwner",owner.getUserId());
assertNull(owner.getGroupId());
assertEquals(IdentityLinkType.OWNER,owner.getType());
}