package com.battagliandrea.lintrules.importrules

object RulesProvider {
    var rulesList: List<InvalidImportRule> = listOf(
        InvalidDomainToPresentationDependencyRule(),
        InvalidDomainToDataDependencyRule(),
        InvalidFeatureImportRule()
    )
}
