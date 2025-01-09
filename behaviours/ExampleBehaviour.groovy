package behaviours

import com.example.jira.plugin.runner.behaviour.BehaviourComponent

class ExampleBehaviour extends BehaviourComponent {

    @Override
    run() {

        com.onresolve.jira.groovy.user.FormField exampleField = getFieldById("customfield_1234")
        Long parentIssueId = getFieldById("parentIssueId").getFormValue() as Long
        com.opensymphony.workflow.loader.ActionDescriptor action = getAction()
        String actionName = getActionName()
        com.atlassian.jira.issue.fields.screen.FieldScreen fieldScreen = getFieldScreen()
        Long contextIssueId = getContextIssueId()
        String FieldChanged = getFieldChanged()
        com.onresolve.jira.groovy.user.FormField fieldByName = getFieldByName("Field Name")
        javax.servlet.http.HttpServletRequest request = getRequest()
        String RequestTypeName = getRequestTypeName()
        com.atlassian.jira.issue.Issue underlyingIssue = getUnderlyingIssue()
        hideTab(Integer tabId)
        hideTab(com.atlassian.jira.issue.fields.screen.FieldScreenTab tab)
        hideTab(String tabName)
        showTab(Integer tabId)
        showTab(com.atlassian.jira.issue.fields.screen.FieldScreenTab tab)
        showTab(String tabName)
      }
}