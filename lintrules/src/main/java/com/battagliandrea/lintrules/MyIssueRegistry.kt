package com.battagliandrea.lintrules

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue
import com.battagliandrea.lintrules.importrules.ISSUE_IMPORT_DETECTOR

class MyIssueRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            ISSUE_IMPORT_DETECTOR
        )
}
