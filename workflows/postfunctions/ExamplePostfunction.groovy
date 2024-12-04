package workflows.postfunctions

import com.atlassian.jira.issue.ModifiedValue
import com.atlassian.jira.issue.MutableIssue

class ExamplePostfunction extends Script {

    @Override
    run() {

        MutableIssue issue = getProperty("issue") as MutableIssue
        /**
         * Retrieves a map of issue fields whose values have been modified since the object was created or since the last
         * {@code resetModifiedFields()} call.
         * @return a map containing the modified issue fields and their updated values.
         * Retrieves a map of issue fields whose values have been modified since the object was created or since the last
         * {@code resetModifiedFields()} call.
         * @return a map of key-value pairs where the keys are field identifiers defined in {@code IssueFieldConstants},
         * and the values are {@link ModifiedValue} objects that are field-specific.
         */
        Map<String,ModifiedValue> modifiedFields = issue.getModifiedFields() as Map<String,ModifiedValue>

        /**
         * Retrieves a map of issue fields whose values have been modified since the object was created or since the last
         * {@code com.atlassian.jira.issue.getModifiedValue()} call.
         * @return a map of modified issue fields and their {@link ModifiedValue} objects.
         * Constructs a field modification pair representing the old and new values of a field.
         * The objects provided are field-specific, for example, from {@code CustomField.getValue(com.atlassian.jira.issue.Issue)}.
         * com.atlassian.jira.issue.ModifiedValue<V>
         * @param oldValue the original value of the field before modification
         * @param newValue the new value of the field after modification
         * Construct a field modification pair. Objects are field-specific, eg. from CustomField.getValue(com.atlassian.jira.issue.Issue)
         */
        ModifiedValue modifiedValue = modifiedFields["customfield_1234"]
        modifiedValue.getNewValue()
        modifiedValue.getOldValue()
    }
}