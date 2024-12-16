package behaviours

import com.onresolve.jira.behaviours.types.Project
import com.onresolve.jira.groovy.user.FieldBehaviours
import com.atlassian.jira.component.ComponentAccessor

class BehavioursExampleConversions extends FieldBehaviours {

    @Override
    run() {

        getFieldByName("TextFieldA").convertToSingleSelect([ // <1>
             ajaxOptions: [
                     url : getBaseUrl() + "/rest/scriptrunner-jira/latest/issue/picker",
                     query: true, // keep going back to the sever for each keystroke

                     // this information is passed to the server with each keystroke
                     data: [
                             currentJql  : "project = SSPA ORDER BY key ASC", // <2>
                             label       : "Pick high priority issue in Support project", // <3>
                             showSubTasks: false, // <4>

                             // specify maximum number of issues to display, defaults to 10
                             // max       : 5,
                     ],
                     formatResponse: "issue" // <5>
             ],
             css: "max-width: 500px; width: 500px", // <6>
        ])

        getFieldByName("TextFieldB").convertToMultiSelect([ // <1>
            ajaxOptions: [
                    url           : getBaseUrl() + "/rest/scriptrunner/latest/custom/githubRepoQuery", // <2>
                    query         : true, // keep going back to the sever for each keystroke
                    minQueryLength: 4, // <3>
                    keyInputPeriod: 500, // <4>
                    formatResponse: "general", // <5>
            ]
        ])

        getFieldByName("TextFieldC").convertToMultiSelect([
            ajaxOptions: [
                    url           : getBaseUrl() + "/rest/scriptrunner/latest/custom/eventTypes",
                    query         : true,
                    formatResponse: "general"
            ]
        ])

        getFieldByName("TextFieldD").convertToMultiSelect([
                ajaxOptions: [
                        url           : getBaseUrl() + "/rest/scriptrunner/latest/custom/pickRemoteIssue",
                        query         : true,
                        formatResponse: "issue"
                ]
        ])

        getFieldByName("TextFieldD").convertToMultiSelect([ ajaxOptions: [ url : getBaseUrl() + "/rest/scriptrunner/latest/custom/pickRemoteIssue", query: true, formatResponse: "issue" ] ])

        getFieldByName("TextFieldE").convertToMultiSelect([
                ajaxOptions: [
                        url           : getBaseUrl() + "/rest/scriptrunner/latest/custom/listConfluenceSpaces",
                        query         : true,
                        formatResponse: "general"
                ]
        ])

        def selectedProject = getFieldById(getFieldChanged()).value as Project
        def jqlSearchField = getFieldByName("TextFieldA")

        if (selectedProject) {
            jqlSearchField.setReadOnly(false).setDescription("Select an issue in the ${selectedProject.name} project")

            jqlSearchField.convertToSingleSelect([
                    ajaxOptions: [
                            url           : getBaseUrl() + "/rest/scriptrunner-jira/latest/issue/picker",
                            query         : true,

                            data          : [
                                    currentJql: "project = ${selectedProject.key} ORDER BY key ASC", // <1>
                                    label     : "Pick high priority issue in ${selectedProject.name} project",
                            ],
                            formatResponse: "issue"
                    ],
                    css        : "max-width: 500px; width: 500px",
            ])
        } else {
            // selected project was null - disable control
            jqlSearchField.convertToShortText()
            jqlSearchField.setReadOnly(true).setDescription("Please select a project before entering the issue")
        }

        def selectedIssueField = getFieldById(getFieldChanged())
        def selectedIssue = selectedIssueField.value as String
        log.debug("selectedIssue changed: ${selectedIssue}")
        def selectedProject = getFieldByName("ProjectPicker").value as Project

        if (selectedIssue && selectedProject) {

            def jqlQueryBuilder = JqlQueryBuilder.newBuilder()
            def searchService = ComponentAccessor.getComponent(SearchService)
            def user = ComponentAccessor.jiraAuthenticationContext.getLoggedInUser()

            def query = jqlQueryBuilder.where().project(selectedProject.id).and().issue(selectedIssue).buildQuery() // <1>
            if (searchService.searchCount(user, query) == 1) { // <2>
                selectedIssueField.clearError()
            } else {
                selectedIssueField.setError("Issue not found in the selected project")
            }
        }
    }
}