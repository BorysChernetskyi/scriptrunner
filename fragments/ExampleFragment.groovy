package fragments

import com.atlassian.jira.issue.Issue
import com.atlassian.jira.plugin.webfragment.model.JiraHelper
import com.atlassian.servicedesk.api.requesttype.RequestType

class ExampleFragment extends Script {

    @Override
    run() {

        //Condition
        /**
         * The current issue that this field, method, or functionality applies to.
         */
        Issue issue = getProperty("issue") as Issue
        /**
         * Provides access to various context-related variables in Jira.
         * This variable can be used to retrieve details such as project information,
         * query parameters, and other relevant data within the Jira context.
         */
        JiraHelper jiraHelper = getProperty("jiraHelper") as JiraHelper

        //Provider class/script
        /**
         * A Groovy {@link java.io.Writer} used for writing character data.
         * <p>
         * This writer can be used to output text data to various destinations, such as files,
         * streams, or in-memory buffers. It supports standard writing operations and can be
         * extended for custom behavior.
         * </p>
         * Example usage:
         * <pre>{@code
         * def writer = new StringWriter()
         * writer.write("Hello, World!")
         * println writer.toString() // Outputs: Hello, World!
         * }</pre>
         */
        Writer writer = getProperty("writer") as Writer
        /**
         * A Groovy context object providing access to various runtime variables and execution details.
         * <p>
         * This object can be used to interact with and retrieve data such as project information,
         * query parameters, user session details, and other contextual information during script execution.
         * </p>
         * Example usage:
         * <pre>{@code
         * def project = context.project
         * def user = context.currentUser
         * println "Current project: ${project.name}, User: ${user.username}"
         * }</pre>
         * Use this variable to get access to many other variables in the context, including project, query parameters, and more.
         */
        Map context = getProperty("context") as Map
        Issue issue = context.get("issue") as Issue
        RequestType requestType = context["requestType"] as RequestType
        Integer requestTypeId = context["requestTypeId"] as Integer
    }
}