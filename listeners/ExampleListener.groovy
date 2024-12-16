package listeners

import com.atlassian.jira.event.issue.IssueEvent
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.comments.Comment
import com.riadalabs.jira.plugins.insight.services.events.objects.InsightObjectAsyncEvent
import com.riadalabs.jira.plugins.insight.services.events.objects.event.InsightObjectCreatedEvent
import com.riadalabs.jira.plugins.insight.services.events.objects.event.InsightObjectUpdatedEvent

/**
 * Represents the event object that triggered the event listener.
 *
 * This variable is only present in the context of event listeners and
 * holds the {@link java.lang.Object} representing the specific event.
 */
class ExampleListener extends Script {

    @Override
    run() {

        /**
         * Provides various details and related objects for an event.
         *
         * Methods available:
         *
         * - {@link org.ofbiz.core.entity.GenericValue} {@code getChangeLog()}:
         *   Retrieves the change log associated with the event.
         *   List history = event.getChangeLog().getRelated("ChildChangeItem")
         *
         * - {@link com.atlassian.jira.issue.comments.Comment} {@code getComment()}:
         *   Retrieves the comment associated with the event.
         *
         * - {@link java.lang.Long} {@code getEventTypeId()}:
         *   Retrieves the ID of the event type.
         *
         * - {@link com.atlassian.jira.issue.Issue} {@code getIssue()}:
         *   Retrieves the issue associated with the event.
         *
         * - {@link com.atlassian.jira.project.Project} {@code getProject()}:
         *   Retrieves the project associated with the event.
         *
         * - {@link java.util.Optional}<{@link com.atlassian.jira.event.operation.SpanningOperation}> {@code getSpanningOperation()}:
         *   Gets the spanning operation that this event is part of, if any.
         *
         * - {@link com.atlassian.jira.user.ApplicationUser} {@code getUser()}:
         *   Returns the user who initiated this event.
         *
         * - {@link com.atlassian.jira.issue.worklog.Worklog} {@code getWorklog()}:
         *   Retrieves the worklog associated with the event.
         */
        IssueEvent issueEvent = getProperty("event") as IssueEvent
        MutableIssue issue = getProperty("issue") as MutableIssue
        Comment comment = getProperty("comment") as Comment
        InsightObjectAsyncEvent assetEvent = getProperty("event") as InsightObjectAsyncEvent

        if ( assetEvent instanceof InsightObjectCreatedEvent ){

            /**
             * Additional methods available for the event object:
             *
             * - {@link com.riadalabs.jira.plugins.insight.services.model.ObjectBean} {@code event.getObjectBean()}:
             *   Retrieves the main object bean associated with the event.
             *
             * - {@link com.atlassian.jira.user.ApplicationUser} {@code event.getRunAsUser()}:
             *   Retrieves the user under whose context the event is being executed.
             */
            assetEvent.getRunAsUser()
            assetEvent.getObjectBean()
        } else if ( assetEvent instanceof InsightObjectUpdatedEvent ){

            /**
             * Additional methods available for the event object:
             *
             * - {@link com.riadalabs.jira.plugins.insight.services.model.ObjectBean} {@code event.getObjectBean()}:
             *   Retrieves the main object bean associated with the event.
             *
             * - {@link com.atlassian.jira.user.ApplicationUser} {@code event.getRunAsUser()}:
             *   Retrieves the user under whose context the event is being executed.
             *
             * - {@link List}<{@link com.riadalabs.jira.plugins.insight.services.model.ObjectUpdateBean}> {@code event.getObjectUpdateBeans()}:
             *   Retrieves a list of update beans representing the changes made during this event.
             */
            assetEvent.getRunAsUser()
            assetEvent.getObjectBean()
            assetEvent.getObjectUpdateBeans()
        }

        /**
         * Represents a change item entity with detailed metadata and state information.
         *
         * Fields:
         *
         * - {@code delegatorName} (String):
         *   The name of the delegator, typically "default".
         *
         * - {@code internalDelegator} ({@link org.ofbiz.core.entity.GenericDelegator}):
         *   The internal delegator instance managing the entity.
         *   Example: {@code org.ofbiz.core.entity.GenericDelegator@7f0cdf7}.
         *
         * - {@code fields} (Map<String, Object>):
         *   A map containing the field details for the change item, including:
         *   - {@code newvalue} (String): The new value for the field. Example: "2".
         *   - {@code field} (String): The field name. Example: "priority".
         *   - {@code oldstring} (String): The old string value. Example: "Medium".
         *   - {@code newstring} (String): The new string value. Example: "High".
         *   - {@code id} (Long): The ID of the change. Example: "11817".
         *   - {@code fieldtype} (String): The type of the field. Example: "jira".
         *   - {@code oldvalue} (String): The old value for the field. Example: "3".
         *   - {@code group} (Long): The group ID. Example: "11817".
         *
         * - {@code entityName} (String):
         *   The name of the entity. Example: "ChangeItem".
         *
         * - {@code modelEntity} ({@link org.ofbiz.core.entity.model.ModelEntity}):
         *   The model entity instance representing metadata/schema for this entity.
         *   Example: {@code org.ofbiz.core.entity.model.ModelEntity@7f6b3719}.
         *
         * - {@code modified} (boolean):
         *   Indicates whether the entity has been modified. Default: {@code false}.
         *
         * - {@code relatedCache} (Object):
         *   Cache for related entities. Example: {@code null}.
         *
         * - {@code relatedOneCache} (Object):
         *   Cache for related "one-to-one" entities. Example: {@code null}.
         *
         * - {@code originalDbValues} (Map<String, Object>):
         *   The original database values of the fields. Example:
         *   - {@code newvalue: 2}, {@code field: priority}, {@code oldstring: Medium},
         *     {@code newstring: High}, {@code id: 11817}, {@code fieldtype: jira},
         *     {@code oldvalue: 3}, {@code group: 11817}.
         *
         * - {@code allFields} (Map<String, Object>):
         *   A map containing all field details, identical to {@code fields}.
         *
         * - {@code allKeys} (List<String>):
         *   A list of all keys in the fields map. Example:
         *   {@code [newvalue, field, oldstring, newstring, id, fieldtype, oldvalue, group]}.
         *
         * - {@code class} (Class<?>):
         *   The runtime class of the entity. Example: {@code class org.ofbiz.core.entity.GenericValue}.
         *
         * - {@code delegator} ({@link org.ofbiz.core.entity.GenericDelegator}):
         *   The delegator instance managing the entity. Example: {@code org.ofbiz.core.entity.GenericDelegator@7f0cdf7}.
         *
         * - {@code empty} (boolean):
         *   Indicates whether the entity is empty. Example: {@code false}.
         *
         * - {@code primaryKey} (boolean):
         *   Indicates whether the entity represents a primary key. Example: {@code false}.
         */
    }
}