package workflows.postfunctions

import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.user.ApplicationUser

class ExampleCreateIssue extends Script {

    @Override
    run() {

        /**
         * Represents the current issue to which this field, function, or operation applies.
         * The {@code issue} object allows you to access and manipulate the issue's properties and fields.
         * Example Usage:
         * <pre>{@code
         * MutableIssue issue = getCurrentIssue();
         * log.info("Issue Key: " + issue.getKey());
         * log.info("Issue Summary: " + issue.getSummary());
         * issue.setSummary("Updated Summary"); // Modify the issue's summary
         * }</pre>
         * @property issue The {@link MutableIssue} object representing the current issue.
         * @see MutableIssue For details on methods to access and modify issue properties.
         * The current issue that this field/function/etc applies to
         */
        MutableIssue issue = getProperty("issue") as MutableIssue

        /**
         * Represents the current authenticated user.
         * If no user is authenticated, this variable will be {@code null}.
         * Example Usage:
         * <pre>{@code
         * ApplicationUser currentUser = getCurrentUser();
         * if (currentUser != null) {
         *     System.out.println("Текущий пользователь: " + currentUser.getUsername());
         * } else {
         *     System.out.println("Пользователь не авторизован");
         * }
         * }</pre>
         * @property currentUser The {@link ApplicationUser} object representing the current user,
         *                       or {@code null} if no user is authenticated.
         * @see ApplicationUser For details on user properties such as username, email, and roles.
         */
        ApplicationUser currentUser = getProperty("currentUser") as ApplicationUser

        /**
         * Represents the original issue object before any changes have been applied.
         * This can be used to compare and detect changes made to the issue during updates.
         * Example Usage:
         * <pre>{@code
         * if (originalIssue.getSummary() != issue.getSummary()) {
         *     log.info('Summary has been updated from: ' + originalIssue.getSummary() + ' to: ' + issue.getSummary())
         * }
         * }</pre>
         * @property originalIssue The {@link Issue} object as it existed before changes.
         * @see Issue For details on accessing issue properties and methods.
         * The issue object before changes have been applied... you can use this to see if fields have been changed
         */
        Issue originalIssue = getProperty("originalIssue") as Issue

        /**
         * Represents the source issue used during operations such as cloning an issue or creating a subtask.
         * In cases where a new issue is created, this variable refers to the newly created issue.
         * Example Usage:
         * <pre>{@code
         * sourceIssue = { issue ->
         * log.info('Source issue key: ' + issue.key)
         * }
         * }</pre>
         * @property sourceIssue The source {@link Issue} object.
         * @see Issue For details on accessing issue properties and methods.
         * The source issue, for cloning issues and creating a subtask. In this case the issue variable refers to the newly-created issue */
         *//
        Issue sourceIssue = getProperty("sourceIssue") as Issue

        /**
         * Closure executed after the creation of a new issue.
         * Provides access to the newly created issue and allows custom logic to be executed.
         * Example Usage:
         * <pre>{@code
         * doAfterCreate = { issue ->
         *     UserMessageUtil.success('New issue created: ' + issue.key)
         * }
         * }</pre>
         * @param issue The newly created issue object. Allows access to issue details such as key, fields, etc.
         * @throws Exception if any error occurs during the execution of the closure.
         */
        setProperty("doAfterCreate",[
                //code
        ])
    }
}