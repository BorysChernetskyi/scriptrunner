package workflows.validators

import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.MutableIssue
import com.example.jira.plugin.runner.workflow.validator.ValidatorComponent
import com.opensymphony.workflow.InvalidInputException

class ExampleValidator extends ValidatorComponent {

    @Override
    run() {

        /**
         * Instead, use {@code throw new InvalidInputException(...)} to throw the exception directly.
         */
        throw new InvalidInputException("")

        /**
         * The issue object before changes have been applied.
         * This can be used to determine if any fields have been changed.
         */
        Issue originalIssue	= getProperty("originalIssue") as Issue

        /**
         * The current issue that this field, function, or method applies to.
         */
        MutableIssue issue	= getProperty("issue") as MutableIssue
    }
}